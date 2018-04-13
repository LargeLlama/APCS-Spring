//Wubin Peco
//APCS-2 pd02
//hw33 schmemes
//2018-04-12

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. ...
 *   5. Profit!
 *
 * STACK OF CHOICE: ____ by ____
 * b/c ...
 ******************************************************/

public class Scheme
{
  /****************************************************** 
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr ) 
  {
	if (!expr.substring(0,1).equals("("))
		return expr;

	int startIndex = 0;
	int endIndex = 0;

	for (int i = 0; i < expr.length(); i++) {
		String curr = expr.substring(i, i + 1);
		if (curr.equals("("))
			startIndex = i;
		if (curr.equals(")")) {
			endIndex = i;
			break;
		}
	}

	String inner = expr.substring(startIndex, endIndex + 1);
	int op = 0;
	String operand = inner.substring(2,3);

	if (operand.equals("+"))
		op = 1;
	else if (operand.equals("-"))
		op = 2;
	else
		op = 3;

	String[] list = inner.split("\\s");
	LLStack<String> stack = new LLStack<String>();

	for (String s : list)
		stack.push(s);
	
	String simplified = unload(op, stack);
	expr = expr.substring(0, startIndex) + simplified + expr.substring(endIndex + 1);
	return evaluate(expr);
  }//end evaluate()


  /****************************************************** 
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, LLStack<String> numbers ) 
  {
	int value;
	LLStack<String> temp = new LLStack<String>();
	
	while (!numbers.isEmpty())
		temp.push(numbers.pop());
	numbers = temp;	
	numbers.pop();
	numbers.pop();

	if (op == 1) {
		value = 0;
		while (!numbers.isEmpty()) {
			if (isNumber(numbers.peek()))
				value += Integer.parseInt(numbers.pop());
			else
				numbers.pop();
		}
	}
	else if (op == 2) {
		value = Integer.parseInt(numbers.pop());
		while (!numbers.isEmpty()) {
			if (isNumber(numbers.peek()))
				value -= Integer.parseInt(numbers.pop());
			else
				numbers.pop();
		}
	}
	else {
		value = 1;
		while (!numbers.isEmpty()) {
			if (isNumber(numbers.peek()))
				value *= Integer.parseInt(numbers.pop());
			else
				numbers.pop();
		}
	}
	return Integer.toString(value);
  }//end unload()


 
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }
  


  //main method for testing
  public static void main( String[] args )
  {
	System.out.println(evaluate("( + 1 2 3 4 )"));

    String zoo1 = "( + 4 3 )";
    System.out.println(zoo1);
    System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
    //...7

	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17

	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29

	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
