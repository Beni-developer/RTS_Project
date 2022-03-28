package map;


import java.awt.Graphics;
import java.awt.Graphics2D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import config.GameConfig;
import gui.GameDisplay;

public class Map {
	
	GameDisplay gd;
	public Block[] block;
	
	public int mapBlockNum[][];
	 
	
	
	public Map(GameDisplay gd) {
		
		this.gd = gd;
		
		block = new Block[10];
		mapBlockNum = new int [gd.maxCol][gd.maxLine];
		
		getBlockImage();
		loadMap("/maps/map1.txt");
	}
	
	public void getBlockImage() {
		
		try {
			
			block[0] = new Block();
			block[0].image = ImageIO.read(getClass().getResourceAsStream("/blocks/earth.png"));
			
			block[1] = new Block();
			block[1].image = ImageIO.read(getClass().getResourceAsStream("/blocks/wall.png"));
		
			
			block[2] = new Block();
			block[2].image = ImageIO.read(getClass().getResourceAsStream("/blocks/water.png"));
			
			
			block[3] = new Block();
			block[3].image = ImageIO.read(getClass().getResourceAsStream("/blocks/earth.png"));
			
			block[4] = new Block();
			block[4].image = ImageIO.read(getClass().getResourceAsStream("/blocks/tree.png"));
			
			
			block[5] = new Block();
			block[5].image = ImageIO.read(getClass().getResourceAsStream("/blocks/grass.png"));
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void loadMap(String filePath) {
		
		try {
			
			InputStream inputFile = getClass().getResourceAsStream(filePath);
			BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));
			
			int row = 0; 
			int column = 0; 
			//int x = 0; int y = 0;
			
			while(column  < gd.maxCol && row < gd.maxLine) {
				
				String line = readFile.readLine();
				
				while(column  < gd.maxCol) {
					
					String Num[] = line.split(" ");
					
					int num = Integer.parseInt(Num[column]);
					
					mapBlockNum[column ][row] = num;
					column++;
				}

				if(column  == gd.maxCol) {
					column  = 0;
					row++;
				}
			}
			readFile.close();
			
		}catch(Exception e) {
			
		}
		
	}
	
	
	public void render(Graphics2D g2D) {
		
		int col = 0,line = 0, x = 0, y = 0;
		
		while(col <= gd.maxCol && line < gd.maxLine) {
			
			int blockNum = mapBlockNum[col][line];
			
			g2D.drawImage(block[blockNum].image, x, y,  gd.blockSize,  gd.blockSize, null);
			col++;
			x +=  gd.blockSize;
			
			if(col == gd.maxCol) {
				col = 0;
				x = 0;
				line++;
				y +=  gd.blockSize;
			}
		}
		
	}

}
