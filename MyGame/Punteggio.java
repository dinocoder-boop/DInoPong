package MyGame;

import java.awt.*;

public class Punteggio extends Rectangle {

	//ATTRIBUTI
	public int pointsP1;
	public int pointsP2;
	public int height;
	public int width;
	
	
	//COSTRUTTORE
	public Punteggio(int height, int width) {
		
		pointsP1=0;
		pointsP2=0;
		this.width= width;
		this.height = height;
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.drawLine(width/2,0, width/2, height);
		
		g.setFont(new Font("Menlo", Font.PLAIN, 40)); 
		g.drawString(String.valueOf(pointsP1), width/5, 50);
		g.drawString(String.valueOf(pointsP2), 4*width/5, 50);
		
	}
	
	
	public void addPointP1(){
		pointsP1++;
	}

	public void addPointP2(){
		pointsP2++;
	}
	
	
}
