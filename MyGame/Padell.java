package MyGame;

import java.awt.*;

public class Padell extends Rectangle {


    int dy;
    final int paddleSpeed = 20;

    public Padell(int x, int y, int width, int height){

        super(x,y,width, height);

    }

    public void setDY(int direction){

        dy = direction * paddleSpeed;

    }

    public void move(){

        y = y+dy;

    }

    public void draw(Graphics g){

        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);

    }

    
}
