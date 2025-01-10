package Queue;

import java.util.Stack;

public class QueueUsingTwotacks {

	static class Queue{
		static Stack<Integer> mainStack = new Stack<>();
		static Stack<Integer> helperStack = new Stack<>();
		
		public static boolean isEmpty() {
			return mainStack.isEmpty();
		}
		
		public static void add(int data) {
			
			while(!mainStack.isEmpty()) {
				helperStack.push(mainStack.pop());
			}
			mainStack.push(data);
			while(!helperStack.isEmpty()) {
				mainStack.push(helperStack.pop());
			}
		}
		
		public static int remove() {
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return -1;
			}
			int front = mainStack.pop();
			return front;
		}
		
		public static int peek() {
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return -1;
			}
			int front = mainStack.peek();
			return front;
		}
	}
	
	public static void main(String[] args) {
		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add(3);
		
		while(!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}
	
}
