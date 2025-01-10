package Queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionQueue {

	public static void main(String[] args) {
//		Queue<String> q = new PriorityQueue<>();
//		q.add("David");
//		q.add("Gappy");
//		q.add("Zombie");
//		q.add("Parry");
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(10);
		q.add(234);
		q.add(12);
		q.add(1);
		
		q.remove(234);
		
		while(!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}
	
}
