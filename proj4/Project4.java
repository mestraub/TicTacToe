/**
 * Create basis of these classes from java doc descriptions:
 * Hashtable
 * RandomAI
 * SmartPlayer
 * TicTacToe
 * 
 * documentation from javadoc
 */
package proj4;

import java.util.Random;

/**
 * @author Megan
 *
 */
public class Project4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		play();
	}
	
	//call with numgames = 1000
	//smart player should be able to play as both X and O
	//Move should now look for the highest percentage of wins, not just the most wins.  
	//If a cell has not been played, view it as having a 100% win ratio.  
	//Ties should still be broken randomly.
	public static void play(){
		RandomAI p1 = new RandomAI('o');
		SmartPlayer p2 = new SmartPlayer('x');
		
		TicTacToe game = new TicTacToe();
		//game.printBoard();
		
		Random r = new Random();
		
		/*
		for (int i = 0; i < 10; i ++){
			int row = r.nextInt(3-0);
			System.out.println(row);
		}*/
		
		for (int i = 0; i < 9; i++){
			p1.move(game);
			p2.move(game);
			game.printBoard();
			System.out.println("---------------");
		}
		
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
		
		System.out.println(table.numSlots());
		table.put(2, 5);
		table.put(7, 4);
		table.put(9, 3);
		table.put(12, 8);
		table.put(13, 1);
		System.out.println(table.get(2));
		System.out.println(table.get(7));
		System.out.println(table.get(12));
		System.out.println(table.get(13));
		
	}
	
	/*
	 * method play
	 * takes 2 Player objects and an int called numGames
	 */

}
