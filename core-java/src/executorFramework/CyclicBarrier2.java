package executorFramework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier2 {
	
	public static void main(String[] args) {
		int numberOfServices = 4;
		CyclicBarrier barrier = new CyclicBarrier(numberOfServices,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("All subsystems are up and running. system startup complete");
			}
		});
		Thread t1 = new Thread(new SubSystem("ws", 2000, barrier));
		Thread t2 = new Thread(new SubSystem("DB", 3000, barrier));
		Thread t3 = new Thread(new SubSystem("cache", 5000, barrier));
		Thread t4 = new Thread(new SubSystem("Messaging service", 4000, barrier));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}

class SubSystem implements Runnable{
	
	private String name;
	private int initializationTime;
	private CyclicBarrier barrier;
	
	

	public SubSystem(String name, int initializationTime, CyclicBarrier barrier) {
		super();
		this.name = name;
		this.initializationTime = initializationTime;
		this.barrier = barrier;
	}



	@Override
	public void run() {
		try {
			System.out.println(name+" initialization started");
			Thread.sleep(initializationTime);
			System.out.println(name+" initialization completed");
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
