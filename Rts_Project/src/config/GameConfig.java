package config;


/**
 *  @author belbenimakani@gmail.com
 *  
 */

public  abstract class GameConfig {


/**************************************** REGLAGE DE LA FENETRE **********************************************/
	
	public static final int ORIGINAL_BLOCK_SIZE = 16; //taille originale d'un block
	public static final int SCALE = 3;
	public static final int BLOCK_SIZE = ORIGINAL_BLOCK_SIZE * SCALE; //nombre total des block 48
	public static final int MAX_WINDOW_COL = 25;
	public static final int MAX_WINDOW_ROW = 15;
	public static final int WINDOW_WIDTH = BLOCK_SIZE * MAX_WINDOW_COL; //1200 pixels
	public static final int WINDOW_HEIGHT = BLOCK_SIZE * MAX_WINDOW_ROW; //720 pixels
	
/**************************************** REGLAGE JEU ****************************************************/
	public static final int PAUSE = 500; // temps d'attente entre 2 tours de boucles: 5 millisecondes
	
	
	
/**************************************** REGLAGE JOEUR ****************************************************/	
	public static final int LARGEUR_PLAYER = 32;
	public static final int HAUTEUR_PLAYER = 16;
	
/**************************************** REGLAGE ATTAQUE ****************************************************/
	public static final int TIR_WIDTH = 3;
	public static final int TIR_HEIGHT = 13;
	
	public static final int DX_TIR = 2;
}
