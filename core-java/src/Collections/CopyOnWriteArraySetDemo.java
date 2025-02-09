package Collections;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {

	public static void main(String[] args) {
		CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
		ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
		
		for(int i=1;i<=5;i++) {
			copyOnWriteArraySet.add(i);
			concurrentSkipListSet.add(i);
		}
		
		System.out.println(copyOnWriteArraySet);
		System.out.println(concurrentSkipListSet);
		
		//copyOnWriteArraySet was a stable photo in which iteration was going on
		//changes are done on a copy and later on referenced to original
		//if use concurrentSkipListSet 6 will also be added and hence printed while iterating only
		//ConcurrentSkipListSet is weakly consistent
		for(Integer num : copyOnWriteArraySet) {
			System.out.println(num+" Reading from copyonwritearrayset");
			//attempting to modfify set during iteration
			copyOnWriteArraySet.add(6);
		}
		System.out.println(copyOnWriteArraySet);


	}
	
}
