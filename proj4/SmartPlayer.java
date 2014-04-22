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
	
	char marker;
	
	public SmartPlayer(){
		
	}
	
	public SmartPlayer(char marker){
		this.marker = marker;
	}
	
	//over simplified
	public void move(TicTacToe t){
		Random r = new Random();
		
		int row = r.nextInt(3-0);
		int columns = r.nextInt(3-0);
		
		t.setMarker(marker);
		
		t.move(row, columns);
	}
}