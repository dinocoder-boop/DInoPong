package MyGame;

import java.awt.*;
import javax.swing.*;

    //pallina che non c'è l'ha fatta

public class Ball extends Rectangle {
    
    public Ball(int x, int y, int height, int width){

        super(x, y, height, width);   //costruttore della pallina

    }

    public void draw(Graphics g){

        g.setColor(Color.CYAN);             //metodo per disegnare la pallina che non c'è l'ha fatta
        g.fillRect(x, y, width, height);

    }
}//endl class ball
