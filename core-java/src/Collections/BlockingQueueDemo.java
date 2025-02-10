package Collections;

import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;


class Producer implements Runnable{
	private BlockingQueue<Integer> queue;
	private int value = 0;
	
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("Producer produced: "+ value);
				queue.put(value++);
				Thread .sleep(1000);
			} catch (Exception e) {
				Thread.currentThread().interrupt();
				// TODO: handle exception
			}
		}
	}

}

class Consumer implements Runnable{
	private BlockingQueue<Integer> queue;
	
	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Integer val = queue.take();
				System.out.println("Consumer consumed: "+ val);
				Thread .sleep(2000);
			} catch (Exception e) {
				Thread.currentThread().interrupt();
				// TODO: handle exception
			}
		}
	}

}

public class BlockingQueueDemo {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(5);
		Thread prod = new Thread(new Producer(bq));
		Thread cons = new Thread(new Consumer(bq));
//		prod.start();
//		cons.start();
		
		
		//optionally bounded
		//backed by LL
		//uses seperate locks for enqueue and dequeue
		//higher concurrency
		BlockingQueue<Integer> bq2 = new LinkedBlockingQueue<>();
		
		
		//binary heap as array and can grow dynamically
		//elements order according to their natural ordering or provided comparator
		//put wont block as it is unbounded
		BlockingQueue<String> bq3 = new PriorityBlockingQueue<>(11,Comparator.reverseOrder());
		bq3.add("apple");
		bq3.add("banana");
		bq3.add("cherry");
		System.out.println(bq3);

		
		
		
		
		
		
		// BlockingQueue --> thread safe queue
		//wait for queue to become non-empty / waits for space
		//simplify concurrency problems like producer-consumer
		//standard queue --> immediately execute operations
		        //empty --> remove(no waiting)
		        // full --> add(no waiting)
		// Blocking queue
		//put -> blocks if the queue is full until space becomes available
		//take -> blocks if queue is empty until space becomes available
		//offer - > waits for space to become available upto the specified timeout.

	}
	
}
