package MyGame;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
    //pallina che non c'ha fatta

public class Ball extends Rectangle {

    int dx;
    int dy;
    Random roulet;

    public int hits;

    final int ballSpeed = 5;


    public Ball(int x, int y, int height, int width){

        super(x, y, height, width);   //costruttore della pallina
        
        roulet = new Random();


        int direzione_iniziale = roulet.nextInt(2);

		if (direzione_iniziale==0) direzione_iniziale=-1;

		setDX(direzione_iniziale);
		setDY(direzione_iniziale);
        
    }//chiusura del costruttore

    public void draw(Graphics g){

        g.setColor(Color.cyan);
        g.fillRect(x, y, width, height);

    }
    
    public void move(){

       x=x+dx;
       y=y+dy;

    }

   public void setDX(double direzione){

		dx = (int)(direzione * ballSpeed);
    }

    public void setDY(double direzione){

		dy = (int)(direzione * ballSpeed);


    }



}//endl class ball
