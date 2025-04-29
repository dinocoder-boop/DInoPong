package MyGame;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

    //pallina che non c'è l'ha fatta

public class Ball extends Rectangle {

    Random a;
    
     int dx;
     int dy;

    public Ball(int x, int y, int height, int width){

        super(x, y, height, width);   //costruttore della pallina

        a = new Random();
          dx = a.nextInt(21)-10;
          dy = a.nextInt(21)-10;

    }

    public void draw(Graphics g){

        g.setColor(Color.CYAN);             //metodo per disegnare la pallina che non c'è l'ha fatta
        g.fillRect(x, y, width, height);

    }
    public void move(){

       // x = (int)(x * (1+a.nextDouble()));
       // y = (int)(y * (1+a.nextDouble()));

       x = x+dx;
       y = y+dy;

    }


}//endl class ball
