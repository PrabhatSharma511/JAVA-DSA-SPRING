package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
//		for(Integer num:nums) { this gives concurrentmodificationexception
//			System.out.println(num);
//			if(num%2==0) {
//				nums.remove(num);
//			}
//		}
		
		
		System.out.println(nums);
		Iterator<Integer> it = nums.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			if(it.next()%2==0) {
				it.remove();
			}
		}
		
		ListIterator<Integer> li = nums.listIterator();
		System.out.println(li.nextIndex());
		System.out.println(li.next());
		li.set(25);
		System.out.println(nums);

	
		
	}
	
}
