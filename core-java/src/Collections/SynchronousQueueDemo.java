package Collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

	public static void main(String[] args) {
		
		// It cannot store elements, capacity of atmost one element.
		BlockingQueue<String> bq = new SynchronousQueue<>();

		
		Thread producer = new Thread(()->{
			try {
				System.out.println("Producer is waiting to transfer...");
				bq.put("Hello from producer");
				System.out.println("Producer has transferred the message");

			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		
		Thread consumer = new Thread(()->{
			try {
				System.out.println("Consumer is waiting to consume...");
				String msg = bq.take();
				System.out.println("Consumer has received the message "+msg);

			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		
		producer.start();
		consumer.start();
	}
	
}
