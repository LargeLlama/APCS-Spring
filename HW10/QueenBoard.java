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
	  return solveH(0); //gotta start from the basics
  }

  
  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
	  if (col >= _board.length) {		//once we reach the end of the line, we're done
		  return true;
	  }else {							//otherwise, we keep fighting
		  for (int i = 0; i < _board.length; i++) {	//loop thru each row
			  if (addQueen(i, col)) { 				//if u can add a queen
				  addQueen(i, col);					//then add it 
	
				  if (solveH(col + 1))		//normally i'd return this value but there is an else portion to it
					  return true;
				  removeQueen(i, col);		//if this configuration does not work we have to remove the original queen and try again
			  }
		  }
	  }

	  return false;		//if we try everything and it no work then its a falso
  }

    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */

  public void printSolution()
  {
	  for (int i = 0; i < _board.length; i++) {
		  for (int n = 0; n < _board[i].length; n++) {
			  if (_board[i][n] <= 0)
				System.out.print("_\t");
			  else
				System.out.print("\u001B[31mQ\u001B[0m\t");

		  }
		  System.out.println("\n");
	  }
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * <General description>
   * precondition: given two ints, row and col, that are within the range of acceptable values for _board 
   * postcondition: return a boolean stating whether it's possible to add a queen at the given coordinates, as well as
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){	//a value not equal to zero indicates a queen is present, thus the spot is occupied and cannot be placed
								//a value not equal to zero also indicates that a queen cannot be placed there
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
    if ( _board[row][col] != 1 ) {	//confirms there is a queen to be removed
	    return false;	
    }
    _board[row][col] = 0;
    int offset = 1;	//sets the initial offset of 1

    while( col+offset < _board[row].length ) {		//same as the addQueen method, except it incremements instead of decrements
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
	/*=====================yeet bar=================
    System.out.println(b);
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
	===============================================*/
	System.out.println("Board size: 5x5");
	b.solve();
	b.printSolution();

	//this doesn't have anysolutions, wanted to make sure it wouldn't break the code!
	System.out.println("Board size: 2x2");
	QueenBoard c = new QueenBoard(2);
	c.solve();
	c.printSolution();

	System.out.println("Board size: 8x8");
	QueenBoard d = new QueenBoard(8);

	d.solve();
	d.printSolution();
  }
    
}//end class
