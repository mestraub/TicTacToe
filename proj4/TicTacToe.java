/**
* make int player and have that be 1 or 2
* make set mark so it determines the char for x and o
* finish win sections, so they equal player
* make it so the game rotates turns
*
*
*need this methods:
*constructor - done
*getWinner
*hashCode
*isOver
*move - done
*playerAt - done
*toString - done
*
*printBoard - done
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
public class TicTacToe {
	
	public static final int ROWS = 3;
	public static final int COLUMNS = 3;
	
	public static final int EMPTY = 0;
	public static final int CROSS = 1;
	public static final int CIRCLE = 2;
	
	public int player1;
	public int player2;
	
	public int winner;
	
	public boolean turn; // used to track which turn has occurred. true for p1 false for p2
	
	//my board
	int[][] board;

	public TicTacToe(){
		board = new int[ROWS][COLUMNS];	
		turn = true;
	}

	//works
	public void setMarker(int player){
	
		if (player == 1){
			player1 = CROSS; // 1 is for x's
		}else if (player == 2){
			player2 = CIRCLE; //2 is for o's
		}
	}
	
	//0 if draw
	public int getWinner(){
		
		if(isOver(player1)){
			return 1;
		}else if(isOver(player2)){
			return 2;
		}else if (isDraw()){
			return 0;
		}else{
			return -1;
		}
	}

	//hashes the boared state
	// look at this later and see if you can make it more spread out
	public int hashCode(){
		
		int hash = 0;
		Random r = new Random();
		
		for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				hash += board[i][j];
			}
		}
	
	//	hash = board[0][0] + board [0][1] + board[0][2] + 11 + 23 + 19;
		
		//hash += (hash % 101) * r.nextInt(5) * (int)Math.floor((0.66666689 * 17) + 2.66669) ; 
		hash += (hash % 397) * r.nextInt(29);

		return hash;
	}
	
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
	
	//add is over in here somehow
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
	
	public boolean getTurn(){
		return turn;
	}
	
	//use this to determine if a player has won
	//can win diagonally, vertically, or horizontally
	// there are 8 possible ways to win
	public int playerAt(int row, int col){
		if (board[row][col] == CROSS)
			return player1;
		else if (board[row][col] == CIRCLE)
			return player2;
		else
			return EMPTY;	
	}
	
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

	//prints the board
	public void printBoard(){
		System.out.print(toString());
		System.out.println("---------------");
	}

	//string representation of the object
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
}

/*
//used for printing the board
public void printCell(int cell){
	if (cell == EMPTY)
		System.out.print("-");
	else if (cell == CROSS)
		System.out.print("X");
	else if (cell == CIRCLE)
		System.out.print("O");
}

	//empties the board
	public void clearBoard(){
	for (int rows = 0; rows < ROWS; rows++){
	for (int columns = 0; columns < COLUMNS; columns++){
	board[rows][columns] = EMPTY;
	}
	}
	}
*/