package MyGame;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
    JPanel p;
    


    public MyFrame(){


        p = new JPanel();//insatnzio parete

        //JLabel l = new JLabel("inzio del tutto");  //creo etichetta
        //JButton b = new JButton("premimi per fare nulla"); //creo bottone

        Container c = this.getContentPane();  //content pane

        this.setTitle("DinoPONG");

        c.add(p);   //inserirsco il panel nel contentPane
        //p.add(l);   //aggiungo l'etichetta
        //p.add(b); //aggiungo il bottone

        this.setSize(400,250);  //impsoto una grandezza iniziale
        this.setVisible(true);     //lo rendo visibile
        this.setResizable(true);   //lo rendo modellabile

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



}
