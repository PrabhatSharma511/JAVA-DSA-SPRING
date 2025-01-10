package Queue;

public class CircularQueueUsingArray {

	static class CircularQueue{
		static int[] arr;
		static int size;
		static int rear=-1,front=-1;
		
		CircularQueue(int n){
			arr=new int[n];
			this.size=n;
		}
		
		public static boolean isEmpty() {
			return rear==-1 && front==-1;
		}
		
		public static boolean isFull() {
			return (rear+1)%size==front;
		}
		
		//enqueue
		public static void add(int data) {
			if(isFull()) {
				System.out.println("full queue");
				return;
			}
			if(front==-1) {
				front=0;
			}
				rear=(rear+1)%size;
				arr[rear]=data;
			
		}
		
		//dequeue
		public static int remove() {
			if(isEmpty()) {
				System.out.println("empty queue");
				return -1;
			}
			int f=arr[front];
			front=(front+1)%size;
			return f;
		}
		
		public static int peek() {
			if(isEmpty()) {
				System.out.println("empty queue");
				return -1;
			}
			int f=arr[front];
			return f;
		}
	}
	
	public static void main(String[] args) {
		CircularQueue q = new CircularQueue(6);
		q.add(1);
		q.add(2);
		q.add(3);
		
		while(!q.isEmpty()) {
			System.out.println(q.peek());
			q.remove();
		}
	}
	
}
