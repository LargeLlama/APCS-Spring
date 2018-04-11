/*****************************************************
 * class Stckr
* driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr 
{

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
	System.out.println(cakes.printStack());

	while(!cakes.isEmpty()) {
		cakes.pop();
	}
	System.out.println(cakes.printStack());

	Stack<String> cookies = new LLStack<String>(10);
	cookies.push("aoo");
	cookies.push("boo");
	cookies.push("coo");
	cookies.push("doo");
	cookies.push("eoo");
	cookies.push("foo");
	cookies.push("goo");
	cookies.push("hoo");
	cookies.push("ioo");
	cookies.push("joo");
    cookies.push("coocoo");
    cookies.push("cachoo");
	System.out.println(cookies.printStack());

	while(!cookies.isEmpty()) {
		cookies.pop();
	}
	System.out.println(cookies.printStack());


}

}//end class

