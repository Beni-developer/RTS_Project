package gui;

/**
 *  @author belbenimakani@gmail.com
 *  
 */



import javax.swing.JFrame; 

public class MainGUI{
	
	
/**************************************** VARIABLES **********************************************/
	
	
	
/**************************************** METHODES **********************************************/
	
	public static void main(String[] args) {
		
		//CREATION DE LA FENETRE DE L'APP
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("RTS PROJECT");
		
		//AJOUT DU DISPPLAY A NOTRE FEBETRE
		GameDisplay display = new GameDisplay();
		window.add(display);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setAlwaysOnTop(true);
		window.setVisible(true);

		display.startGameThread();
	}
	
}
