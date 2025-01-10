package LinkedList;

public class LLReverse{
	private Node head;
	private int size;
	
	LLReverse(){
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
	
	public void reverseIterate() {
		
		if(head==null || head.next==null) {
			return;
		}
		
		Node prev = head;
		Node curr = head.next;
		while(curr!=null) {
			
			Node nextNode = curr.next;
			curr.next=prev;
			
			//update
			prev=curr;
			curr=nextNode;
		}
		head.next=null;
		head=prev;
		
	}
	
	public Node reverseRecursive(Node head) {
		
		if(head==null || head.next==null) {
			return head;
		}
		
		Node newHead = reverseRecursive(head.next);
		
		head.next.next=head;
		head.next=null;
		
		return newHead;
	}
	
	

	public static void main(String[] args) {
		
//		LLReverse list = new LLReverse();
//		list.addFirst("a");
//		list.addFirst("is");
//		
//		list.printList();
//		
//		list.addLast("list");
//		list.printList();
//		
//		
//		list.reverseIterate();
//		list.printList();
		
		LLReverse list2 = new LLReverse();
		list2.addFirst("1");
		list2.addFirst("2");
		list2.addFirst("3");
		list2.printList();
		list2.head = list2.reverseRecursive(list2.head);
		list2.printList();
		

	}

}
