//Plane Jane - Wubin Peco and William Lu
//APCS-2 pd02
//HW36 yote
//2018-04-17

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;
  private boolean sampled;

  // default constructor creates an empty queue
  public RQueue() 
	{ 
		_front = null;
		_end = null;
		_size = 0;
		sampled = false;
	}//end default constructor


  public void enqueue( T enQVal ) 
  {
	if (isEmpty()) {
		_front = new LLNode(enQVal, null);
		_end = _front;
		_size++;
		return;
	}
	_end.setNext( new LLNode(enQVal, _end.getNext()));
	_end = _end.getNext();
	_size++;
  }


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue() 
  { 
	T temp = _front.getValue();
	if (sampled) {
		sampled = false;
		_size--;
		return temp;
	}
	sample();
	_front = _front.getNext();
	_size--;
	return temp;
  }//end dequeue()


  public T peekFront() 
  {
	return _front.getValue();
  }


  /******************************************
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   * ...
   * 
   ******************************************/
  public void sample () 
  {
	int random = (int)(_size * Math.random());

	for (int i = 0; i < random; i++) {
		LLNode tmp = _front;
		_front = _front.getNext();
		enqueue(tmp.getValue());
	}
	
  }//end sample()


  public boolean isEmpty() 
  {
	return _size == 0;
  } //O(?)


  public T front() {
	sampled = true;
	sample();
	return peekFront();
  }
    // print each node, separated by spaces
  public String toString() 
  { 
	LLNode tmp = _end;
	String retString = "";
	for (int i = 0; i < _size; i++) {
		retString += tmp.getValue() + " ";
		tmp = tmp.getNext();
	}
	return retString;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {

      Queue<String> PirateQueue = new RQueue<String>();

      System.out.println("\nnow enqueuing..."); 
      PirateQueue.enqueue("Dread");
      PirateQueue.enqueue("Pirate");
      PirateQueue.enqueue("Robert");
      PirateQueue.enqueue("Blackbeard");
      PirateQueue.enqueue("Peter");
      PirateQueue.enqueue("Stuyvesant");

      System.out.println("\nnow testing toString()..."); 
      System.out.println( PirateQueue ); //for testing toString()...

      System.out.println("\nnow dequeuing..."); 
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );

      System.out.println("\nnow dequeuing fr empty queue..."); 
      System.out.println( PirateQueue.dequeue() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v


      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
