package MyGame;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    
    MyPanel p;

    public MyFrame(){
        
        p = new MyPanel();//insatnzio parete

        //JLabel l = new JLabel("inzio del tutto");  //creo etichetta
        //JButton b = new JButton("premimi per fare nulla"); //creo bottone

        Container c = this.getContentPane();  //content pane

        

        c.add(p);   //inserirsco il panel nel contentPane
        //p.add(l);   //aggiungo l'etichetta
        //p.add(b); //aggiungo il bottone

        //JButton b = new JButton("cliccami");
        
        this.setTitle("DinoPONG");
               this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);     //lo rendo visibile
   //lo rendo modellabile

    this.pack();

    this.setMinimumSize(new Dimension(400, 400));



        this.setResizable(true);

    }




}
