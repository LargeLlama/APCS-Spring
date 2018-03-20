//Wubin Peco
//APCS-2 pd02
//HW21b CONVOY 
//2018-03-19

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
	private String _cargo;
	private LLNode _nextNode;

    // constructor 
	public LLNode(String cargo, LLNode nextNode) {
		_cargo = cargo;
		_nextNode = nextNode;
	}

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
		return _cargo;
    }

    public LLNode getNext()
    {
		return _nextNode;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
	//These mutators need to return the value we're replacing!
	public String setCargo(String newCargo)
    {
		String temp = _cargo;
		_cargo = newCargo;
		return temp;
    }

    public LLNode setNext(LLNode newNext)
    {
		LLNode temp = _nextNode;
		_nextNode = newNext;
		return temp;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
		return _cargo.toString();
    }


    //main method for testing
    public static void main( String[] args )
    {
		LLNode test00 = new LLNode("three", null);
		//THIS IS SUPER IMPORTANT!!
		//I can specify the input as "null" even tho the constructor takes in an input of LLNode
		LLNode test01 = new LLNode("two", test00);
		LLNode test02 = new LLNode("one", test01);
		LLNode test03 = new LLNode("zero", test02);

		//Printing out the cargos
		System.out.println("===========toString()=============");
		System.out.println(test03);
		System.out.println(test02);
		System.out.println(test01);
		System.out.println(test00);

		//printing out nextNode
		System.out.println("=============getNext()=============");
		System.out.println(test00.getNext());
		//This will just print out "null" because that is what the nextNode is defined as
		System.out.println(test01.getNext());
		System.out.println(test02.getNext());
		System.out.println(test03.getNext());

		//testing out setCargo and setNext
		System.out.println("============setCargo()===========");
		System.out.println("old: " + test00.setCargo("3") + "\nnew: " + test00);
		System.out.println("old: " + test01.setCargo("2") + "\nnew: " + test01);
		System.out.println("old: " + test02.setCargo("1") + "\nnew: " + test02);
		System.out.println("old: " + test03.setCargo("0") + "\nnew: " + test03);

		System.out.println("============setNext()=============");
		System.out.println("test00\nold: " + test00.setNext(null) + "\nnew: " + test00.getNext());
		System.out.println("test01\nold: " + test01.setNext(test02) + "\nnew: " + test01.getNext());
		System.out.println("test02\nold: " + test02.setNext(test00) + "\nnew: " + test02.getNext());
		System.out.println("test03\nold: " + test03.setNext(test01) + "\nnew: " + test03.getNext());

		System.out.println("\nnew 'order'");
		System.out.println(test00.getNext());
		System.out.println(test01.getNext());
		System.out.println(test02.getNext());
		System.out.println(test03.getNext());

	

    }//end main

}//end class LLNode
