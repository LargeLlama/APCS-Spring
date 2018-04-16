//Wubin Peco
//APCS-2 pd02
//2018-04-16
//hw34 sorry

public class NodeQueue<Quasar> implements Queue<Quasar> {
	//variables
	LLNode<Quasar> front;
	LLNode<Quasar> back;
	
	//init variables to value of null (empty queue)
	public NodeQueue() {
		front = null;
		back = null;
	}
	//remove item from front of queue and returns it
	public Quasar dequeue() {
		Quasar dequeued = front.getValue();	//get the value of the first element
		front = front.getNext();	//set the front to the next one (null)
		return dequeued;
	}	
	
	public void enqueue(Quasar x) {
		if(this.isEmpty()) {
			front = new LLNode(x, null);
			back = front;
			return;
		}
		back.setNext( new LLNode(x, back.getNext()));
		back = back.getNext();
	}

	public boolean isEmpty() {
		return front == null;
	}

	public Quasar peekFront() {
		return front.getValue();
	}

	public static void main(String[] args) {	
	}	
}
