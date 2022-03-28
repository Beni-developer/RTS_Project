package gui;


/**
 *  @author belbenimakani@gmail.com
 *  
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JPanel;
import config.GameConfig;
import entities.Enemy;
import entities.GameObject;
import entities.Player;

import map.Map;


import process.GameManager;
import process.ID;
import util.KeyInput;
import util.MouseInput;






public class GameDisplay extends JPanel implements Runnable{

/**************************************** VARIABLES **********************************************/
	private static final long serialVersionUID = 1L;
	
	private final static Dimension preferredSize = new Dimension(GameConfig.WINDOW_WIDTH, GameConfig.WINDOW_HEIGHT);
	public  int blockSize = GameConfig.BLOCK_SIZE;
	public final int maxCol = GameConfig.MAX_WINDOW_COL;
	public final int maxLine = GameConfig.MAX_WINDOW_ROW;
	
	private Map map = new Map(this);
	KeyInput key = new KeyInput();
	MouseInput mouse = new MouseInput();
	Thread gameThread;
	GameManager manager;

	
	
	
	int x = 100, y = 400;
/**************************************** CONSTRUCTEUR **********************************************/
	
	public GameDisplay() {
		super();
		showWindow();
		keyControllers();
		
		manager = new GameManager();
		manager.addObject(new Player(79+(50),300,ID.Player,mouse));
		manager.addObject(new Player(79+(50),300+40,ID.Player,mouse));
		manager.addObject(new Player(79+(50),300+80,ID.Player,mouse));
		manager.addObject(new Player(79+(50),300+120,ID.Player,mouse));
		
		manager.addObject(new Enemy(800+(50),300,ID.Player));
		manager.addObject(new Enemy(800+(50),300+40,ID.Player));
		manager.addObject(new Enemy(800+(50),300+80,ID.Player));
		manager.addObject(new Enemy(800+(50),300+120,ID.Player));
		
	}
	
/**************************************** METHODES **********************************************/

public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void showWindow() {
		
		this.setPreferredSize(preferredSize);
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
	
	public void keyControllers() {
		
		this.addMouseListener(mouse);
		this.addKeyListener(key);
		this.setFocusable(true);
	}
	
	@Override
	public void run() {
		double drawInterval = 1000000000/60;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			
			// Update -> Mettre à jour des informatins telles que la position des personnages
			update();
			
			// Draw() -> Déssiner l'écran avec les informations mises à jour
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void update() {
		//pl.update();
		manager.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		
		
		//Déssiner la map
		map.render(g2D);
		
		//Désiner nos objects
		manager.render(g2D);
	
		
		
		g2D.dispose();
		
	}

	
}
