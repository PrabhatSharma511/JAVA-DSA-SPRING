package generics;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList list = new ArrayList<>();
		list.add("Hello");
		list.add(123);
		list.add(3.14);
		
		String s = (String) list.get(0);
		String i = (String) list.get(1);
		
		//above code has type safety issue
		//need to manually cast get
	}
	
}
