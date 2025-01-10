package LinkedList;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class LLCollection {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		
		list.addFirst("a");
		list.addFirst("is");
		
		System.out.println(list);
		
		list.addFirst("this");
		list.addLast("list");
		System.out.println(list);
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" -> ");
		}
		System.out.println("NULL");
		
//		list.removeFirst();
//		System.out.println(list);
//		
//		list.removeLast();
//		System.out.println(list);
		
		list.remove(2);
		System.out.println(list);
		
		LinkedList<Integer> numList = new LinkedList<>();
		numList.add(1);
		numList.add(2);
		numList.add(3);
		System.out.println(numList);
		Collections.reverse(numList);
		System.out.println(numList);
		
	}
	
}
