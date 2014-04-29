/**
*
*/
package proj4;

//import java.util.Arrays;
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
public class SmartPlayer {
	
	/**
	 * 
	 */
	public int player;
	
	/**
	 * 
	 */
	public Hashtable<Integer,Statistics> table;
	
	/**
	 * 
	 */
	int[] copiedGameBoard;
	
	/**
	 * 
	 */
	int stateMove;
	
	/**
	 * 
	 */
	public SmartPlayer(){
		player = -1;
		table = new Hashtable<Integer, Statistics>();
		copiedGameBoard = new int[9];
		stateMove = 0;
	}
	
	/**
	 * 
	 * @param player
	 */
	public SmartPlayer( int player){
		this.player = player;
		table = new Hashtable<Integer, Statistics>();
		copiedGameBoard = new int[9];
		stateMove = 0;
	}
	
	/**
	 * 
	 * @param player
	 */
	public void newGame(int player){
		this.player = player;
		copiedGameBoard = new int[9];
	}
	
	//over simplified
	public void move(TicTacToe t){
		Random r = new Random();
		
		int row = r.nextInt(3);
		int columns = r.nextInt(3);
		
		t.setMarker(player);
		
		while(!t.getTurn()){
			
			//if i've seen this table before
			if(table.containsKey(t.hashCode())){
				System.out.println("SEEN THIS BEFORE");
				//loop through board states and find one with the most wins
				Statistics move = table.get(t.hashCode()); //retrieves the current move from teh hash table
				
				//check for any sucessor moves
				//getSuccessors(move);
				// find the move with the wins > losses then move according to that move
				//put move in copied game board array
				//stateMove++;
				
				
				
			}else{
				if(t.move(row, columns)){
					table.put(t.hashCode(), new Statistics(1, 0, 0, row, columns, t.toString()));
					copiedGameBoard[stateMove] = t.hashCode();
					stateMove++;
					//put move in teh game state array
				}else{
					move(t);
				}
			//}
			}
		
		//System.out.print(table.get(t.hashCode()));
		}
	}
	

	
	public void endGame (TicTacToe finalBoard){
		Statistics stats;
		
		stateMove = 0;
		
		if (table.containsKey(finalBoard.hashCode())){
			//do stuff if i have this board
			
			//check if i won
			if(finalBoard.getWinner() == player){
				for(int i : copiedGameBoard){
					// incrememnt wins
					// incrememnt timesseen
					// put in hash table
				}
			}else{
				// this means i lost
				for (int i : copiedGameBoard){
					//increment losses
					//incremement times seen
					//put in hash table
				}
			}
		}else{
			
			//if i dont have the board, add it to the hash table
		}
		
		//repaly the moves
		//increment whether they helped win or lose
		//store in hash table
		//cycle through state moves, reset statemove to 0
		/*
		 * advanced for loop
		 * 
		 * for (int i : SOMETHING){
		 *  do code here
		 * }
		 */
		
		
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public int numberOfTimesSeen(TicTacToe t){
		if(table.containsKey(t.hashCode())){
			return table.get(t.hashCode()).timesSeen;
		}
		else{
			return 0;
		}
	}
	

	public TicTacToe[] getSuccessors(TicTacToe t){
		TicTacToe[] boards = new TicTacToe[9];
		
		// search boards with the less empty spaces 
		// those boards are the successors
		
		for (int i = 0; i < table.numSlots(); i++){
			if(table.get(i) != null){
				int k = table.getPositionInHashtable(i);
				
			}
		}
		
		return boards;
	}
	
	public String getFavMove(){
		return "str";
	}

	
	public void printStats(){
		//print game stats of hashtable slots, entires, % full, and number of collisions
		System.out.println("FINAL REPORT:");
		System.out.println("The number of slots is: " + table.numSlots());
		System.out.println("The number of entires is: " + table.numEntries());
		
		float full = (float)table.numEntries() / (float)table.numSlots();
		// format the  numbers
		System.out.println("The % full is: " + full);
		
		System.out.println("The number of collisions is: " + table.numCollisions());
		

		
	//	System.out.println("My favorite first move is: " + getFavMove());
	}
	
	// a private class thats stores information about each board state
	private class Statistics{
		int timesSeen;
		int wins;
		int losses;
		int row;
		int col;
		String board;
		
		Statistics(){
			timesSeen = 0;
			wins = 0;
			losses = 0;
		}
		
		Statistics(int timesSeen, int wins, int losses, int row, int col, String board){
			this.timesSeen = timesSeen;
			this.wins = wins;
			this.losses = losses;
			this.row = row;
			this.col = col;
			this.board = board;
		}
		
		void incrementTimesSeen(){
			timesSeen++;
		}
		
		void incrementWins(){
			wins++;
		}
		
		void incrementLosses(){
			losses++;
		}
	}

}