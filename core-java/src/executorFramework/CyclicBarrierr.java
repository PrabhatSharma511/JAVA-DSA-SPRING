package executorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierr {
	
	public static void main(String[] args) {
		int numberOfServices = 3;
		ExecutorService executor = Executors.newFixedThreadPool(numberOfServices);
		CyclicBarrier barrier = new CyclicBarrier(numberOfServices);
		
		executor.submit(new DependenttService(barrier));
		executor.submit(new DependenttService(barrier));
		executor.submit(new DependenttService(barrier));
		
		System.out.println("Main");
		executor.shutdown();
	}

}

class DependenttService implements Callable<String>{
	
	private final CyclicBarrier barrier;
	
	public DependenttService(CyclicBarrier barrier) {
		this.barrier=barrier;
	}

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" service started");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+" is waiting at the barrier");
			barrier.await();
			return "ok";
	}
	
}
