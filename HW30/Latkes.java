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
  private String [] _stack;
  private int _stackSize;

  //constructor
  public Latkes( int size )
  {
	_stackSize = size;
	_stack = new String[size];
  }

  //means of insertion
  public void push( String s )
  {

	for(int i = 0; i < _stackSize; i++) {
		if (_stack[i] == null) {
			_stack[i] = s;
			break;
		}
	}
		
  }

  //means of removal
  public String pop()
  {
	
  }

  //chk for emptiness
  public boolean isEmpty()
  {
	return true;
  }

  //chk for fullness
  public boolean isFull()
  {
	return true;
  }

//==============HELPER================
  public String printArray() {
	String retString = "";
	for (String s : _stack) 
		retString += (s + ", ");
	return retString;
  }
  public String toString() {
	return printArray();
  }

  //main method for testing
  public static void main( String[] args )
  {
      Latkes tastyStack = new Latkes(10);
	  System.out.println(tastyStack);
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
      tastyStack.push("coocoo");
      tastyStack.push("cachoo");
	
	  System.out.println(tastyStack);
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

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

      //stack empty by now; SOP(null)
      System.out.println( tastyStack.pop() );
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
