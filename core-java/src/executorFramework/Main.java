package executorFramework;

public class Main {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Thread[] threads = new Thread[10];
		for(int i=1;i<=10;i++) {
			int  finalI = i;
			threads[i-1] = new Thread(
					()->{
				long result = factorial(finalI);
				System.out.println(result);	
			}
		);
			threads[i-1].start();
		}
		for(Thread thread:threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("Time taken "+ (System.currentTimeMillis()-startTime));
	}

	private static long factorial(int n) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long result = 1;
		for(int i=1;i<=n;i++) {
			result = result*i;
		}
		return result;
	}

}
