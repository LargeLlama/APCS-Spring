/*****************************************************
 * class Stckr
* driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr 
{

public static String printStack(Stack<String> stack) {
	String retString = "";

	while(!stack.isFull()) {
		retString += stack.pop() + ", ";
	}
	
	return retString;
	
}

public static void main( String[] args )
{
	Stack<String> cakes = new ALStack<String>(10);
	cakes.push("aoo");
	cakes.push("boo");
	cakes.push("coo");
	cakes.push("doo");
	cakes.push("eoo");
	cakes.push("foo");
	cakes.push("goo");
	cakes.push("hoo");
	cakes.push("ioo");
	cakes.push("joo");
    cakes.push("coocoo");
    cakes.push("cachoo");
	System.out.println(printStack(cakes));

//Stack cakes = new LLStack()...

}

}//end class

