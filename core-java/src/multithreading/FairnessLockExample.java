package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {
	
	private final Lock lock = new ReentrantLock(true);
	
	public  void accessResource() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+" acquired the lock");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}finally {
			System.out.println(Thread.currentThread().getName()+" released the lock");
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		FairnessLockExample ex = new FairnessLockExample();
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				ex.accessResource();
			}
		};
		
		Thread t1 = new Thread(task,"Thread 1");
		Thread t2 = new Thread(task,"Thread 2");
		Thread t3 = new Thread(task,"Thread 3");
		t1.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
	}

}
