//KEKE - Ganiel Delfand and Wubin Peco
//APCS-2 pd02
//HW35
//2018-04-16
import java.util.ArrayList;
public class ALQueue<Quasar> implements Queue<Quasar> {
	ArrayList<Quasar> _list;

	public ALQueue() {
		_list = new ArrayList<Quasar>();
	}
	
	public Quasar dequeue() {
		Quasar temp = _list.remove(0);
		return temp;
	} 
	
	public void enqueue(Quasar element) {
		_list.add(element);
	}
	
	public boolean isEmpty() {
		return _list.size() == 0;
	}

	public Quasar peekFront() {
		return _list.get(0);
	}

	public String toString() {
		return _list.toString();
	}

	public static void main(String[] args) {
		ALQueue<String> keke = new ALQueue<String>();
				
	}
}
