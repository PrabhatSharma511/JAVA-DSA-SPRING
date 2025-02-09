package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {
	
	public static void main(String[] args) {
		Map<String,Integer> map1 = new HashMap<>();
		map1.put("A",1);
		map1.put("B",2);
		Map<String,Integer> map2 = Collections.unmodifiableMap(map1);
		//map2.put("C",3); throws exception
		System.out.println(map2);
		//another way of creating immutable map
		Map<String,Integer> map3 = Map.of("Prabhat",84,"Alice",45);
		//map3.put("Bob",67);//throws exception
		System.out.println(map3);
		
		Map<String,Integer> map4 = Map.ofEntries(Map.entry("Prabhat",84),Map.entry("Alice",45));
		System.out.println(map4);


		
	}

}
