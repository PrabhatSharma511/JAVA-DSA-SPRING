package Collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetOverview {

	public static void main(String[] args) {
		
		//Map --> HashMap, LinkedHashmap, TreeMap, EnumMap
		//Set --> HashSet, LinkedHashSet, TreeSet, EnumSet.


		
		Set<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(23);
		set.add(2);
		set.add(56);
		set.add(2);
		set.add(89);
		System.out.println(set);
		
		
		
		//for thread safety
//		Set<Integer> integers = Collections.synchronizedSet(set);
		Set<Integer> int2 = new ConcurrentSkipListSet<>();
		
		//immutable set
		Set<Integer> us = Set.of(1,2,3);
		Set<Integer> us2 = Collections.unmodifiableSet(set);
		System.out.println(us);
	}
	
}
