package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeRevision {

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
		int idx = 0;
		public Node buildTree(int[] values) {
			if(values[idx]==-1 || idx>values.length) {
				idx++;
				return null;
			}
			Node newNode = new Node(values[idx]);
			idx++;
			newNode.left=buildTree(values);
			newNode.right=buildTree(values);
			
			return newNode;
		}
	}
	
	public static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node node = q.remove();
			if(node==null) {
				if(q.isEmpty()) {
					break;
				}else {
					System.out.println();
					q.add(null);
				}
			}
			else {
				System.out.print(node.data+" ");
				if(node.left!=null) {
					q.add(node.left);
				}
				if(node.right!=null) {
					q.add(node.right);
				}
			}
		}
	
	}
	
	public static int sumAtKlevel(Node root,int k) {
		Queue<Node> q = new LinkedList<>();
		int level = 1;
		int levelTotal=0;
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node node =  q.remove();
			if(node==null) {
				if(q.isEmpty()) {
					break;
				}else {
					level++;
//					System.out.println();
					q.add(null);
				}
			}else {
				if(level==k) {
					levelTotal=levelTotal+node.data;
				}
				if(node.left!=null) {
					q.add(node.left);
				}
				if(node.right!=null) {
					q.add(node.right);
				}
			}
		}
		
		return levelTotal;
	}
	
	public static int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	public static int diameter(Node root) {
		if(root==null) {
			return 0;
		}
		int diameter1 = diameter(root.left);  //diameter of left subtree
		int diameter2 = diameter(root.right); //diameter of right subtree
		int diameter3 = heightOfTree(root.left)+heightOfTree(root.right)+1;  //height of tree
		
		return Math.max(Math.max(diameter1, diameter2), diameter3);
		
	}
	
	static class TreeInfo{
		int diameter;
		int height;
		
		public TreeInfo(int diameter,int height) {
			this.diameter=diameter;
			this.height=height;
		}
	}
	
	public static TreeInfo diameter2(Node root) {
		if(root==null) {
			return new TreeInfo(0, 0);
		}
		
		TreeInfo left = diameter2(root.left);
		TreeInfo right = diameter2(root.right);
		
		int myHeight = Math.max(left.height,right.height) +1;
		
		int diam1 = left.diameter;
		int diam2 = right.diameter;
		int diam3 = left.height+right.height+1;
		
		int diam = Math.max(diam3, Math.max(diam1, diam2));
		
		return new TreeInfo(diam, myHeight);
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
		Node root =tree.buildTree(arr);
//		System.out.println(root.data);
//		levelOrder(root);
		System.out.print(diameter2(root).diameter);
	}
	
}
