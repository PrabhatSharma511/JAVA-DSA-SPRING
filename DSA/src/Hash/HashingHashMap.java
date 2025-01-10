package Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashingHashMap {
	
	public static void main(String args[]) {
		
		HashMap<String,Integer> map = new HashMap<>();
		map.put("India",143);
		map.put("China",141);
		map.put("USA",34);
		
		System.out.println(map);
		map.put("India",150);
		System.out.println(map);
		
		if(map.containsKey("India")) {
			System.out.println("key is present in the Map");
		}else {
			System.out.println("key is not present in the Map");
		}
		
		System.out.println(map.get("India"));
		System.out.println(map.get("UK"));
		
//		for(Map.Entry<String,Integer> e : map.entrySet()) {
//			System.out.println(e.getKey()+" : "+e.getValue());
//		}
		
		Set<String> keys = map.keySet();
		for(String key:keys) {
			System.out.println(key+" : "+map.get(key));
		}
		
		map.remove("China");
		System.out.println(map);
	}

}
