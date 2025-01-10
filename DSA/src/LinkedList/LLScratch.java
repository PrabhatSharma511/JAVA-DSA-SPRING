package LinkedList;

public class LLScratch {
	private Node head;
	private int size;
	
	LLScratch(){
		this.size=0;
	}
	
	class Node{
		String data;
		Node next;
		
		public Node(String data) {
			this.data=data;
			this.next=null;
			size++;
		}
	}
	
	public void addFirst(String data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		newNode.next=head;
		head = newNode;
	}
	
	public void addLast(String data) {
		
		Node newNode = new Node(data);
		  if(head == null) {
	           head = newNode;
	           return;
	       }

		Node currentNode = head;
		while(currentNode.next!=null) {
			currentNode=currentNode.next;
		}
		currentNode.next=newNode;
	}
	
	public void printList() {
		Node currentNode = head;
		if(head ==null) {
			System.out.print("list is empty");
		}
		while(currentNode!=null) {
			System.out.print(currentNode.data+" -> ");
			currentNode=currentNode.next;
		}
		System.out.println("NULL");
	}
	
	public void deleteFirst() {
		
		if(head == null) {
			System.out.println("already empty");
			return;
		}
		size--;
		head = head.next;
	}
	
	public void deleteLast() {
		
		if(head == null) {
			System.out.println("already empty");
			return;
		}
		size--;
		if(head.next==null) {
			head=null;
			return;
		}
		Node secondLast = head;
		Node last = head.next;
		while(last.next!=null) {
			last=last.next;
			secondLast=secondLast.next;
		}
		secondLast.next=null;
		
	}
	
	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		
		LLScratch list = new LLScratch();
		list.addFirst("a");
		list.addFirst("is");
		
		list.printList();
		
		list.addLast("list");
		list.printList();
		
		list.addFirst("this");
		list.printList();
		
		list.deleteFirst();
		list.printList();
		
		list.deleteLast();
		list.printList();
		
		System.out.println(list.getSize());
		
//		LL list2 = new LL();
//		System.out.println(list2.getSize());
		

	}

}
