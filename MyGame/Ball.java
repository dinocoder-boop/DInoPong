package MyGame;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
    //pallina che non c'è l'ha fatta

public class Ball extends Rectangle {

    int dx;
    int dy;
    Random roulet;


    public Ball(int x, int y, int height, int width){

        super(x, y, height, width);   //costruttore della pallina
        
        roulet = new Random();

        dx = roulet.nextInt(10);
        dy = roulet.nextInt(10);

        boolean direzione = roulet.nextBoolean();

        if(direzione == true){

            dy = -dy;

        }
        
    }//chiusura del costruttore

    public void draw(Graphics g){

        g.setColor(Color.cyan);
        g.fillRect(x, y, width, height);

    }
    
    public void move(){

       x=x+dx;
       y=y+dy;

    }


}//endl class ball
