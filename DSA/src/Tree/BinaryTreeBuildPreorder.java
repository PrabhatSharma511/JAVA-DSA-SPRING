package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBuildPreorder {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	static class BinaryTree{
		static int idx = 0;
		public Node buildTree(int nodes[]) {
			if(nodes[idx]==-1 || idx>=nodes.length) {
				idx++;
				return null;
			}
			Node newNode = new Node(nodes[idx]);
			idx++;//move to the next index
			newNode.left=buildTree(nodes);
			newNode.right=buildTree(nodes);
			return newNode;
		}
	}
	
	public static void preorder(Node root) {
		if(root==null) {
			System.out.print(-1+" ");
			return ;
		}
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void inorder(Node root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public static void postorder(Node root) {
		if(root==null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	
	static class BinaryTreee{
		static int idx =0;
		public Node buildTree(int[] arr) {
			if(arr[idx]==-1) {
				idx++;
				return null;
			}
			Node newNode = new Node(arr[idx]);
			idx++;
			newNode.left=buildTree(arr);
			newNode.right=buildTree(arr);
			
			return newNode;
		}
	}
	
	public static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node currNode = q.remove();
			if(currNode==null) {
				System.out.println();
				if(q.isEmpty()) {
					break;
				}else {
					q.add(null);
				}
			}else {
				System.out.print(currNode.data+" ");
				if(currNode.left!=null) {
					q.add(currNode.left);
				}
				if(currNode.right!=null) {
					q.add(currNode.right);
				}
			}
		}
	}
	
	public static void levelOrder2(Node root,int k) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int level=0;
		int levelTotal=0;
		while(!q.isEmpty()) {
			Node curr = q.remove();
			if(curr==null) {
				if(level==k) {
					System.out.print("total "+levelTotal);
				}
				if(q.isEmpty()) {
					break;
				}else {
					System.out.println();
					level++;
					levelTotal=0;
					q.add(null);
				}
			}else {
				System.out.print(curr.data+" ");
				if(level==k) {
					levelTotal=levelTotal+curr.data;
				}
				if(curr.left!=null) {
					q.add(curr.left);
				}
				if(curr.right!=null) {
					q.add(curr.right);
				}
			}	
		}
	}
	

	

	public static void main(String[] args) {
		int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(arr);
//		System.out.println(root.data);
//		preorder(root);
//		inorder(root);
//		postorder(root);
		levelOrder2(root,0);
	}
	
}
