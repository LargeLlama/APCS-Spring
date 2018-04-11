//Wubin Peco
//APCS-2 pd02
//hw31 yote
//2018-04-10

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/
public class LatKtS
{

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
	Latkes stack = new Latkes(s.length()); //create new stack
	String retString = "";	//init return string
	int counter = 0;	//counter to keep track of indexing

	while(!stack.isFull()) {		//as long as there is room in stack
		stack.push(s.substring(counter, counter + 1));	//push the individual letters/symbols of each string
		counter++;	//increment counter
	}

	while (!stack.isEmpty()) {	//as long as there are items in the stack
		retString += stack.pop();	//pop the item and add it to return string
	}
	//popping occurs in reverse order since we start from the "top" of the stack
	//thus, we end up with a reversed string :)
	return retString;
  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static boolean allMatched( String s )
  {
	if (s.isEmpty())	//if its empty it must return true
		return true;

	Latkes stack = new Latkes(s.length()); //create new stack object to store strings
	for (int i = 0; i < s.length(); i++) {		//loop thru the string
		String tmp  = s.substring(i, i + 1);	//store current symbol

		if (isOpen(tmp)) {	//if its an opening char, push to stack
			stack.push(tmp);
		}else {				//otherwise, run some other checks
			if (stack.isEmpty())	//if stack is empty, close came before open so its false
				return false;
			String last = stack.peek();	//otherwise we peek at the end
			if (matching(last, tmp))	//check if they match
				stack.pop();			//and then remove if they do
			else
				return false;			//if they don't match it's false
		}	
	}
	return stack.isEmpty();	//finally, if there are still opening parentheses in stack there 
							//wasn't any closing ones to complete them so its false
							//otherwise, it should be empty as we popped everything
  }//end allMatched()

//===================helper methods=======================
  //check if char is an opening char
  public static boolean isOpen(String s) {
	return s.equals("(") || s.equals("[") || s.equals("{");
  }
  //checks if two chars are matching closing ones
  //i.e - "{" with "}" is true, so is "[" and "]", and "(" and ")"
  //any other combo will return false
  public static boolean matching(String a, String b) {
	return a.equals("(") && b.equals(")") ||
		   a.equals("[") && b.equals("]") ||
		   a.equals("{") && b.equals("}"); 
  }

  //main method to test
  public static void main( String[] args )
  {
    System.out.println("stressed" + flip("stressed"));
	System.out.println("meme" + flip("meme"));

    System.out.println("true: " + allMatched( "({}[()])" )); //true
    System.out.println("false: " + allMatched( "([)]" ) ); //false
    System.out.println("true: " + allMatched("(){([])}" ) ); //true
    System.out.println("false: " + allMatched( "](){([])}" ) ); //false
    System.out.println("false: " + allMatched( "(){([])}(" ) ); //false
    System.out.println("true: " + allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	System.out.println("false: " + allMatched("((((((()))))))))))))))"));
	System.out.println("true: " + allMatched(""));
	System.out.println("true: " + allMatched("[]{}(())"));

    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
