package multithreading;

public class MyThreadMethods extends Thread{
	
//	public MyThreadMethods(String name) {
//		super(name);
//	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Hello");
		}
	}
	
//	@Override
//	public void run() {
//		for(int i=0;i<5;i++) {
//			System.out.println(Thread.currentThread().getName()+" is running.");
//			Thread.yield();
//		}
//	}
	
//	@Override
//	public void run() {
//		try {
//			Thread.sleep(1000);
//			System.out.println("Thread is running....");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
//	@Override
//	public void run() {
//		for(int i=1;i<=5;i++) {
//			String a="";
//			for(int j=0;j<100000;j++) {
//				a=a+" ";
//			}
//			System.out.println(Thread.currentThread().getName()+"- Priority: "+Thread.currentThread().getPriority()+" - count "+i);
//			try {
//				Thread.sleep(100);
//			} catch (Exception e) {
//			}
//		}
//	}

//	@Override
//	public void run() {
////		System.out.println("Thread is running");
//		for(int i=1;i<=5;i++) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(i);
//		}
//	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
//		MyThreadMethods l = new MyThreadMethods("low");
//		MyThreadMethods m = new MyThreadMethods("medium");
//		MyThreadMethods h = new MyThreadMethods("high");
//		l.setPriority(MIN_PRIORITY);
//		m.setPriority(NORM_PRIORITY);
//		h.setPriority(MAX_PRIORITY);
//		l.start();
//		m.start();
//		h.start();
		
//		MyThreadMethods t1 = new MyThreadMethods("New Name");
//		t1.start();
//		t1.interrupt();
		
//		MyThreadMethods t1 = new MyThreadMethods();
//		MyThreadMethods t2 = new MyThreadMethods();
//		t1.start();
//		t2.start();
		
		MyThreadMethods t = new MyThreadMethods();
		t.setDaemon(true);
		t.start();
		System.out.println("Main done");
		
		
//		t1.join();//waits for t1 to complete its execution
//		System.out.println("Hello");
		
		
	}
	
}
