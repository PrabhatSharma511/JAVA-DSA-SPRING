package Collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

	public static void main(String[] args) {
		
		/* INSERTION METHODS
		 * addFirst(E e): Inserts the specified element at the front
		 * addLast(E e): Inserts the specified element at the end
		 * offerFirst(E e): Inserts the specified element at the front if possible
		 * offerLast(E e): Inserts the specified element at the end if possible
		 */
		//similarly remove/poll and get/peek methods are there for front and last
		/* STACK METHODS
		 * push(E e): Adds an element at the first equivalent to addFirst(E e).
		 * pop(): removes and returns the first element equivalent to removeFirst().
		 */
		
		//no need to shift elements just shift head head tail
		Deque<Integer> d1 = new ArrayDeque<>();
		d1.addFirst(10);
		d1.addLast(20);
		d1.offerFirst(5);
		d1.offerLast(25);
		System.out.println(d1);
		System.out.println("first: "+d1.getFirst());
		System.out.println("first: "+d1.getLast());
		d1.remove();//removes 5
		d1.pollLast();//removes 25
		for(int num:d1) {
			System.out.println(num);
		}
		
		Deque<Integer> d2 = new LinkedList<>();//preferred when insertion deletion in middle
		d2.add(2);
		d2.add(4);
		d2.add(1);
		d2.add(8);
		d2.add(6);
		System.out.println(d2);
		d2.remove(1);//removes first occurrence of 
		System.out.println(d2);

		
	}
	
}
