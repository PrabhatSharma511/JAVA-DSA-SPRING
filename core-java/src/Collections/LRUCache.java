package Collections;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRUCache<K,V> extends LinkedHashMap<K, V> {
	
	private int capacity;
	
	public LRUCache(int capacity) {
		super(capacity,0.75f,true);
		this.capacity=capacity;
	}
	
	//as soon as we insert the 4th entry in this case the topmost entry is removed
	@Override
	protected boolean removeEldestEntry(Entry<K, V> eldest) {
		return size()>capacity;
	}


	public static void main(String[] args) {
		LRUCache<String,Integer> students = new LRUCache<>(3);
		students.put("Bob",90);
		students.put("Alice",78);
		students.put("Ram",99);
//		students.get("Bob"); OR students.put("Bob",23);
		students.put("Prabhat",95);
				
		for(Map.Entry<String,Integer> student:students.entrySet()) {
			System.out.println(student);
		}
	}
	
}
