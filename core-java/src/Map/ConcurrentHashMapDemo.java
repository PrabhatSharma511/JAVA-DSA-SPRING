package Map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
	
	public static void main(String[] args) {
		ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
		
		//Java 7 --> segment based locking --> 16 segments --> segments are smaller hashmaps
		//Only the segment being written to or read from is locked
		//read: do not require lock unless there is a write operation happening on same segment
		//write: lock is required
		
		//Java 8 -- no segmentation
		//  --> Compare and Swap Approach -- no locking except resizing or collision
		// Thread A last saw --> x = 45
		//Thread A needs to work --> x set to 50
		//if x is still 45 then change it to 50 otherwise(if it is now not 45 some other thread might have changed it) retry
	}

}
