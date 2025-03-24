package executorFramework;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchPractice {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cl = new CountDownLatch(3);
		
		for(int i=0;i<3;i++) {
			new Thread(()->{
				try {
					System.out.println(Thread.currentThread().getName()+" performing operation");
					cl.countDown();
					System.out.println(Thread.currentThread().getName()+" Done operation");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}).start();
		}
		
		System.out.println("Main Thread Waiting");
		cl.await();
		System.out.println("Main Thread Proceeding now");

	}
	
}

//
//CountDownLatch latch = new CountDownLatch(3);
//
////Worker 1
//new Thread(() -> {
// System.out.println("Loading configuration...");
// // Simulate work
// latch.countDown(); // Task done
//}).start();
//
////Worker 2
//new Thread(() -> {
// System.out.println("Connecting to database...");
// // Simulate work
// latch.countDown(); // Task done
//}).start();
//
////Worker 3
//new Thread(() -> {
// System.out.println("Starting services...");
// // Simulate work
// latch.countDown(); // Task done
//}).start();
//
////Main thread waiting
//System.out.println("Main thread waiting for setup...");
//latch.await(); // Wait until all 3 tasks are done
//System.out.println("Setup complete. Main thread proceeds.");

