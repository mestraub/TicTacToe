/**
 * 
 */
package proj4;

import java.util.Random;

/**
 * @author Megan
 *
 */
public class SmartPlayer {
	
	//char marker;
	int player;
	
	public SmartPlayer(){
		
	}
	
	public SmartPlayer( int player){
	//	this.marker = marker;
		this.player = player;
	}
	
	//over simplified
	public void move(TicTacToe t){
		Random r = new Random();
		
		int row = r.nextInt(3-0);
		int columns = r.nextInt(3-0);
		
		t.setMarker(player);
		
		t.move(row, columns);
	}
	
	public void newGame(int player){
		
	}
	
	public void endGame (TicTacToe finalBoard){
		
	}
	
	public int numberOfTimesSeen(TicTacToe t){
		return 1;
	}
	
	/*
	public TicTacToe[] getSuccessors(TicTacToe t){
		
	}
	*/
	
}
