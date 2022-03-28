package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{

	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int codeKey = e.getKeyCode();
		
		if(codeKey == KeyEvent.VK_W) {
			upPressed =true;
		}
		if(codeKey == KeyEvent.VK_S) {
			downPressed = true; 
		}
		if(codeKey == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if(codeKey == KeyEvent.VK_D) {
			rightPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int codeKey = e.getKeyCode();
		
		if(codeKey == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(codeKey == KeyEvent.VK_S) {
			downPressed = false; 
		}
		if(codeKey == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(codeKey == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
	}

}
