package MyGame;

import java.awt.*;
import javax.swing.*;

    //pallina che non c'è l'ha fatta

public class Ball extends Rectangle {

    public Ball(int x, int y, int height, int width){

        super(x, y, height, width);   //costruttore della pallina

    }//chiusura del costruttore

    public void draw(Graphics g){

        g.setColor(Color.cyan);
        g.fillOval(x, y, width, height);

    }
    public void move(){

       x=x+1;
       y=y-1;

    }


}//endl class ball
