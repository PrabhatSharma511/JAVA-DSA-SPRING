package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

	public static void main(String[] args) {
		List<String> shoppingList = new CopyOnWriteArrayList<>();
		shoppingList.add("Milk");
		shoppingList.add("Jam");
		shoppingList.add("Bread");
		
		for(String item : shoppingList) {
			System.out.println(item);
			//try to modify list while reading not possible with ArrayList
			if(item=="Milk") {
				shoppingList.add("Honey");
			}
		}
		System.out.println(shoppingList);
		
		List<String> sharedList = new CopyOnWriteArrayList<>();//using arrayList gives concurrentmodification exception
		sharedList.add("item1");
		sharedList.add("item2");
		sharedList.add("item3");
		
		Thread readerThread = new Thread(()->{
			try {
				while(true) {
					for(String item : sharedList) {
						System.out.println("Reading Item "+ item);
						Thread.sleep(100);//delay to simulate work
					}
				}
			} catch (Exception e) {
				System.out.println("Exception in reader thread "+ e);
			}
		});
		
		Thread writerThread = new Thread(()->{
			try {
				Thread.sleep(500);
				sharedList.add("item4");
				System.out.println("item4 added to the list");
				
				Thread.sleep(500);
				sharedList.remove("item1");
				System.out.println("item1 removed from the list");
			} catch (Exception e) {
				System.out.println("Exception in writer thread "+ e);
			}
		});
		
		writerThread.start();
		readerThread.start();

	}
	
}
