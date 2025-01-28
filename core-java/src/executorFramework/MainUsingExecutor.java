package executorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainUsingExecutor {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(9);
		for(int i=1;i<10;i++) {
			int finalI = i;
			executor.submit(()->{
				System.out.println(factorial(finalI));	
			});
		}
		executor.shutdown();
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("Time taken "+ (System.currentTimeMillis()-startTime));
	}
	
	public static int factorial(int n) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		int fact = 1;
		for(int i=1;i<=n;i++) {
			fact=fact*i;
		}
		return fact;
	}

}
