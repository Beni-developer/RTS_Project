package entities;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import config.GameConfig;
import process.ID;
import util.KeyInput;
import util.MouseInput;


public class Player extends GameObject{
	
	KeyInput key = new KeyInput();
	MouseInput mouse = new MouseInput();
	int sp; 
	public Player(int xPos, int yPos, ID id,MouseInput mouse) {
		super(xPos, yPos, id);
		this.xPos = xPos;
		this.yPos = yPos;
		this.key = key;
		this.mouse = mouse;
		setValue();
		getSprite();
		getAttackImage();
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
	
	public void getAttackImage() {
		try {
		attk1 = ImageIO.read(getClass().getResourceAsStream("/orc/Attack_000.png"));
		attk2 = ImageIO.read(getClass().getResourceAsStream("/orc/Attack_001.png"));
		attk3 = ImageIO.read(getClass().getResourceAsStream("/orc/Attack_002.png"));
		attk4 = ImageIO.read(getClass().getResourceAsStream("/orc/Attack_003.png"));
		attk5 = ImageIO.read(getClass().getResourceAsStream("/orc/Attack_004.png"));
		attk6 = ImageIO.read(getClass().getResourceAsStream("/orc/Attack_005.png"));
		attk7 = ImageIO.read(getClass().getResourceAsStream("/orc/Attack_006.png"));
		attk8 = ImageIO.read(getClass().getResourceAsStream("/orc/Attack_007.png"));
		attk9 = ImageIO.read(getClass().getResourceAsStream("/orc/Attack_008.png"));
		}catch(IOException e) {e.printStackTrace();}
		
	}
	
	public void attack() {
		spriteCount++;
		if(spriteCount <= 5) {
			spriteNum = 1;
		}
		if(spriteCount > 5 && spriteCount <= 25) {
			spriteNum = 2;
		}
		if(spriteCount > 25) {
			spriteNum = 1;
			spriteCount = 0;
			attack = false;
		}
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
			if(attack == false) {
				if(spriteNum == 1) {image = right1;}
				if(spriteNum == 2) {image = right2;}
				if(spriteNum == 3) {image = right3;}
				if(spriteNum == 4) {image = right3;}
				if(spriteNum == 5) {image = right4;}
			}
			if(attack == true) {
				if(spriteNum == 1) {image = attk1;}
				if(spriteNum == 2) {image = attk2;}
				if(spriteNum == 3) {image = attk3;}
				if(spriteNum == 4) {image = attk4;}
				if(spriteNum == 5) {image = attk5;}
				if(spriteNum == 6) {image = attk6;}
				if(spriteNum == 7) {image = attk7;}
				if(spriteNum == 8) {image = attk8;}
				if(spriteNum == 9) {image = attk9;}
			}
			break;
		}
		
		g2d.drawImage(image, xPos, yPos, GameConfig.BLOCK_SIZE, GameConfig.BLOCK_SIZE,null);
		
	}
	
	
	
	
	

}
