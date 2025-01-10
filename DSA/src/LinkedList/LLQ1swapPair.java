package LinkedList;

public class LLQ1swapPair {

	ListNode head;
	
	class ListNode{
		int data;
		ListNode next;
		public ListNode(int data) {
			this.next=null;
			this.data = data;
		}
	}
	
	public void addFirst(int data) {
		ListNode newNode = new ListNode(data);
		
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
	}
	
	public void addLast(int data) {
		ListNode newNode = new ListNode(data);
		
		if(head == null) {
			head = newNode;
			return;
		}
		ListNode currNode = head;
		while(currNode.next!=null) {
			currNode=currNode.next;
		}
		currNode.next=newNode;
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
	
	public ListNode swapPair(ListNode head) {
		
		if(head==null || head.next==null) {
			return  head;
		}
		ListNode prev =null;
		ListNode curr = head;
		ListNode newHead = head.next;
		while(curr!=null && curr.next!=null) {
			ListNode First = curr;
			ListNode second = curr.next;
			
			//swap
			First.next=second.next;
			second.next=First;
			
			if(prev!=null) {
				prev.next=second;
			}
			
			prev=First;
			curr=First.next;
			
		}
		return newHead;
		
	}
	
	public void reverse() {
		if(head==null || head.next==null) {
			return;
		}
		ListNode prev = head;
		ListNode curr =head.next;
		
		while(curr!=null) {
			ListNode nextNoe = curr.next;
			curr.next=prev;
			
			prev = curr;
			curr=nextNoe;
		}
		head.next=null;
		head=prev;
	}
	
	
	public static void main(String[] args) {
		LLQ1swapPair list = new LLQ1swapPair();
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		
		list.printList();
//		list.reverse();
//		list.printList();
		list.head =list.swapPair(list.head);
		list.printList();
		
		
		
	}
	
}
