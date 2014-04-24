/**
 * 
 */
package proj4;

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
	
	public static final int DRAW = 0;
	public static final int WINS = 0;
	
	public char marker; // x or o will have to be changed later
	
	//my board
	int[][] board = new int[ROWS][COLUMNS];
	
	public TicTacToe(){
		clearBoard(); //may have to change this constructor later
	}
	
	//added method that might have to be removed
	public void setMarker(char marker){
		this.marker = marker;
	}
	
	public int getWinner(){
		return 1;
	}
	
	public int hashcode(){
		return 1;
	}
	
	public boolean move(int row, int col){
		
		if (playerAt(row, col) == EMPTY){
			
			if (marker == 'x'){
				board[row][col] = CROSS;
			} else if (marker == 'o'){
				board[row][col] = CIRCLE;
			}
			
			return true;
			
		} else {
			return false;
		}
	}
	
	//use this to determine if a player has won
	//can win diagonally, vertically, or horizontally
	// there are 8 possible ways to win
	public int playerAt(int row, int col){
		if (board[row][col] == CROSS)
			return CROSS;
		else if (board[row][col] == CIRCLE)
			return CIRCLE;
		else
			return EMPTY;	
	}
	
	public java.lang.String toString(){
		return "yes";
	}
	
	public boolean isOver(){
		
		return true;
	}
	
	public void clearBoard(){
		for (int rows = 0; rows < ROWS; rows++){
			for (int columns = 0; columns < COLUMNS; columns++){
				board[rows][columns] = EMPTY;
			}
		}
	}
	
	public void printBoard(){
		for (int rows = 0; rows < ROWS; rows++){
			for (int columns = 0; columns < COLUMNS; columns++){
				printCell(board[rows][columns]);
			}
			
			System.out.println("");
		}
	}
	
	public void printCell(int cell){
		if (cell == EMPTY)
			System.out.print("-");
		else if (cell == CROSS)
			System.out.print("X");
		else if (cell == CIRCLE)
			System.out.print("O");
	}
	
	/*
	public static void main(String[] args){
		
		TicTacToe game = new TicTacToe();
		game.printBoard();
	}
	*/
	
	
}
