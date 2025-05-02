package MyGame;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

    //pallina che non c'è l'ha fatta

public class Ball extends Rectangle {


    
     int dx;
     int dy;
     int index;

    public Ball(int x, int y, int height, int width, int index){

        super(x, y, height, width);   //costruttore della pallina
        this.index = index;

            Random a = new Random();
            
            do {
                dx = (a.nextInt(21) - 10)+1; // Random value between -10 and 10
            } while (dx == 0);
        
            do {
                dy = (a.nextInt(21) - 10)+1; // Random value between -10 and 10
            } while (dy == 0);


    }

    public void draw(Graphics g){

        if (index%5 == 0) g.setColor(Color.CYAN);
		if (index%5 == 1) g.setColor(Color.WHITE);
		if (index%5 == 2) g.setColor(Color.RED);
		if (index%5 == 3) g.setColor(Color.GREEN);
		if (index%5 == 4) g.setColor(Color.YELLOW);           //metodo per disegnare la pallina che non c'è l'ha fatta
        g.fillOval(x, y, width, height);

    }
    public void move(){

       // x = (int)(x * (1+a.nextDouble()));
       // y = (int)(y * (1+a.nextDouble()));

       x = x+dx;
       y = y+dy;

    }


}//endl class ball
