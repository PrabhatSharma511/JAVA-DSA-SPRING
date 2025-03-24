package executorFramework;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierPractice {
	
	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(3,()->{System.out.println("All threads reached barrier, can proceed furhter now");});
		
		for(int i=0;i<3;i++) {
			new Thread(()->{
				try {
					System.out.println(Thread.currentThread().getName()+" reached barrier and is waiting");
					cb.await();
					System.out.println(Thread.currentThread().getName()+" continued");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}).start();
		}
		
	}

}
