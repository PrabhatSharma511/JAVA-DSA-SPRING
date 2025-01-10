package Stack;

import java.util.Stack;

public class PushAtBottom {
	
	private static void pushtAtBottom(Stack<Integer> st, int i) {
		
		if(st.isEmpty()) {
			st.push(i);
			return;
		}
		
		Integer top = st.peek();
		st.pop();
		pushtAtBottom(st, i);
		st.push(top);
		
	}
	
	private static Stack<Integer> reverseStack(Stack<Integer> st) {
		Stack<Integer> newStack = new Stack<>();
		while(!st.isEmpty()) {
			Integer top = st.peek();
			newStack.push(top);
			st.pop();
		}
		
		return newStack;
		
	}
	
	private static void reverseStackOptimised(Stack<Integer> st) {
		if(st.isEmpty()) {
			return;
		}
		Integer top = st.pop();
		reverseStackOptimised(st);
		pushtAtBottom(st, top);
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		
//		pushtAtBottom(st,4);
//		
//		while(!st.isEmpty()) {
//			System.out.println(st.peek());
//			st.pop();
//		}
		
//		Stack<Integer> rev = reverseStack(st);
//		
//		while(!rev.isEmpty()) {
//			System.out.println(rev.peek());
//			rev.pop();
//		}
		reverseStackOptimised(st);
		while(!st.isEmpty()) {
		System.out.println(st.peek());
		st.pop();
	}
	}

	
	
}
