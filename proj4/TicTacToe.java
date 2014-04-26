/**
 * make int player and have that be 1 or 2
 * make set mark so it determines the char for x and o
 * finish win sections, so they equal player 
 * make it so the game rotates turns
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
	
	//public char marker; // x or o will have to be changed later
	public int player1;
	public int player2;
	
	public boolean turn = true; // used to track which turn has occurred. true for p1 false for p2
	
	//my board
	int[][] board;
	
	public TicTacToe(){
		board = new int[ROWS][COLUMNS];	
	//	clearBoard(); //may have to change this constructor later
	}
	
	//added method that might have to be removed
	public void setMarker(int player){
		//this.marker = marker;
		//this.player = player;
		
		if (player == 1){
			player1 = CROSS; // 1 is for x's
		}
		
		if (player == 2){
			player2 = CIRCLE; //2 is for o's
		}
	}
	
	public int getWinner(){
		return 1;
	}
	
	public int hashcode(){
		return 1;
	}
	
	
	//add is over in here somehow
	public boolean move(int row, int col){
		
		//if (!isOver()){
			if (playerAt(row, col) == EMPTY){
				if(turn){
					board[row][col] = player1;
					
					if(!isOver(player1)){
						turn = false;
					}
					
				}else if (!turn){
					
					board[row][col] = player2;
					
					if(!isOver(player2)){
						turn = true;
						
					}
				}
				
				return true;
			}else{
				return false;
			}
		//}else {
		//	clearBoard();
		//return false;
		//}
		
		
		/*
			if (playerAt(row, col) == EMPTY){
				
				if (turn){
					
					board[row][col] = player1;
					
					if(!isOver()){
						turn = false;
					}else
						clearBoard();
					
				} else if (!turn){
					
					board[row][col] = player2;
					if(!isOver()){
						turn = true;
					} else
						clearBoard();
				}
				
				return true;
				
			} else {
				return false;
			}
			*/
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
	
	public boolean isOver(int currentPlayer){
		/*
		int currentPlayer = -1;
		//System.out.println(currentPlayer);
		if (turn){
			currentPlayer = player1;
			//System.out.println(currentPlayer);
		}else {
			currentPlayer = player2;
			//System.out.println(currentPlayer);
		}*/
		
		if (board[0][0] == currentPlayer && board[0][1] == currentPlayer && board[0][2] == currentPlayer){
			System.out.println("Player " + currentPlayer + " just won!!");
			//clearBoard();
			return true;
		}else if (board[1][0] == currentPlayer && board[1][1] == currentPlayer && board[1][2] == currentPlayer){
			System.out.println("Player " + currentPlayer + " just won!!");
			//clearBoard();
			return true;
		}else if (board[2][0] == currentPlayer && board[2][1] == currentPlayer && board[2][2] == currentPlayer){
			System.out.println("Player " + currentPlayer + " just won!!");
			//clearBoard();
			return true;
		}else if(board[0][0] == currentPlayer && board[1][0] == currentPlayer && board[2][0] == currentPlayer) {
			System.out.println("Player " + currentPlayer + " just won!!");
			//clearBoard();
			return true;
		}else if(board[0][1] == currentPlayer && board[1][1] == currentPlayer && board[2][1] == currentPlayer) {
			System.out.println("Player " + currentPlayer + " just won!!");
			//clearBoard();
			return true;
		}else if(board[0][2] == currentPlayer && board[1][2] == currentPlayer && board[2][2] == currentPlayer) {
			System.out.println("Player " + currentPlayer + " just won!!");
			//clearBoard();
			return true;
		}else if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer){
			System.out.println("Player " + currentPlayer + " just won!!");
			//clearBoard();
			return true;
		}else if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer){
			System.out.println("Player " + currentPlayer + " just won!!");
			//clearBoard();
			return true;
		}else {
			return false;
		}
		
		//add clear board so it occurs before it returns that the game is over
		
		//return false;
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
