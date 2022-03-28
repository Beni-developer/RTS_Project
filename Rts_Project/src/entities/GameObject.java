package entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import map.Position;
import process.ID;

public abstract class GameObject {
	
	protected int xPos;
	protected int yPos;
	protected int dx;
	protected int dy;
	protected ID id;
	
	protected BufferedImage right1, right2, right3, right4, right5;
	protected BufferedImage attk1, attk2,attk3, attk4, attk5,attk6,attk7, attk8, attk9;
	protected boolean attack;
	protected String direction;
	protected int spriteCount = 0;
	protected int spriteNum = 1;
	protected int actionLockCounter = 0;
	
	public GameObject(int xPos,int yPos,ID id) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.id = id;
		
	}
	
	

	public abstract void  update();
	public abstract void getSprite();
	public abstract void render(Graphics2D g2d);



	public int getxPos() {
		return xPos;
	}



	public void setxPos(int xPos) {
		this.xPos = xPos;
	}



	public int getyPos() {
		return yPos;
	}



	public void setyPos(int yPos) {
		this.yPos = yPos;
	}



	public int getDx() {
		return dx;
	}



	public void setDx(int dx) {
		this.dx = dx;
	}



	public int getDy() {
		return dy;
	}



	public void setDy(int dy) {
		this.dy = dy;
	}



	public ID getId() {
		return id;
	}



	public void setId(ID id) {
		this.id = id;
	}
	
	
	
}
