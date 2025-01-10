package LinkedList;

import LinkedList.LLScratch.Node;

public class RemoveNthNodeFromeEnd {
	Node head;
	int size;
	
	RemoveNthNodeFromeEnd(){
		this.size=0;
	}
	
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data=data;
			this.next=null;
			size++;
		}
		
	}
	
	
	public void addFirst(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head=newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
	}
	
	public void addLast(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head=newNode;
			return;
		}
		Node curr = head;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next=newNode;
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
	
	public int getSize(Node head) {
		int size = 0;
		Node curr = head;
		while(curr!=null) {
			size++;
			curr=curr.next;
		}
		return size;
	}
	
	public Node removeNth(Node head,int n) {
		
		if(n==0) {
			return head;
		}
		
		if(head==null || head.next==null) {
			return null;
		}
		
		int size = 0;
		Node currNode = head;
		while(currNode!=null) {
			size++;
			currNode=currNode.next;
		}
		
		if(size==n) {
			return head.next;
		}
		
		
		
		Node prev = null;
		Node curr = head;
		
		for(int i=1;i<size-n+1;i++) {
			prev=curr;
			curr=curr.next;
		}
//		if(prev == null) {
//			head=head.next;
//			return head;
//		}
		prev.next=curr.next;
		curr.next=null;//not required
		return head;
	}
	
	public static void main(String[] args) {
		RemoveNthNodeFromeEnd list = new RemoveNthNodeFromeEnd();
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		
//		list.printList();
		list.head=list.removeNth(list.head, 5);
//		System.out.println(list.removeNth(list.head, 5));
		list.printList();
		
	}
	
	

}
