package Collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskSubmissionSystem {
	//if using BlockingQueue put locks such that when it is using no else can use the queue
	//which is not required in all cases 
	//if producer is adding let consumer read no need of lock her
//	private static BlockingQueue<String> taskQueue = new LinkedBlockingQueue<>();
	private static ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>();


	public static void main(String[] args) {
		Thread producer = new Thread(()-> {
			while(true) {
				try {
					taskQueue.add("Task "+ System.currentTimeMillis());// BlockingQueue case //Adds task will use locks internally
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		Thread consumer = new Thread(()-> {
			while(true) {
				try {
					String task = taskQueue.remove(); // BlockingQueue case //takes task will use locks internally
					System.out.println("Processing "+ task);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		producer.start();
		consumer.start();
	}
	
}
