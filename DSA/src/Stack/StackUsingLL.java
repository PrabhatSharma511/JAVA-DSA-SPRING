package Stack;

import java.util.List;

public class StackUsingLL {
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data=data;
			next=null;
		}
	}
	
	static class Stack{
		public static Node head;
		
		public static Boolean isEmpty() {
			return head==null;
		}
		
		public static void push(int data) {
			Node newNode = new Node(data);
			if(isEmpty()) {
				head=newNode;
				return;
			}
			newNode.next=head;
			head=newNode;
		}
		
		public static int pop() {
			if(isEmpty()) {
				return -1;
			}
			int top=head.data;
			Node newTop = head.next;
			head=newTop;
			
			return top;
		}
		
		public static int peek() {
			if(isEmpty()) {
				return -1;
			}
			return head.data;
		}
	}
	
	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		
		while(!st.isEmpty()) {
			System.out.println(st.peek());
			st.pop();
		}
		System.out.println(st.peek());
		
	}
	
}
