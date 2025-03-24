package Collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);//enqueue add at last only
		q.add(2);
		q.add(3);
		q.add(null);

		System.out.println(q);
		q.remove();//dequeue remove from front only
		System.out.println(q);
		q.peek();//peek only return element without removing
		
		Queue<Integer> q2 = new LinkedList<>();
		
		q2.add(4);
		System.out.println(q2.remove());//throws exception if empty
		System.out.println(q2.poll());//null, otherwise element

		System.out.println(q2.peek());//null, otherwise element
//		System.out.println(q2.element());//throws exception if empty
		
		
		//to study capacity full for add and offer method
		Queue<Integer> q3 = new ArrayBlockingQueue<>(2);
		System.out.println(q3.add(34));
//		q3.add(34);
		q3.offer(67);
		System.out.println(q3.offer(21));//no exception returns true/false that element added or not
		System.out.println(q3.add(21));
//		q3.add(21); //gives exception queue is full

	}
	
}
