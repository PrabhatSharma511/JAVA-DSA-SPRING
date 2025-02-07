package Collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<>();
		map.put(3,"Ajay");
		map.put(1,"Prabhat");
		map.put(2,"Rahul");
		System.out.println(map);
		System.out.println(map.size());
		System.out.println(map.containsKey(3));//similarly containsValue is also there
		Collection<String> values = map.values();
		System.out.println(values);
//		for(Integer key:map.keySet()) {
//			System.out.println(map.get(key));
//		}
		for(Map.Entry<Integer,String> entry :map.entrySet()) {
			entry.setValue(entry.getValue().toUpperCase());
		}
		System.out.println(map);
		map.remove(3);//removes entry with key 3
		System.out.println(map);



		
		
	}
	
}
