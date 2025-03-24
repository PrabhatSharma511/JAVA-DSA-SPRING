package Collections;

import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		System.out.println(stack);
		Integer removedElement = stack.pop();//removes and returns the top element
		System.out.println(stack);
		Integer topElement = stack.peek();//returns the top element and does not remove
		System.out.println(topElement);
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.get(2)+"g");
		
		int search = stack.search(3);
		System.out.println(search);
		
		
		//Stack using LinkedList
		LinkedList<Integer> list = new LinkedList<>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.getLast();//peek//will give 3
		System.out.println(list.removeLast());//pop //will give 2


		
	}
	
}
