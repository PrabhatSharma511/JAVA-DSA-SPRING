package executorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureExample {

	public static void main(String[]args) throws InterruptedException, ExecutionException {
//		ExecutorService executor = Executors.newSingleThreadExecutor();
//		Callable<String> callable = ()->"Hello";
//		Future<?> future = executor.submit(callable);
//		System.out.print(future.get());
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> future = executor.submit(()->{
			Thread.sleep(2000);
			System.out.println("Hello for cancel task");
			return 42;
		});
		Thread.sleep(1000);
		future.cancel(false); //false ensures that it will not cancel task if it is running and true tells to cancel all time
		System.out.println(future.isCancelled());
		System.out.println(future.isDone());
		
		try {
			System.out.println(future.get(1,TimeUnit.SECONDS));
			System.out.println(future.isDone());
		} catch (InterruptedException | ExecutionException | TimeoutException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
