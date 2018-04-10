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
	Latkes temp = new Latkes(s.length());
	String retString = "";

	for (int i = 0; i < s.length(); i++) {
		temp.push(s.substring(i, i + 1));
	}

	while (!temp.isEmpty()) {
		retString += temp.pop();		
	}
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
	return true;	
  }//end allMatched()


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
	System.out.println(flip("meme"));
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
