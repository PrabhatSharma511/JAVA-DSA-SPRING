package Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
	
	public static void main(String[] args) {
		LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
		linkedHashMap.put("Apple",20);
		linkedHashMap.put("Mango",30);
		linkedHashMap.put("Guava",40);
		
		linkedHashMap.get("Mango");
		linkedHashMap.get("Apple");
		
		linkedHashMap.putIfAbsent("Apple", 0);
		
		for(Map.Entry<String,Integer> entry:linkedHashMap.entrySet()) {
			System.out.println(entry);
		}
		
		
		System.out.println(linkedHashMap.getOrDefault("Banana",12));
		
	}

}
