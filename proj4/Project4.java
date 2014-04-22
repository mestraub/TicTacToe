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

	}
	
	/*
	 * method play
	 * takes 2 Player objects and an int called numGames
	 */

}
