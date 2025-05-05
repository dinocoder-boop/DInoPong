package MyGame;

import java.awt.*;
import java.util.Random;

import javax.swing.*;


public class MyPanel extends JPanel implements Runnable{

    Ball pallinaCheNonCeLhaFatta;

    final int GAME_HEIGHT = 640;
    final int GAME_WIDTH = 480;
    
    final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    
    final int BALL_WIDTH = 20;
    final int BALL_HEIGHT = 20;
    final int BALL_DIAMETER = 10;


    Thread gameThread;  //crea un oggetto Thread per permettere un processo 


    public MyPanel(){

        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(SCREEN_SIZE);

        pallinaCheNonCeLhaFatta = new Ball(320, 240, HEIGHT, WIDTH);

        gameThread = new Thread(this);
        gameThread.start();

    }//chiude il costruttore

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        pallinaCheNonCeLhaFatta.draw(g);

        Toolkit.getDefaultToolkit().sync();

    }//chiude paintComponent


    public void move(){

        pallinaCheNonCeLhaFatta.move();

    }


    public void run(){

        long lastTime = System.nanoTime();

        double FPS = 25.0;
                           
        double interval = 1000000000/FPS; // 400000000
		

    
        while(true){

            long now = System.nanoTime();

            
            if(now-lastTime > interval){

                move();

                repaint();

                lastTime = now;

           }//chiude l'if

        }//chiude il while
   
    }//chiude il run

}//chiude la classe
