package MyGame;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class MyPanel extends JPanel implements Runnable{
    
    Thread gameThread;  //crea un oggetto Thread per permettere un processo 
    
    //Ball pallinaCheNonCeLhaFatta;  //crea un oggeto di tipo Ball
    int ballH = 10;
    int ballL = 10;
    int nBall = 150;
    Ball[] palline = new Ball[nBall];
    
    int W = 1200;
    int H = 1200;
   Dimension Area = new Dimension(W,H);

    Random X;
    Random Y;

    public MyPanel(){

       Y = new Random();
       X = new Random();

        gameThread = new Thread(this);  //inizializzo l'oggetto 
        gameThread.start();  

        this.setBackground(Color.BLACK);  //colora lo sfondo di nero

        this.setFocusable(true);        
        this.setPreferredSize(Area);

        //pallinaCheNonCeLhaFatta = new Ball(X.nextInt(450),Y.nextInt(450),10,10); //creazione della pallina (che non c'è l'ha fatta nemmeno questa volta)

        for (int i=0; i< nBall; i++)
        palline[i] = new Ball(320,240,ballH,ballL, i);
    

    }//chiude il costruttore

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        
        //pallinaCheNonCeLhaFatta.draw(g); //colorazione della pallina (a fare questo c'è l'ha fatta)

        for (int i=0; i< nBall; i++)
        palline[i].draw(g);
    

        Toolkit.getDefaultToolkit().sync();
    }//chiude paintComponent


    public void move(){

        for(int i=0; i<nBall; i++)
            palline[i].move();


    }

    public void checkCollisions() {
		
		for (int i=0; i< nBall; i++) {
			
			if (palline[i].x < 0) palline[i].dx = -palline[i].dx;
			if (palline[i].x > W - ballL) palline[i].dx = -palline[i].dx;
			if (palline[i].y < 0) palline[i].dy = -palline[i].dy;
			if (palline[i].y > H - ballH) palline[i].dy = -palline[i].dy;
	
		}
		
	}


    public void run(){

        long lastTime = System.nanoTime();

        double FPS = 25;

        double interval = 1000000000/FPS; // 400000000
		

    
        while(true){

            long now = System.nanoTime();

            interval += (now - lastTime);

            lastTime = now;

            if(interval >= 40000000){

                move();

                checkCollisions();

                repaint();

                interval = 0;

           }//chiude l'if

        }//chiude il while
   
    }//chiude il run

}//chiude la classe
