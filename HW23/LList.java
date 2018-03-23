//GOD'S PLAN - Max Millar and Wubin Peco
//APCS-2 pd02
//hw23 ya yeet ya
//2018-03-22
//yall vibing with linked lists?

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{ 

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
		_head = null; //at birth, a list has no elements
		_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( String newVal )
    {
		LLNode tmp = new LLNode( newVal, _head );
		_head = tmp;
		_size++;
		return true;
    }

	public void add(int index, String newVal)  {
		if ( index < 0 || index >= size() )
			throw new IndexOutOfBoundsException();
	
		if (index == 0) {
			this.add(newVal);
			return; 
		}

		LLNode tmp = _head;
		
		for(int i = 0; i < index; i++) {
			tmp = tmp.getNext();
		}

		LLNode newNode = new LLNode(newVal, tmp);

		tmp = _head;
		for(int i = 0; i < index - 1; i++) {
			tmp = tmp.getNext();
		}

		tmp.setNext(newNode);
	}

	public String remove(int index) {
		if ( index < 0 || index >= size() )
			throw new IndexOutOfBoundsException();
		if ( index == 0)
			_head = _head.getNext();

		//thanks to aliasing, creating a tmp variable works haha!
		LLNode tmp = _head;
		
		for(int i = 0; i < index - 1; i++) {
			tmp = tmp.getNext();
		}
		
		LLNode alsoTmp = _head;
		
		for(int i = 0; i < index + 1; i++) {
			alsoTmp = alsoTmp.getNext();
		}
		tmp.setNext(alsoTmp);
		return "";
	}
    
    public String get( int index )
    {
		if ( index < 0 || index >= size() )
			throw new IndexOutOfBoundsException();

		String retVal;
		LLNode tmp = _head; //create alias to head

		//walk to desired node
		for( int i=0; i < index; i++ )
			tmp = tmp.getNext();

		//check target node's cargo hold
		retVal = tmp.getCargo();
		return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }
    
    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );

	james.add(2, "you're mom");
	System.out.println(james);

	james.remove(2);
	System.out.println(james);

	james.remove(3);
	System.out.println(james);

	james.remove(0);
	System.out.println(james);

	james.add(0, "you");
	System.out.println(james);

	james.add(3, "GOD'S PLAN");
	System.out.println(james);

    }

}//end class LList


