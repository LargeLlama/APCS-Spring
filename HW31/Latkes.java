//Wubin Peco
//APCS-2 pd02
//hw30 stack it up baby
//2018-04-09

/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an encapsulated array
 *****************************************************/
public class Latkes
{
  private String [] _stack; //immutable
  private int _stackSize;	//keep track of # of elements

  //constructor
  public Latkes( int size )
  {	
	_stackSize = 0;	//will always be 0 at first
	_stack = new String[size];	//will be limited to the given size
  }

  //means of insertion
  public void push( String s )
  {
	//we only push if it isn't full
	//normally, would through a StackOverflowError but in this case
	//we ignore illegal additions
	if (!isFull()) {
		_stack[_stackSize] = s;
		_stackSize++;	
		return;
	}
  }

  //means of removal
  public String pop()
  {
	//can only pop if there is an item to pop
	if(!isEmpty()) {
		String tmp = _stack[_stackSize - 1];	//store tmp string
		_stack[_stackSize - 1] = null;			//set back to null
		_stackSize--;							//decrement stack size
		return tmp;								//return the temp string 
	}
	return null;		//otherwise nothing was removed so we return null
  }

  //chk for emptiness
  public boolean isEmpty()
  {
	return _stackSize == 0;	//is empty when stack size is 0 - ez
  }

  //chk for fullness
  public boolean isFull()
  {
	return _stackSize == _stack.length;	//is full when the # of elements is = to the length
  
  }
//=========HELPER METHOD=========//
//prints out the stack to keep track of the items in there
  public void printStack() {
	for (String s : _stack) 
		System.out.print(s + ", ");
	System.out.println();
  }

  //main method for testing
  public static void main( String[] args )
  {
      Latkes tastyStack = new Latkes(10); //init a new latkes obj of size 10
	  //push all these strings to the stack
      tastyStack.push("aoo");
      tastyStack.push("boo");
      tastyStack.push("coo");
      tastyStack.push("doo");
      tastyStack.push("eoo");
      tastyStack.push("foo");
      tastyStack.push("goo");
      tastyStack.push("hoo");
      tastyStack.push("ioo");
      tastyStack.push("joo");
//==========extra============
//these will NOT be pushed because the stack is full at this point
      tastyStack.push("coocoo");
      tastyStack.push("cachoo");
	
	  //print the memory address of the tastyStack obj and the contents of the stack
	  System.out.println(tastyStack);
	  tastyStack.printStack();

      //cachoo
      System.out.println( tastyStack.pop() );
      //coocoo
      System.out.println( tastyStack.pop() );
      //joo
      System.out.println( tastyStack.pop() );
      //ioo
      System.out.println( tastyStack.pop() );
      //hoo
      System.out.println( tastyStack.pop() );
      //goo
      System.out.println( tastyStack.pop() );
      //foo
      System.out.println( tastyStack.pop() );
      //eoo
      System.out.println( tastyStack.pop() );
      //doo
      System.out.println( tastyStack.pop() );
      //coo
      System.out.println( tastyStack.pop() );
      //boo
      System.out.println( tastyStack.pop() );
      //aoo
      System.out.println( tastyStack.pop() );
	  //idk what this top is going on about the stack cant be filled past its limit lol

      //stack empty by now; SOP(null)
      System.out.println( tastyStack.pop() );
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
