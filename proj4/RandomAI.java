/**
 * 
 */
package proj4;

import java.util.Random;

/**
 * @author Megan
 *
 */
public class RandomAI {
	
	//char marker;
	int player;
	
	public RandomAI(){
		
	}
	
	public RandomAI (int player){
		//this.marker = marker;
		this.player = player;
	}
	
	//will have to fix the marker stuff later
	//takes a given board and makes a random move. if the board is full, it does nothing.
	//t is the board moving.
	public void move(TicTacToe t){
		Random r = new Random();
		
		int row = r.nextInt(3-0);
		int columns = r.nextInt(3-0);
		
		t.setMarker(player);
		
		t.move(row, columns);
	}
	
}
