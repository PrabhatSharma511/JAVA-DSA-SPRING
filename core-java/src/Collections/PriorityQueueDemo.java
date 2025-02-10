package Collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		//orders elements based on their natural ordering(for primitives lowest first)
		Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		pq.add(3);
		pq.add(4);
		pq.add(1);
		pq.add(8);
		System.out.println(pq);//not sorted
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
		//Internal working
		//priority queue is implemented as a min heap by default(for natiral ordering)

	}
	
}
