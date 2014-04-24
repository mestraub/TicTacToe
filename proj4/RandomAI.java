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
	
	char marker;
	
	public RandomAI(){
		
	}
	
	public RandomAI (char marker){
		this.marker = marker;
	}
	
	//will have to fix the marker stuff later
	//takes a given board and makes a random move. if the board is full, it does nothing.
	//t is the board moving.
	public void move(TicTacToe t){
		Random r = new Random();
		
		int row = r.nextInt(3-0);
		int columns = r.nextInt(3-0);
		
		t.setMarker(marker);
		
		t.move(row, columns);
	}
	
}
