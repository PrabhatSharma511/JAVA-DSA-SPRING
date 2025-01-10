package multithreading;

public class Test {
	
	public static void main(String[] args) {
//		World world = new World();
//		world.start();
		World world = new World();
		Thread t= new Thread(world);
		t.start();
		for(;;) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}
