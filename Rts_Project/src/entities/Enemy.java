package entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import config.GameConfig;
import process.ID;
import util.KeyInput;
import util.MouseInput;

public class Enemy extends GameObject {
	

	KeyInput key = new KeyInput();
	MouseInput mouse = new MouseInput();
	int sp; 
	public Enemy(int xPos, int yPos, ID id) {
		super(xPos, yPos, id);
		this.xPos = xPos;
		this.yPos = yPos;

		setValue();
		getSprite();
	}
	
	public void setValue() {
		sp = 1;
		direction = "right";
		
	}
	
	
	
	@Override
	public void update() {
		//xPos += dx;
		yPos += dy;
		if(mouse.clickMouse == true) {
			if(xPos < 800) {
				xPos += sp;	
			}else xPos = 800;
		}
		
		
		//yPos = interPol(progress, yPos, 800 - yPos, time);
		/*if(key.upPressed == true || key.downPressed == true ||key.leftPressed == true || key.rightPressed == true) {
		if(key.upPressed == true) {
			direction = "up";
			yPos -= sp;
		}
		if(key.downPressed == true) {
			direction = "down";
			yPos += sp;
		}
		if(key.leftPressed == true) {
			direction = "left";
			xPos -= sp;
		}
		if(key.rightPressed == true) {
			direction = "right";
			xPos += sp;
		}*/
		
		spriteCount++;
		if(spriteCount > 10) {
			if(spriteNum == 1) {
				spriteNum =2;
			}
			else if(spriteNum == 2) {
				spriteNum =1;
			}
			spriteCount = 0;
		}
		
		
	}

	@Override
	public void getSprite() {
		
		try {
			right1 = ImageIO.read(getClass().getResourceAsStream("/orc/Walk_000.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/orc/Walk_001.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/orc/Walk_002.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/orc/Walk_003.png"));
			right5 = ImageIO.read(getClass().getResourceAsStream("/orc/Walk_004.png"));
			
		}catch(IOException e) {e.printStackTrace();}
	
		
		
	}

	@Override
	public void render(Graphics2D g2d) {
		//g2d.setColor(Color.white);
		//g2d.fillRect(xPos, yPos,32, 32);
		
		BufferedImage image = null;
		switch(direction) {
		case"up":
			image = right1;
			break;
		case"down":
			image = right2;
			break;
		case"left":
			image = right3;
			break;
		case"right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			if(spriteNum == 3) {
				image = right3;
			}
			if(spriteNum == 4) {
				image = right3;
			}
			if(spriteNum == 5) {
				image = right4;
			}
			break;
		}
		
		g2d.drawImage(image, xPos, yPos, GameConfig.BLOCK_SIZE, GameConfig.BLOCK_SIZE,null);
		
	}
	
	

}
