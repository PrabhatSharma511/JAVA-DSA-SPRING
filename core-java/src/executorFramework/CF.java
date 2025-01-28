package executorFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CF {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(5000);
				System.out.println("worker");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "ok";
		});
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(5000);
				System.out.println("worker");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "ok";
		});
//		String s = null;
//		try {
//			s = f1.get();
//		} catch (InterruptedException | ExecutionException e) {
//			e.printStackTrace();
//		}
		CompletableFuture<Void> f = CompletableFuture.allOf(f1,f2);
		f.join(); //does not require as it is unchecked
//		f.get(); //requires try catch as it is checked exception
		System.out.println("Main");
		
		CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(5000);
				System.out.println("worker");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 2;
		}).thenApply(x->x+x);
//		System.out.println(f3.get());
		
		Executor executor = Executors.newFixedThreadPool(3);
		CompletableFuture<String> f4 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(4000);
				System.out.println("for exceptioncheck");
			} catch (Exception e2) {
				// TODO: handle exception
			}
			return "ok";
		},executor).orTimeout(1,TimeUnit.SECONDS).exceptionally(s->"Timeout exception occured");
		System.out.println(f4.get());
	}

}
