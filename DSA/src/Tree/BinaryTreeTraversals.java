package Tree;

import java.util.LinkedList;
import java.util.Queue;

import Tree.BinaryTreeBuildPreorder.Node;

public class BinaryTreeTraversals {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	static class BinaryTree{
		int idx = 0;
		public  Node buildTree(int nodes[]) {
			if(nodes[idx]==-1 ) {
				idx++;
				return null;
			}
			Node root = new Node(nodes[idx]);
			idx++;
			root.left = buildTree(nodes);
			root.right = buildTree(nodes);
			
			return root;
			
		}
	}
	
	public static void preorderTraversal(Node root) {
		if(root==null) {
			System.out.print(-1+" ");
			return;
		}
		System.out.print(root.data+" ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
	
	public static void inorderTraversal(Node root) {
		if(root==null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.data+" ");
		inorderTraversal(root.right);
	}
	
	public static void postorderTraversal(Node root) {
		if(root==null) {
			return;
		}
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.data+" ");
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; //preorder
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(arr);
//		System.out.println(root.data);
//		levelOrder(root);
		System.out.print(diameter2(root).diameter);
//		countNodes(root);
	}
	
	public static int diameter(Node root) {
		if(root==null) {
			return 0;
		}
		
		int diam1 = diameter(root.left);
		int diam2 = diameter(root.right);
		int diam3 = heightOfTree(root.left)+heightOfTree(root.right)+1;
		
		return Math.max(diam3, Math.max(diam1, diam2));
	}
	
	static class TreeInfo{
		int height;
		int diameter;
		
		public TreeInfo(int height,int diameter) {
			this.height=height;
			this.diameter=diameter;
		}
	}
	
	public static TreeInfo diameter2(Node root) {
		if(root==null) {
			return new TreeInfo(0, 0);
		}
		
		TreeInfo left = diameter2(root.left);
		TreeInfo right = diameter2(root.right);
		
		int myHeight = Math.max(left.height,right.height)+1;
		
		int diam1 = left.diameter;
		int diam2 = right.diameter;
		int diam3 = left.height+right.height+1;
		
		int myDiameter = Math.max(Math.max(diam1, diam2), diam3);
		
		return new TreeInfo(myHeight, myDiameter);
	}
	
	public static int sumOfNodes(Node root) {
		if(root == null) {
			return 0;
		}
		int leftSum = sumOfNodes(root.left);
		int rightSum = sumOfNodes(root.right);
		
		return leftSum+rightSum+root.data;
	}
	
	public static int countNodes(Node root) {
		if(root ==null) {
			return 0;
		}
		int left = countNodes(root.left);
		int right = countNodes(root.right);
		
		return left+right+1;	
	}
	
	public static int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftSubtreeHeight = heightOfTree(root.left);
		int rightSubtreeHeight = heightOfTree(root.right);
		
		return Math.max(leftSubtreeHeight, rightSubtreeHeight)+1;
	}
	
	public static void levelOrder(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node curr = q.remove();
			if(curr==null) {
				if(q.isEmpty()) {
					break;
				}else {
					System.out.println();
					q.add(null);
				}
			}else {
				System.out.print(curr.data+" ");
				if(curr.left!=null) {
					q.add(curr.left);
				}
				if(curr.right!=null) {
					q.add(curr.right);
				}
			}
		}
	}

}
