package Collections;

import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>(4,3);//capacity increases by 7
		
		vector.add(1);
		vector.add(2);
		vector.add(3);
		vector.add(4);
		System.out.println(vector.capacity());
		vector.add(5);
		System.out.println(vector.capacity());
		
		for(int i =0;i<vector.size();i++) {
			System.out.println(vector.get(i));
		}
		//if two threads call add() on an ArrayList at the same time, both may try to write at the same index, leading to one value overwriting the other instead of both being added properly. This results in fewer elements than expected.
		Vector<Integer> list = new Vector<>();//if ArrayList is used size comes less sometimes as ArrayList not thread safe so both threads access add method simultaneosuly and write on it so value of only one thread goes
		 
		Thread t1 = new Thread(()->{
			for(int i=0;i<1000;i++) {
				list.add(i);
			}
		});
		
		Thread t2 = new Thread(()->{
			for(int i=0;i<1000;i++) {
				list.add(i);
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
		
		
		System.out.println("Size of list: "+list.size());
		
	}
	
}
