//WUbin Peco
//APCS pd 2
//HW10 - queens
//2018-02-27
//ahhhhhh

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
  private int[][] _board;
//matrix to simulate a chess board
    
  public QueenBoard( int size ) 
  {
    _board = new int[size][size]; //creates an n x n board
  }

  
  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve()
  {
    return false;
  }

  
  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
    return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * <General description>
   * precondition: given two ints, row and col, that are within the range of acceptable values for _board 
   * postcondition: return a boolean stating whether it's possible to add a queen at the given coordinates, as well as
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){	//a value not equal to zero indicates a queen is present, thus the spot is occupied and cannot be placed
	    return false;	
    }
	//otherwise, we set the value at the given coordinate to 1
    _board[row][col] = 1;

    int offset = 1;

    while(col+offset < _board[row].length){	//as long as the offset won't move the queen off the board, which prevents any index out of bounds exceptions
	    _board[row][col+offset]--; //decrement the int directly next to given row and col

	    if(row - offset >= 0){		//if it won't go too far to the left of the board
    	    _board[row-offset][col+offset]--;	//decrement the int diagonal of the given row and col
												//this one is in the row below
	    }

	    if(row + offset < _board.length){	//if it won't go too far to the right of the board
	        _board[row+offset][col+offset]--;	//decrement the int diagonal of the given row and col
												//this one is in the row above
	    }

	    offset++;	//keep incrementing the offset
    }
    return true;	//return true, indicating the position was valid
  }


  /***
   * <General description>
   * precondition: given two ints, row and col, that are within the range of acceptable values for _board
   * postcondition: return a boolean that indicates that a queen can be removed
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;

	    if( row - offset >= 0 ) {
	        _board[row-offset][col+offset]++;
	    }

	    if( row + offset < _board.length ) {
	        _board[row+offset][col+offset]++;
	    }
	
	    offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition: object is initialized 
   * postcondition: return a string that is user-readable of the board
   */
  public String toString() 
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
    	    ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
  }
    
}//end class
