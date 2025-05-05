package MyGame;

import java.awt.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;


public class MyPanel extends JPanel implements Runnable{

    Ball pallinaCheNonCeLhaFatta;

    int GAME_HEIGHT = 640;
    int GAME_WIDTH = 480;
    
    final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    
    final int BALL_WIDTH = 20;
    final int BALL_HEIGHT = 20;
    final int BALL_DIAMETER = 10;

    Border border;

    

    Thread gameThread;  //crea un oggetto Thread per permettere un processo 


    public MyPanel(){

        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(SCREEN_SIZE);

        border = new LineBorder(Color.GREEN, 2);
        this.setBorder(border);
        pallinaCheNonCeLhaFatta = new Ball((GAME_WIDTH/2-BALL_WIDTH/2),(GAME_HEIGHT/2-BALL_HEIGHT/2), BALL_WIDTH, BALL_HEIGHT);

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                GAME_WIDTH = getWidth();
                GAME_HEIGHT = getHeight();
            }
        });

        gameThread = new Thread(this);
        gameThread.start();

    }//chiude il costruttore

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        pallinaCheNonCeLhaFatta.draw(g);

        Toolkit.getDefaultToolkit().sync();

    }//chiude paintComponent

    public void checkCollisions() {
		
		if (pallinaCheNonCeLhaFatta.x > GAME_WIDTH - BALL_WIDTH)
			pallinaCheNonCeLhaFatta.dx = -pallinaCheNonCeLhaFatta.dx;
		if (pallinaCheNonCeLhaFatta.x < 0)
			pallinaCheNonCeLhaFatta.dx = -pallinaCheNonCeLhaFatta.dx;
		if (pallinaCheNonCeLhaFatta.y < 0)
			pallinaCheNonCeLhaFatta.dy = -pallinaCheNonCeLhaFatta.dy;
		if (pallinaCheNonCeLhaFatta.y > GAME_HEIGHT - BALL_HEIGHT)
			pallinaCheNonCeLhaFatta.dy = -pallinaCheNonCeLhaFatta.dy;
	}


    public void move(){

        pallinaCheNonCeLhaFatta.move();

    }


    public void run(){

        long lastTime = System.nanoTime();

        double FPS = 25.0;
                           
        double interval = 100000000/FPS; // 400000000
		

    
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

}//chiude la classe
