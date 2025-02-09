package Map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {

	public static void main(String[] args) {
		//if use HashMap hashcode of key1 and key2 is same because calculated using String class hashcode method
		//which uses each character of the given string to generate hashcode
		//if use IdentityHashMap hashcode of key and key2 is diff. because it use Object class hashcode method
		//which is based on memory address and key1 key2 have diff. memory address
		String key1 = new String("key");
		String key2 = new String("key");
		
		Map<String,Integer> map = new IdentityHashMap<>();
		map.put(key1, 1);
		map.put(key2, 2);
		System.out.println(map);

	}
	
}
