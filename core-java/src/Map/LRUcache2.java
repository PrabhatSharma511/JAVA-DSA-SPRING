package Map;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUcache2<K,V> extends LinkedHashMap<K, V>{
	
	int capacity;
	
	public LRUcache2(int capacity) {
		super(capacity,0.75f,true);
		this.capacity=capacity;
	}
	
	
	@Override
	protected boolean removeEldestEntry(Entry<K, V> eldest) {
		return size()>capacity;
	}




	public static void main(String[] args) {
		LRUcache2<Integer, Integer> map= new LRUcache2<>(3);
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		System.out.println(map);
		System.out.println(map.get(1));
		map.put(4, 4);
		System.out.println(map);
	}
}
