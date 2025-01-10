package LinkedList;

import LinkedList.LLReverse.Node;

public class LLQ2subREV {
	private ListNode head;
	
	class ListNode{
		private int data;
		private ListNode next;
		
		ListNode(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	public void addFirst(int data) {
		ListNode newNode = new ListNode(data);
		if(head==null) {
			head=newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
	}
	
	public void addLast(int data) {
		ListNode newNode = new ListNode(data);
		if(head==null) {
			head=newNode;
			return;
		}
		ListNode curr = head;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next=newNode;
	}
	
	public void printList() {
		ListNode currentNode = head;
		if(head ==null) {
			System.out.print("list is empty");
		}
		while(currentNode!=null) {
			System.out.print(currentNode.data+" -> ");
			currentNode=currentNode.next;
		}
		System.out.println("NULL");
	}
	
	public ListNode sublistReverse(ListNode head,int left,int right) {
		if(head == null|| head.next == null || left==right) {
			return head;
		}
		ListNode prev = null;
		ListNode curr = head;
		
		for(int i=1;i<left;i++) {
			prev=curr;
			curr=curr.next;
		}
		ListNode pts=prev;
		ListNode start = curr;
		prev=null;
		for(int i=0;i<right-left+1;i++) {
			ListNode next = curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		
		start.next=curr;
		if(pts!=null) {
			pts.next=prev;
		}else {
			return prev;
		}
		
		return head;
		
	}
	
	public static void main(String[] args) {
		LLQ2subREV list = new LLQ2subREV();
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.printList();
		
		list.head=list.sublistReverse(list.head, 2, 5);
		list.printList();
		
	}
	
	

}
