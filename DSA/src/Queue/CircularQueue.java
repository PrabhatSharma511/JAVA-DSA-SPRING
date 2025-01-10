package Queue;

public class CircularQueue {
	
	int[] queue;
	int size;
	int front=-1,rear=-1;
	
	CircularQueue(int size){
		queue=new int[size];
		this.size=size;
	}
	
	public boolean isEmpty() {
		return front==-1 && rear==-1;
	}
	
	public boolean isFull() {
		return (rear+1)%size==front;
	}
	
	public void add(int data) {
		if(isFull()) {
			System.out.println("full");
			return;
		}
		if(front==-1) {
			front=0;
		}
		rear=(rear+1)%size;
		queue[rear]=data;
	}
	
	public int remove() {
		if(isEmpty()) {
			System.out.println("empty");
			return -1;
		}
		int res = queue[front];
		
		//single element condition
		if(front==rear) {
			front=rear=-1;
		}else {
			front=(front+1)%size;
		}
		
		return res;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("empty");
			return -1;
		}
		return queue[front];
	}
	
	public static void main(String[] args) {
		CircularQueue c = new CircularQueue(5);
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(5);
		System.out.println(c.remove());
		c.add(6);
		System.out.println(c.remove());
		c.add(7);
		
		while(!c.isEmpty()) {
			System.out.println(c.peek());
			c.remove();
		}
	}

}
