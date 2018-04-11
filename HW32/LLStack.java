//Wubin Peco
//APCS-2 pd02
//hw32 yurd
//2018-04-11
import java.util.LinkedList;

public class LLStack<T> implements Stack<T> {
	private LinkedList<T> _stack;
	private int _stackSize;

	public LLStack(int size) {
		_stack = new LinkedList<T>();
		_stackSize = 0;
	}
	
	public boolean isEmpty() {
		return _stackSize == 0;
	}

	public T peek() {
		return _stack.get(_stackSize - 1);
	}

	public T pop() {
		T temp = _stack.remove(_stackSize - 1);
		return temp;
	}

	public void push (T x) {
		_stack.add(x);
		_stackSize++;
	}
}
