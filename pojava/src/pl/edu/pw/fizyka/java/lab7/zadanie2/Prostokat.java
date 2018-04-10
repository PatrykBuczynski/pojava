package pl.edu.pw.fizyka.java.lab7.zadanie2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Prostokat{

    private int xPos = 50;
	private int yPos = 50;
    private int width = 20;
    private int height = 20;
    private Color color = Color.BLACK;
    private int xVelocity = 5;
    private int yVelocity = 5;
    private JLabel etykieta = new JLabel();
    public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

    public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }

    public int getWidth(){
        return width;
    } 

    public int getHeight(){
        return height;
    }


	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

    public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	public void setXVelocity(int xV) {
		xVelocity = xV;
	}
	public void setYVelocity(int yV) {
		yVelocity = yV;
	}
	public int getXVelocity() {
		return xVelocity;
	}
	public int getYVelocity() {
		return yVelocity;
	}
	public JLabel getEtykieta() {
		return etykieta;
	}
	public void setEtykieta(JLabel etykieta) {
		this.etykieta = etykieta;
	}

	public void paint(Graphics g){
        g.setColor(getColor());
        g.fillRect(xPos,yPos,getWidth(),getHeight());
    }

}
