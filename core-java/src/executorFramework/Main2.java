package executorFramework;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main2 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService executor = Executors.newFixedThreadPool(2);
//		Future<Integer> future = executor.submit(()->1+2);
//		Integer i = future.get();
//		System.out.println(i);
//		executor.shutdown();
//		Thread.sleep(1);
//		System.out.println(executor.isTerminated());
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Callable<Integer> callable1 = ()->{Thread.sleep(1);System.out.println("Task 1"); return 1;};
		Callable<Integer> callable2 = ()->{Thread.sleep(1);System.out.println("Task 2"); return 2;};
		Callable<Integer> callable3 = ()->{Thread.sleep(1);System.out.println("Task 3"); return 3;};

		List<Callable<Integer>> list = Arrays.asList(callable1,callable2,callable3);
		
//		List<Future<Integer>> futures = executor.invokeAll(list);
		Integer res = executor.invokeAny(list);
		System.out.println(res+"first");
//		System.out.println(futures.get(0).get());
		executor.shutdown();
	}

}
