/**
 * make int player and have that be 1 or 2
 * make set mark so it determines the char for x and o
 * finish win sections, so they equal player 
 * make it so the game rotates turns
 * 
 */
package proj4;

import java.util.Random;

/**
 * @author Megan
 *
 */
public class TicTacToe {

	public static final int ROWS = 3;
	public static final int COLUMNS = 3;
	
	public static final int EMPTY = 0;
	public static final int CROSS = 1;
	public static final int CIRCLE = 2;
	
	public int draw = 0;
	public int wins = 0;
	
	//public char marker; // x or o will have to be changed later
	public int player1;
	public int player2;
	public int currentPlayer;
	
	public int winner;
	
	public boolean turn = true; // used to track which turn has occurred. true for p1 false for p2
	
	//my board
	int[][] board;
	
	public TicTacToe(){
		board = new int[ROWS][COLUMNS];	
	//	clearBoard(); //may have to change this constructor later
	}
	
	//added method that might have to be removed
	public void setMarker(int player){

		if (player == 1){
			player1 = CROSS; // 1 is for x's
		}
		
		if (player == 2){
			player2 = CIRCLE; //2 is for o's
		}
	}
	
	public int getWinner(){
		
		
		if(isOver()){
			wins++;
			return winner;
		}else
			return 0;
		
	//	return 1;
	}
	
	
	//hashes the boared state
	// look at this later and see if you can make it more spread out
	public int hashcode(){
		
		int hash = 0;
		Random r = new Random();
		
		hash = board[0][0] + board [0][1] + board[0][2]
				+ board[1][0] + board [1][1] + board[1][2]
				+ board[2][0] + board [2][1] + board[2][2];
		
		hash = (int) Math.floor((hash^3) * 0.666667) * r.nextInt(37-2);
		
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
			draw++;
			return true;
		}
		else
			return false;
	}
	
	//add is over in here somehow
	public boolean move(int row, int col){
		
		if (playerAt(row, col) == EMPTY){
			
			if(turn){
				
				currentPlayer = player1;
				board[row][col] = player1;
				turn = false;

					
			}else if (!turn){
				
				currentPlayer = player2;
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
	
	public java.lang.String toString(){
		return "yes";
	}
	
	public boolean isOver(){
		/*
		int currentPlayer = -1;
		//System.out.println(currentPlayer);
		if (turn){
			currentPlayer = player1;
			//System.out.println(currentPlayer);
		}else {
			currentPlayer = player2;
			//System.out.println(currentPlayer);
		}
		*/
		if (board[0][0] == currentPlayer && board[0][1] == currentPlayer && board[0][2] == currentPlayer){
			
			winner = currentPlayer;
			//System.out.println("Player " + currentPlayer + " just won!!");
			//clearBoard();
			return true;
		}else if (board[1][0] == currentPlayer && board[1][1] == currentPlayer && board[1][2] == currentPlayer){
			
			winner = currentPlayer;
			return true;
		}else if (board[2][0] == currentPlayer && board[2][1] == currentPlayer && board[2][2] == currentPlayer){
			
			winner = currentPlayer;
			return true;
		}else if(board[0][0] == currentPlayer && board[1][0] == currentPlayer && board[2][0] == currentPlayer) {
			
			winner = currentPlayer;
			return true;
		}else if(board[0][1] == currentPlayer && board[1][1] == currentPlayer && board[2][1] == currentPlayer) {
			
			winner = currentPlayer;
			return true;
		}else if(board[0][2] == currentPlayer && board[1][2] == currentPlayer && board[2][2] == currentPlayer) {
			
			winner = currentPlayer;
			return true;
		}else if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer){
			
			winner = currentPlayer;
			return true;
		}else if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer){
			
			winner = currentPlayer;
			return true;
		}else {
			return false;
		}
	}
	
	//empties the board
	public void clearBoard(){
		for (int rows = 0; rows < ROWS; rows++){
			for (int columns = 0; columns < COLUMNS; columns++){
				board[rows][columns] = EMPTY;
			}
		}
	}
	
	//prints teh board
	public void printBoard(){
		for (int rows = 0; rows < ROWS; rows++){
			for (int columns = 0; columns < COLUMNS; columns++){
				printCell(board[rows][columns]);
			}
			
			System.out.println("");
		}
	}
	
	//used for printing the board
	public void printCell(int cell){
		if (cell == EMPTY)
			System.out.print("-");
		else if (cell == CROSS)
			System.out.print("X");
		else if (cell == CIRCLE)
			System.out.print("O");
	}
}
