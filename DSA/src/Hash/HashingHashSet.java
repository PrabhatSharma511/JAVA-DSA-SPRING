package Hash;

import java.util.HashSet;
import java.util.Iterator;

public class HashingHashSet {
	
	public static void main(String args[]) {
	
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);
		
		System.out.println("Size of set is " + set.size());
		System.out.println("All elements of set are: "+set);
		
//		if(set.contains(1)) {
//			System.out.println("set contains 1");
//		}
//		if(!set.contains(6)) {
//			System.out.println("set does not contains 6");
//		}
//		
//		set.remove(1);
//		if(!set.contains(1)) {
//			System.out.println("set does not contains 1 - deleted");
//		}
		
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
