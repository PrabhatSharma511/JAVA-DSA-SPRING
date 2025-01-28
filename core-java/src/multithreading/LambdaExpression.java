package multithreading;

public class LambdaExpression {

	public static void main(String[] args) {
		
		Runnable runnable = ()->System.out.println(Thread.currentThread().getName()); //implementing run method through lambda expression
		Thread t1 = new Thread(runnable,"newThread");
		t1.start();
	}
	
}
