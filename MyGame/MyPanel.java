package MyGame;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class MyPanel extends JPanel implements Runnable{
    
    Thread gameThread;  //crea un oggetto Thread per permettere un processo 
    
    Ball pallinaCheNonCeLhaFatta;  //crea un oggeto di tipo Ball

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

        pallinaCheNonCeLhaFatta = new Ball(X.nextInt(450),Y.nextInt(450),10,10); //creazione della pallina (che non c'è l'ha fatta nemmeno questa volta)

    }//chiude il costruttore

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        pallinaCheNonCeLhaFatta.draw(g); //colorazione della pallina (a fare questo c'è l'ha fatta)

        Toolkit.getDefaultToolkit().sync();
    }//chiude paintComponent

    public void run(){

        long lastTime = System.nanoTime();

        double FPS = 5;

        double interval = 0;

    
        while(true){

            long now = System.nanoTime();

            interval += (now - lastTime);

            lastTime = now;

            if(interval >= 40000000){

                pallinaCheNonCeLhaFatta.move();

                repaint();

                interval = 0;

           }//chiude l'if

        }//chiude il while
   
    }//chiude il run

}//chiude la classe 
