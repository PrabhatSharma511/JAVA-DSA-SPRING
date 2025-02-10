package Collections;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeDemo {

	public static void main(String[] args) {
		//non blocking thread safe double ended queue
		ConcurrentLinkedDeque<Integer> d = new ConcurrentLinkedDeque<>();
		d.add(1);
		d.addLast(3);
		d.addFirst(6);
		System.out.println(d);
	}
	
}
