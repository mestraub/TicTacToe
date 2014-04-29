package proj4;

import java.util.Random;

/**
 * This class represents a game of TicTacToe. The first player (X) is player 1, and the
 * second player (O) is player 2. 
 * 
 * @version 04/28/14
 * @author Megan Straub <mstraub1@umbc.edu>
 * CMSC 341 - Spring 2014 - Project 4
 * Section 4
 *
 */
public class TicTacToe {
	
	/**
	 * The number of rows for the game board.
	 */
	public static final int ROWS = 3;
	
	/**
	 * The number of columns for the game board.
	 */
	public static final int COLUMNS = 3;
	
	/**
	 * The number representation of empty spaces on the game board.
	 */
	public static final int EMPTY = 0;
	
	/**
	 * The number representation of X's on the game board.
	 */
	public static final int CROSS = 1;
	
	/**
	 * The number representation of O's on the game board.
	 */
	public static final int CIRCLE = 2;
	
	/**
	 * The number representation marker player1 is playing. (X or O).
	 */
	public int player1;
	
	/**
	 * The number representation marker player2 is playing. (X or O).
	 */
	public int player2;
	
	/**
	 * The number to indicate which player one. 1 = player 1, 2 = player 2.
	 */
	public int winner;
	
	/**
	 * The flag that determines whose turn it is. True for player1. False for player2.
	 */
	public boolean turn;
	
	/**
	 * The TicTacToe game board.
	 */
	int[][] board;
	
	/**
	 * A constructor that creates the game board, and sets the turn flag.
	 */
	public TicTacToe(){
		board = new int[ROWS][COLUMNS];	
		turn = true;
	}

	/**
	 * This method indicates which marker the players will play as. 
	 * Player 1 is always X. Player 2 is always O.
	 * 
	 * @param player the player to be set
	 */
	public void setMarker(int player){
	
		if (player == 1){
			player1 = CROSS; // 1 is for x's
		}else if (player == 2){
			player2 = CIRCLE; //2 is for o's
		}
	}
	
	/**
	 * This method tells who won the game.
	 * 
	 * @return the number to indicate who won the game
	 */
	public int getWinner(){
		
		if(isOver(player1)){
			return 1; //player1 won
		}else if(isOver(player2)){
			return 2; //player2 won
		}else if (isDraw()){
			return 0; //the game is a draw
		}else{
			return -1; // the game is not finished
		}
	}

	/**
	 * This method hashes the game board into an int.
	 * 
	 * @return the board in int form
	 */
	public int hashCode(){
		
		int hash = 0;
		Random r = new Random();
		
		for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				hash += board[i][j];
			}
		}
		
		hash += (hash % 101) * r.nextInt(5) * (int)Math.floor((0.66666689 * 17) + 2.66669) ; 

		return hash;
	}
	
	/**
	 * This determines if the game is a draw.
	 * 
	 * @return true if the game is a draw, false otherwise
	 */
	public boolean isDraw(){
		int count = 0;
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++)
				if(board[i][j] != EMPTY)
					count++;
		}
		
		if (count == 9){
			return true;
		}else
			return false;
	}
	
	/**
	 * This makes a move in a given cell if it is empty (returns false if this is
	 * not possible).
	 * 
	 * @param row the row of the move
	 * @param col the column of the move
	 * @return true if the move was made, false otherwise
	 */
	public boolean move(int row, int col){
		
		if (playerAt(row, col) == EMPTY){
		
			if(turn){
				board[row][col] = player1;
				turn = false;
		}else if (!turn){
			board[row][col] = player2;
			turn = true;		
		}	
			return true;	
		}else{
			return false;
		}
	}
	
	/**
	 * This method returns whose turn it is to make a move.
	 * 
	 * @return true for player1, false for player2
	 */
	public boolean getTurn(){
		return turn;
	}
	
	/**
	 * This method returns the current move made at the given location.
	 * 
	 * @param row the row of the move
	 * @param col the column of the move
	 * @return 0, 1 or 2 based on the player's move
	 */
	public int playerAt(int row, int col){
		if (board[row][col] == CROSS)
			return player1;
		else if (board[row][col] == CIRCLE)
			return player2;
		else
			return EMPTY;	
	}
	
	/**
	 * Determines if the game is over.
	 * 
	 * @param player the player being checked for a win
	 * @return true if that player won, false otherwise
	 */
	public boolean isOver(int player){

		if (board[0][0] == player && board[0][1] == player && board[0][2] == player){
			return true;
		}else if (board[1][0] == player && board[1][1] == player && board[1][2] == player){
			return true;
		}else if (board[2][0] == player && board[2][1] == player && board[2][2] == player){
			return true;
		}else if(board[0][0] == player && board[1][0] == player && board[2][0] == player) {
			return true;
		}else if(board[0][1] == player && board[1][1] == player && board[2][1] == player) {
			return true;
		}else if(board[0][2] == player && board[1][2] == player && board[2][2] == player) {
			return true;
		}else if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
			return true;
		}else if (board[0][2] == player && board[1][1] == player && board[2][0] == player){
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Prints the game board.
	 */
	public void printBoard(){
		System.out.print(toString());
		System.out.println("---------------");
	}

	/**
	 * This is used for printing the game board. It is a string representation
	 * of the board.
	 * 
	 * @return puts the game board in string form (X, O and -)
	 */
	public java.lang.String toString(){
		String str = "";
		for (int rows = 0; rows < ROWS; rows++){
			for (int columns = 0; columns < COLUMNS; columns++){
				if(board[rows][columns] == EMPTY){
					str += "-";
				}else if (board[rows][columns] == CROSS){
					str += "X";
				}else if(board[rows][columns] == CIRCLE){
					str += "O";
				}
			}
		
			str += "\n";
		}

		return str;
	}
	
	
	//POSSIBLY REMOVE THSI FUNCTION1!!
	
	/**
	 * Counts the number of empty spaces within a board
	 * @return
	 */
	public int countEmpty(){
		int empty = 0;
		
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if(board[i][j] == EMPTY)
					empty++;
			}
		}
		
		return empty;
	}
}