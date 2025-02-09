package Map;

import java.util.Hashtable;

public class HashTableDemo {

	public static void main(String[] args) {
		Hashtable<Integer,String> hashTable = new Hashtable<>();
		
		Thread t1 = new Thread(()->{
			for(int i=0;i<1000;i++) {
				hashTable.put(i,"Thread1");
			}
		});
		
		Thread t2 = new Thread(()->{
			for(int i=0;i<2000;i++) {
				hashTable.put(i,"Thread2");
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(hashTable.size());
		
	}
	
}
