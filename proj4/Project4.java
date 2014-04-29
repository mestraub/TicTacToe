/**
* Create basis of these classes from java doc descriptions:
* Hashtable
* RandomAI
* SmartPlayer
* TicTacToe
*
* documentation from javadoc
* Proj 4
* TictacToe
* hashtable
* Smart player
* Ai - done
*/
package proj4;

import java.util.Random;

/**
 * This class is an AI that makes moves randomly on a tic tac toe board.
 * 
 * @version 04/28/14
 * @author Megan Straub <mstraub1@umbc.edu>
 * CMSC 341 - Spring 2014 - Project 4
 * Section 4
 *
 */
public class Project4 {
	
	/**
	* @param args
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RandomAI p1 = new RandomAI(1);
		SmartPlayer p2 = new SmartPlayer(2);
		int numGames = 5;
		
	//	play(p1, p2, numGames);
		
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
		table.put(20, 8);
		table.put(15, 8);
		table.put(56, 8);
		System.out.println(table.get(2));
		System.out.println(table.get(7));
		System.out.println(table.get(9));
		System.out.println(table.get(12));
		System.out.println(table.get(13));
		System.out.println(table.get(23));
		System.out.println(table.get(20));
		//System.out.println(table.toString());
		System.out.println("Num entries: " + table.numEntries());
		System.out.println("size " + table.numSlots());
		System.out.println("collisions " + table.numCollisions());
		*/
	}
	
		//call with numgames = 1000
		//smart player should be able to play as both X and O
		//Move should now look for the highest percentage of wins, not just the most wins.
		//If a cell has not been played, view it as having a 100% win ratio.
		//Ties should still be broken randomly.
	public static void play(RandomAI p1, SmartPlayer p2, int numGames){
		
		//while game is still going keep playing
		// stop when is over is true
		// track turns for each one
		// if statement if turn one
		// if statement if turn two
		int p1Wins = 0;
		int p2Wins = 0;
		int draws = 0;
		
		for(int i = 0; i < numGames; i++){
			TicTacToe game = new TicTacToe();
			p2.newGame(2);
			System.out.println("New Game!!");
			
			for(int j = 0; j < 9; j++){ // 9 turns total for the game
				if (game.getTurn()){
					p1.move(game);
				} else if (!game.getTurn()){
					p2.move(game);
				}
				
				
				game.printBoard();
				System.out.println("hashed code " + game.hashCode());
				
				if(game.getWinner() != -1 && j > 3){
					
					p2.endGame(game);
					
					if(game.getWinner() == 1){
						System.out.println("Player " + game.getWinner() + " just won!!");
						//j = 9;
						p1Wins++;
					}else if (game.getWinner() == 2){
						System.out.println("Player " + game.getWinner() + " just won!!");
						//j = 9;
						p2Wins++;
					}
					
					break;
				} // do something for draws
			}
		}
		
		//figure out how to format this correctly
		
		
		System.out.println("\nREPORT: ");
		System.out.println("Player 1 won: " + p1Wins);
		//System.out.format("%.4f", p1Wins);
		//System.out.println("Player 1 Win Percentage: " + winPercentage);
	//	System.out.printf("%.2f", winPercentage);
	
		
		System.out.println("Player 2 won: " + p2Wins);
		//System.out.println("Player 2 Win Percentage: " + winPercentage);
		
		p2.printStats();
		
		float winPercentage = ((float)p2Wins/(float)numGames) * (float) 100;
		System.out.println("Smart player has won " + p2Wins+ " times which is " + winPercentage +" percent");
		winPercentage = ((float)p1Wins/(float)numGames) * (float) 100;
		System.out.println("Random has won " + p1Wins + " times which is " + winPercentage + " percent");
		
		System.out.println("My favorite first move is: " + p2.getFavMove());
	}
}