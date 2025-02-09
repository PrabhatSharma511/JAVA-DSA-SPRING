package Map;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {

	public static void main(String[] args) {
		SortedMap<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
		map.put("Prabhat",84);
		map.put("N", 78);
		map.put("B",67);
		map.put("Fauji", 88);
//		System.out.println(map);
		System.out.println(map.firstKey()+" "+map.lastKey());
//		System.out.println(map.headMap("N"));
//		System.out.println(map.tailMap("N"));
		
		
		NavigableMap<Integer,String> navigableMap = new TreeMap<>();
		navigableMap.put(1,"One");
		navigableMap.put(5,"Five");
		navigableMap.put(3,"Three");
		System.out.println(navigableMap);
		System.out.println(navigableMap.lastKey());
		System.out.println(navigableMap.lowerKey(2));
		System.out.println(navigableMap.higherKey(1));
		System.out.println(navigableMap.higherKey(5));
		System.out.println(navigableMap.ceilingKey(4));//floorKey is also a method


		System.out.println(navigableMap.pollLastEntry());
		System.out.println(navigableMap);
		System.out.println(navigableMap.pollFirstEntry());
		System.out.println(navigableMap);



		

		

		
		
	}
	
}
