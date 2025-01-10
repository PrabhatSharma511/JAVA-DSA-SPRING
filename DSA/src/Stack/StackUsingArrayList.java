package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class StackUsingArrayList {

	static class Stackk{
		static ArrayList<Integer> list = new ArrayList<>();
		
		public static Boolean isEmpty() {
			return list.size()==0;
		}
		
		public static void push(Integer data) {
			list.add(data);
		}
		
		public static int pop() {
			if(isEmpty()) {
				return -1;
			}
			Integer top = list.get(list.size()-1);
			list.remove(list.size()-1);
			return top;
		}
		
		public static int peek() {
			if(isEmpty()) {
				return -1;
			}
			Integer top = list.get(list.size()-1);
			return top;
		}
	}
	
	public static void main(String[] args) {
		Stackk st = new Stackk();
		st.push(1);
		st.push(2);
		st.push(8);
		
		System.out.println(st.peek());
		
		//stack using collection framework
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println(s.peek());
		s.pop();
		System.out.println(s.peek());
	}
	
}
