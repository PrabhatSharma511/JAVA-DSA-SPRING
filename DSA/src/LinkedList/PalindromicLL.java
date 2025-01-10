package LinkedList;

public class PalindromicLL {

	ListNode head;
	
	class ListNode{
		int data;
		ListNode next;
		
		public ListNode(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	public void addFirst(int data) {
		ListNode node = new ListNode(data);
		if(head==null) {
			head=node;
			return;
		}
		node.next=head;
		head=node;
		 
	}
	
	public void addLast(int data) {
		ListNode node = new ListNode(data);
		if(head==null) {
			head=node;
			return;
		}
		ListNode curr = head;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next=node;
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
	
	public boolean checkPalindrome(ListNode head) {
		if(head==null || head.next==null) {
			return true;
		}
		ListNode middle = middleNode(head);
		ListNode secondPartHead = reverse(middle.next);
		ListNode firstPartHead = head;
		
		while(secondPartHead!=null) {
			if(firstPartHead.data!=secondPartHead.data) {
				return false;
			}
			firstPartHead=firstPartHead.next;
			secondPartHead=secondPartHead.next;
		}
		return true;
		
	}
	
	
	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while(curr!=null) {
			ListNode next = curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}

	private ListNode middleNode(ListNode head2) {
		ListNode ptr1 = head;
		ListNode ptr2 = head;
		while(ptr2.next!=null && ptr2.next.next!=null) {
			ptr1=ptr1.next;
			ptr2=ptr2.next.next;
		}
		return ptr1;
	}
	
	 public boolean hasCycle(ListNode head) {
	        if(head == null || head.next==null){
	            return false;
	        }
	        ListNode fast = head;
	        ListNode slow = head;

	        while(fast!=null && fast.next!=null){
	            slow=slow.next;
	            fast=fast.next.next;
	            if(slow == fast){
	                return true;
	            }
	        }
	        return false;
	    }
	 

	private void removeCycle(ListNode head) {
		if(head==null || head.next==null) {
			return;
		}
		ListNode fast = head;
		ListNode slow = head;
		boolean cycle = false;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow) {
				cycle=true;
				break;
			}
		}
		
		if(cycle) {
			slow=head;
			 // If the cycle is at the head of the list
			if(slow==fast) {
				while(fast.next!=slow) {
					fast=fast.next;
				}
			}else{
				// Move both pointers at the same pace to find the start of the cycle
				while(fast.next!=slow.next) {
					fast=fast.next;
					slow=slow.next;
				}
			}
//			System.out.println(fast.next.data+" "+slow.next.data+"starting point of loop");
			fast.next=null;
		}
		
	}
	//if we start two pointer one from where the slow and fast met and confirmed that a cycle exists and other from head of list
	//then the point at which they meet will always be the starting of loop 
	private void startingOfLoop(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		boolean cycle = false;
		 while(fast!=null && fast.next!=null) {
			 slow=slow.next;
			 fast=fast.next.next;
			 if(slow==fast) {
				 cycle=true;
				 break;
			 }
		 }
		 if(cycle) {
			 slow=head;
			 while(slow!=fast) {
				 slow=slow.next;
				 fast=fast.next;
			 }
			 System.out.println("cycle starts at "+slow.data);
		 }else {
			 System.out.println("no cycle exists");
		 }
		
		 
	}
	
	

	public static void main(String[] args) {
		PalindromicLL list = new PalindromicLL();
		list.addFirst(1);
		list.addLast(2);
		list.addLast(2);
		list.addLast(1);
//		list.printList();
//		
//		System.out.println(list.checkPalindrome(list.head));
//		list.printList();
		
		PalindromicLL list2 = new PalindromicLL();
		list2.addFirst(1);
		list2.addLast(2);
		list2.addLast(3);
		list2.addLast(4);
		list2.head.next.next.next.next=list2.head.next;
//		list2.printList();
		System.out.println(list2.hasCycle(list2.head));
		list2.removeCycle(list2.head);
//		System.out.println(list2.hasCycle(list2.head));
		list2.printList();
		list2.startingOfLoop(list2.head);
		
		
		
		
	}
	
	
}
