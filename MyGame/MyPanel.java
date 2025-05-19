package MyGame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;


import java.io.*;
import javax.sound.sampled.*;

public class MyPanel extends JPanel implements Runnable, KeyListener{



    //int GAME_HEIGHT = 900;
    //int GAME_WIDTH = 768;

    final int GAME_HEIGHT = 800;
    final int GAME_WIDTH = 1240;
    
    final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    
    final int BALL_WIDTH = 20;
    final int BALL_HEIGHT = 20;
   // final int BALL_DIAMETER = 10;


    Padell padell1,padell2;

    final int PADELL_WIDTH = 20;
    final int PADELL_HEIGHT = 150;



    final int border_distance = 25;

    Border border;

    Ball pallinaCheNonCeLhaFatta;

    Punteggio punti;
    

    Thread gameThread;  //crea un oggetto Thread per permettere un processo 



    public MyPanel(){

        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(SCREEN_SIZE);


        border = new LineBorder(Color.GREEN, 2);
        this.setBorder(border);


        pallinaCheNonCeLhaFatta = new Ball((GAME_WIDTH/2-BALL_WIDTH/2),(GAME_HEIGHT/2-BALL_HEIGHT/2), BALL_WIDTH, BALL_HEIGHT);
        

        padell1 = new Padell(((GAME_WIDTH-GAME_WIDTH)+PADELL_WIDTH),(GAME_HEIGHT/2-PADELL_HEIGHT/2)-border_distance, PADELL_WIDTH, PADELL_HEIGHT);
        padell2 = new Padell((GAME_WIDTH-PADELL_WIDTH)-PADELL_WIDTH,(GAME_HEIGHT/2-PADELL_HEIGHT/2)-border_distance, PADELL_WIDTH, PADELL_HEIGHT);
 
        punti = new Punteggio(GAME_HEIGHT, GAME_WIDTH);
 
 
        /*       this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                GAME_WIDTH = getWidth();
                GAME_HEIGHT = getHeight();
            }
          });*/

        this.addKeyListener(this);

        gameThread = new Thread(this);
        gameThread.start();

    }//chiude il costruttore

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        pallinaCheNonCeLhaFatta.draw(g);

        padell1.draw(g);
        padell2.draw(g);

        punti.draw(g);

        Toolkit.getDefaultToolkit().sync();

    }//chiude paintComponent

    public void checkCollisions() {
	
		// Se colpisce il bordo sinistro
		if (pallinaCheNonCeLhaFatta.x < 0) {
			// Respawn al centro
			pallinaCheNonCeLhaFatta = new Ball(GAME_WIDTH/2 - BALL_WIDTH/2, GAME_HEIGHT/2 - BALL_HEIGHT/2, BALL_WIDTH, BALL_HEIGHT);
			pallinaCheNonCeLhaFatta.setDX(1);

        	//-----play sound ------ 
			playSound("point.wav"); 
			//----------------------

            punti.addPointP2(); 

		}

		// Se colpisce il bordo destro
		if (pallinaCheNonCeLhaFatta.x > GAME_WIDTH - BALL_WIDTH) {
			// Respawn al centro
			pallinaCheNonCeLhaFatta = new Ball(GAME_WIDTH/2 - BALL_WIDTH/2, GAME_HEIGHT/2 - BALL_HEIGHT/2, BALL_WIDTH, BALL_HEIGHT);
			pallinaCheNonCeLhaFatta.setDX(-1);

            //-----play sound ------ 
			playSound("point.wav"); 
			//----------------------

            punti.addPointP1();

		}

		// Rimbalza solo su soffitto e fondo
		if (pallinaCheNonCeLhaFatta.y < 0) { 
			pallinaCheNonCeLhaFatta.dy = -pallinaCheNonCeLhaFatta.dy;

            //-----play sound ------ 
			playSound("boundary.wav"); 
			//----------------------

		}
		
		if (pallinaCheNonCeLhaFatta.y > GAME_HEIGHT - BALL_HEIGHT) {
			pallinaCheNonCeLhaFatta.dy = -pallinaCheNonCeLhaFatta.dy;

            //-----play sound ------ 
			playSound("boundary.wav"); 
			//----------------------

		}





		if (pallinaCheNonCeLhaFatta.intersects(padell1)) {
			
			pallinaCheNonCeLhaFatta.dx = -(pallinaCheNonCeLhaFatta.dx);
			// Sposta la pallina subito fuori dal padell1

                      System.out.println(pallinaCheNonCeLhaFatta.dx);

            System.out.println();
            System.out.println("pallina colpita");
			System.out.println(pallinaCheNonCeLhaFatta.hits);
            System.out.println();

			pallinaCheNonCeLhaFatta.hits++;

            //-----play sound ------ 
			playSound("paddle.wav"); 
			//----------------------
/*
			if (pallinaCheNonCeLhaFatta.hits>4)     pallinaCheNonCeLhaFatta.setDX(-(pallinaCheNonCeLhaFatta.dx+2));
			
            if (pallinaCheNonCeLhaFatta.hits>=4 && pallinaCheNonCeLhaFatta.hits<12)     pallinaCheNonCeLhaFatta.setDX(-1.6);
		
            if (pallinaCheNonCeLhaFatta.hits>=12)   pallinaCheNonCeLhaFatta.setDX(-2);
*/
        }



		if (pallinaCheNonCeLhaFatta.intersects(padell2)) {
			pallinaCheNonCeLhaFatta.dx = -pallinaCheNonCeLhaFatta.dx;
			// Sposta la pallina subito fuori dal padell2
			pallinaCheNonCeLhaFatta.hits++;

            //-----play sound ------ 
			playSound("paddle.wav"); 
			//----------------------
			

        }



/*






            System.out.println();
            System.out.println("pallina colpita");
			System.out.println(pallinaCheNonCeLhaFatta.hits);
            System.out.println();
            

			
		}

		if (pallinaCheNonCeLhaFatta.intersects(padell2)) {
			pallinaCheNonCeLhaFatta.dx = -pallinaCheNonCeLhaFatta.dx;
			// Sposta la pallina subito fuori dal padell2
			pallinaCheNonCeLhaFatta.x = padell2.x - BALL_WIDTH;
			pallinaCheNonCeLhaFatta.hits++;
			
			if (pallinaCheNonCeLhaFatta.hits<4) 
				pallinaCheNonCeLhaFatta.setDX(1);
			if (pallinaCheNonCeLhaFatta.hits>=4 && pallinaCheNonCeLhaFatta.hits<12) 
				pallinaCheNonCeLhaFatta.setDX(1.6);
			if (pallinaCheNonCeLhaFatta.hits>=12) 
				pallinaCheNonCeLhaFatta.setDX(2);
		}


        
	/*	if (pallinaCheNonCeLhaFatta.x > GAME_WIDTH - BALL_WIDTH)
			pallinaCheNonCeLhaFatta.dx = -pallinaCheNonCeLha.dx;
		if (pallinaCheNonCeLhaFatta.x < 0)
			pallinaCheNonCeLha.dx = -pallinaCheNonCeLha.dx;
		if (pallinaCheNonCeLhaFatta.y < 0)
			pallinaCheNonCeLha.dy = -pallinaCheNonCeLha.dy;
		if (pallinaCheNonCeLhaFatta.y > GAME_HEIGHT - BALL_HEIGHT)
			pallinaCheNonCeLha.dy = -pallinaCheNonCeLha.dy;
   */


        if (padell1.y < 0)	padell1.y=2;

        if (padell1.y > GAME_HEIGHT-PADELL_HEIGHT )      padell1.y = GAME_HEIGHT-PADELL_HEIGHT+1;

        if (padell2.y < 0)	padell2.y=2;

        if (padell2.y > GAME_HEIGHT-PADELL_HEIGHT )      padell2.y = GAME_HEIGHT-PADELL_HEIGHT+1;
			  
	}


    public void move(){

        pallinaCheNonCeLhaFatta.move();
        
        padell1.move();

        padell2.move();

    }


    public void run(){

        long lastTime = System.nanoTime();

        double FPS = 60.0;
                           
        double  interval = 1000000000/FPS; // 400000000
		

    
        while(true){

            long now = System.nanoTime();

            
            if(now-lastTime > interval){

                move();

                checkCollisions();

                repaint();

                lastTime = now;

           }//chiude l'if

        }//chiude il while
   
    }//chiude il run

    @Override
    public void keyPressed(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_UP)  {System.out.println("key up");padell2.setDY(-1);}
        if(e.getKeyCode() == KeyEvent.VK_DOWN){System.out.println("key up");padell2.setDY(+1);}

        if(e.getKeyCode() == KeyEvent.VK_W)  {System.out.println("key up");padell1.setDY(-1);}
        if(e.getKeyCode() == KeyEvent.VK_S){System.out.println("key up");padell1.setDY(+1);}
    }

    @Override
    public void keyReleased(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_UP){System.out.println("key down"); padell2.setDY(0);}
        if(e.getKeyCode() == KeyEvent.VK_DOWN){System.out.println("key down"); padell2.setDY(0);}

        if(e.getKeyCode() == KeyEvent.VK_W){System.out.println("key down"); padell1.setDY(0);}
        if(e.getKeyCode() == KeyEvent.VK_S){System.out.println("key down"); padell1.setDY(0);}

    }

    @Override
	public void keyTyped(KeyEvent e){}

    	public void playSound(String name) { try {
        Clip suono = AudioSystem.getClip();
        suono.open(AudioSystem.getAudioInputStream(getClass().getResource(name)));
        suono.start();
       }
    catch (Exception exc) {
         exc.printStackTrace(System.out);
       }
	} //end playSound()

}//chiude la classe
