package multithreading;

class SharedResource{
	public int data;
	public boolean hasData;
	
	public synchronized void produce(int value) {
		while(hasData) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		data=value;
		hasData=true;
		System.out.println("Produced"+value);
		notify();
	}
	
	public synchronized int consume() {
		while(!hasData) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		hasData=false;
		System.out.println("Consumed"+data);
		notify();
		return data;
	}
}

class Producer implements Runnable{
	private SharedResource sharedResource;
	
	public Producer(SharedResource sharedResource) {
		this.sharedResource=sharedResource;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			sharedResource.produce(i);
		}
	}
}

class Consumer implements Runnable{
private SharedResource sharedResource;
	
	public Consumer(SharedResource sharedResource) {
		this.sharedResource=sharedResource;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			int value = sharedResource.consume();
		}
	}
	
}

public class ThreadCommunication {
	
	public static void main(String[] args) {
		SharedResource res = new SharedResource();
		Thread producerThread = new Thread(new Producer(res));
		Thread consumerThread = new Thread(new Consumer(res));
		producerThread.start();
		consumerThread.start();
	}

}
