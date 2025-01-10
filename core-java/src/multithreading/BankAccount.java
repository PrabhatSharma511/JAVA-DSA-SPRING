package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

	private int balance = 100;

	Lock lock = new ReentrantLock();

//	public synchronized void withdraw(int amount) {
//		System.out.println(Thread.currentThread().getName()+ " attemtping to withdraw "+ amount);
//		if(balance>=amount) {
//			System.out.println(Thread.currentThread().getName()+ " proceeding with withdrawl");
//			try {
//				Thread.sleep(3000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			balance-=amount;
//			System.out.println(Thread.currentThread().getName()+" completed withdrawl. Remaining balance: "+ balance);
//		}else {
//			System.out.println(Thread.currentThread().getName()+" insufficient balance");
//		}
//	}

	
	
	public void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + " attemtping to withdraw " + amount);
		try {
			if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				if (balance >= amount) {
					try {
						System.out.println(Thread.currentThread().getName() + " proceeding with withdrawl");
						Thread.sleep(3000);
						balance -= amount;
						System.out.println(Thread.currentThread().getName()
								+ " completed withdrawl. Remaining balance: " + balance);
					} catch (Exception e) {
						Thread.currentThread().interrupt();
					} finally {
						lock.unlock();
					}
				} else {
					System.out.println(Thread.currentThread().getName() + " insufficient balance");
				}
			} else {
				System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}

}
