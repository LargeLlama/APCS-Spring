/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type E
 *****************************************************/

public class DLLNode<E> 
{
	private E _cargo;    //cargo may only be of type E
	private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

	public DLLNode(E value, DLLNode prev, DLLNode next) {
		_cargo = value;
		_nextNode = next;
		_prevNode = prev;
	}

    //--------------v  ACCESSORS  v--------------
    public E getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

	public DLLNode getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------
	
    //--------------v  MUTATORS  v--------------
	
	public E setCargo(E newValue) {
		E temp = _cargo;
		_cargo = newValue;
		return temp;
	}

	public DLLNode setNext (DLLNode newNext) {
		DLLNode temp = getNext();
		_nextNode = newNext;
		return temp;
	}

	public DLLNode setPrev (DLLNode newPrev) {
		DLLNode temp = getPrev();
		_prevNode = newPrev;
		return temp;
	}

	//--------------^  MUTATORS  ^--------------

	public String toString() { return _cargo.toString(); }

}//end class DLLNode
