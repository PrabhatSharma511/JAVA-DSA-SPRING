package executorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountdownLatch {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int numberOfServices = 3;
		ExecutorService executor = Executors.newFixedThreadPool(numberOfServices);
		CountDownLatch countDownLatch = new CountDownLatch(numberOfServices);
		
		executor.submit(new DependentService(countDownLatch));
		executor.submit(new DependentService(countDownLatch));
		executor.submit(new DependentService(countDownLatch));
		countDownLatch.await();
		
		
//		Future<String> future1 = executor.submit(new DependentService());
//		Future<String> future2 = executor.submit(new DependentService());
//		Future<String> future3 = executor.submit(new DependentService());
//		
//		future1.get();
//		future2.get();
//		future3.get();
		
		System.out.println("all services finished. Starting main service......");
		executor.shutdown();
	}

}

class DependentService implements Callable<String>{
	
	private final CountDownLatch latch;
	
	public DependentService(CountDownLatch latch) {
		this.latch=latch;
	}

	@Override
	public String call() throws Exception {
		try {
			System.out.println(Thread.currentThread().getName()+" service started");
			Thread.sleep(2000);
		} finally {
			latch.countDown();
		}
		
		return "ok";
	}
	
}
