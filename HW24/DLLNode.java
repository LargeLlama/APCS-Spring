/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode 
{
	private String _cargo;    //cargo may only be of type String
	private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

	public DLLNode(String value, DLLNode prev, DLLNode next) {
		_cargo = value;
		_nextNode = next;
		_prevNode = prev;
	}

    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

	public DLLNode getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


}//end class DLLNode
