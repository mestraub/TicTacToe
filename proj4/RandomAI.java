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
public class RandomAI {
	
	/**
	 * The number the AI is playing as. Ex: Player 1, or Player 2.
	 * Number also signifies which marker the player is. Ex: X or O.
	 */
	public int player;
	
	/**
	 * A constructor that defaults the AI's player number.
	 */
	public RandomAI(){
		player = -1;
	}
	
	/**
	 * A second constructor that sets the AI's player number.
	 * 
	 * @param player the player the AI is playing as (1 or 2)
	 */
	public RandomAI (int player){
		this.player = player;
	}

	/**
	 * This takes a given board and makes a random move. If the board is full, nothing is done.
	 * The AI always makes a random legal move.
	 * 
	 * @param t the board being moved
	 */
	public void move(TicTacToe t){
		Random r = new Random();
		
		int row = r.nextInt(3);
		int columns = r.nextInt(3);
		
		t.setMarker(player);
		
		while(t.getTurn()){
			if(t.move(row, columns)){
				break;
			}
			else{
				move(t);
			}
		}
	}
}