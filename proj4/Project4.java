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

/**
 * This class runs the Tic Tac Toe board simulation between the RandomAI player and the
 * SmartPlayer. Results are printed indicating how well each player did in the games played.
 * 
 * @version 04/28/14
 * @author Megan Straub <mstraub1@umbc.edu>
 * CMSC 341 - Spring 2014 - Project 4
 * Section 4
 *
 */
public class Project4 {
	
	/**
	* The main method that runs the simulation of the tic tac toe game.
	* 
	* @param args
	*/
	public static void main(String[] args) {
		
		RandomAI p1 = new RandomAI(1);
		SmartPlayer p2 = new SmartPlayer(2);
		int numGames = 20;
		
		play(p1, p2, numGames);
	}
	
	/**
	 * This method runs the simulation of the tic tac toe board game. Each player is assigned a number (1 or 2),
	 * based on that number it determines whether the player will play as X or O. In the simulation each player
	 * moves depending on whose turn it is. If a win scenario is reached, the current game will end and the players
	 * will continue playing until all games have been played. At the end of all games being played, a report 
	 * will be printed to document statistics about the games.
	 * 
	 * @param p1 the RandomAI player
	 * @param p2 the SmartPlayer
	 * @param numGames the amount of games the two players must play
	 */
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
			//System.out.println("New Game!!");
			
			for(int j = 0; j < 9; j++){ // 9 turns total for the game
				if (game.getTurn()){
					p1.move(game);
				} else if (!game.getTurn()){
					p2.move(game);
				}
				
				
			//	game.printBoard();
			//	System.out.println("hashed code " + game.hashCode());
				
				if(game.getWinner() != -1 && j > 3){
					
					p2.endGame(game);
					
					if(game.getWinner() == 1){
					//	System.out.println("Player " + game.getWinner() + " just won!!");
						p1Wins++;
					}else if (game.getWinner() == 2){
					//	System.out.println("Player " + game.getWinner() + " just won!!");
						p2Wins++;
					}	
					break;
				}
			}
		}
		
		//figure out how to format this correctly
		
		
	//	System.out.println("\nREPORT: ");
	//	System.out.println("Player 1 won: " + p1Wins);
		//System.out.format("%.4f", p1Wins);
		//System.out.println("Player 1 Win Percentage: " + winPercentage);
	//	System.out.printf("%.2f", winPercentage);
	
		
	//	System.out.println("Player 2 won: " + p2Wins);
		//System.out.println("Player 2 Win Percentage: " + winPercentage);
		
		p2.printStats();
		
		float winPercentage = ((float)p2Wins/(float)numGames) * (float) 100;
		System.out.println("Smart player has won " + p2Wins+ " times which is " + winPercentage +" percent");
		winPercentage = ((float)p1Wins/(float)numGames) * (float) 100;
		System.out.println("Random has won " + p1Wins + " times which is " + winPercentage + " percent");
		
		System.out.println("My favorite first move is: " + p2.getFavMove());
	}
}