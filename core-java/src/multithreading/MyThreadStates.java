package multithreading;

public class MyThreadStates extends Thread{
	
	@Override
	public void run() {
		try {
			System.out.println("RUNNING");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThreadStates t = new MyThreadStates();
		System.out.println(t.getState());
		t.start();
		System.out.println(t.getState());
		Thread.sleep(200);
//		System.out.println(Thread.currentThread().getState());
		System.out.println(t.getState());
		t.join();
		System.out.println(t.getState());
	}

}
