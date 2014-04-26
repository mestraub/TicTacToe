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
		
		int numGames = 1000;
		
		play(numGames);
	}
	
	//call with numgames = 1000
	//smart player should be able to play as both X and O
	//Move should now look for the highest percentage of wins, not just the most wins.  
	//If a cell has not been played, view it as having a 100% win ratio.  
	//Ties should still be broken randomly.
	public static void play(int numGames){
		RandomAI p1 = new RandomAI(1);
		//RandomAI p2 = new RandomAI('X', 2);
		SmartPlayer p2 = new SmartPlayer(2);
		
		TicTacToe game = new TicTacToe();
		//game.printBoard();
		
		Random r = new Random();
		
		/*
		for (int i = 0; i < 10; i ++){
			int row = r.nextInt(3-0);
			System.out.println(row);
		}*/
		
		//while game is still going keep playing
		// stop when is over is true
		// track turns for each one
		// if statement if turn one
		// if statement if turn two
		
		
		for (int i = 0; i < 20; i++){
			
			if (game.getTurn()){
				p1.move(game);
			} else if (!game.getTurn()){
				p2.move(game);
			}

	
			game.printBoard();
			System.out.println("---------------");
		}
		
		/*
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
		
		System.out.println(table.numSlots());
		table.put(2, 5);
		table.put(7, 4);
		table.put(9, 3);
		table.put(12, 8);
		table.put(13, 1);
		
		table.put(23, 3);
		table.put(20, 7);
		
		
		System.out.println(table.get(2));
		System.out.println(table.get(7));
		System.out.println(table.get(9));
		System.out.println(table.get(12));
		System.out.println(table.get(13));
		System.out.println(table.get(23));
		System.out.println(table.get(20));
		
		
		System.out.println("Num entries: " + table.numEntries());
		System.out.println("size " + table.numSlots());
		
		*/
		
	}
	
	/*
	 * method play
	 * takes 2 Player objects and an int called numGames
	 */

}
