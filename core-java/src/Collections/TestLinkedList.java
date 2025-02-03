package Collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {

	public static void main(String[] args) {
		
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.addFirst(0);
		ll.addLast(4);
		ll.getLast();
		System.out.println(ll);
		ll.removeIf(x->x%2==0);//takes a predicate and removes elements that satisfy the condition
		System.out.println(ll);
		
		LinkedList<String> animals =new LinkedList<>(Arrays.asList("cat","dog","Lion"));
		LinkedList<String> animalsToRemove = new LinkedList<>(List.of("Lion"));
		animals.removeAll(animalsToRemove); //removeAll method also in ArrayList
		System.out.println(animals);

		
		
//		Node node1 = new Node();
//		Node node2 = new Node();
//		node1.data=1;
//		node2.data=2;
//		node1.next=node2;
//		node2.next=null;
	}
	
}

//class Node{
//	public int data;
//	public Node next;
//}
