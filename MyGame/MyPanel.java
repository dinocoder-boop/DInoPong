package MyGame;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
    
    Ball pallinaCheNonCeLhaFatta;  

    public MyPanel(){

        this.setBackground(Color.BLACK);  //colora lo sfondo di nero

        pallinaCheNonCeLhaFatta = new Ball(200,125,10,10); //creazione della pallina (che non c'è l'ha fatta nemmeno questa volta)

    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        pallinaCheNonCeLhaFatta.draw(g); //colorazione della pallina (a fare questo c'è l'ha fatta)

    }

}
