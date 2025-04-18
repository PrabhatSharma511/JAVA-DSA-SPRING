package Tree;

import java.util.ArrayList;

public class BST {

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
	
	public static Node insert(Node root,int val) {
		if(root==null) {
			root = new Node(val);
			return root;
		}
		if(root.data>val) {
			root.left=insert(root.left, val);
		}
		else {
			root.right=insert(root.right, val);
		}
		return root;
	}
	
	public static void inorder(Node root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public static boolean search(Node root,int key) {
		if(root==null) {
			return false;
		}
		if(root.data==key) {
			return true;
		}
		if(key>root.data) {
			return search(root.right, key);
		}
		if(key<root.data) {
			return search(root.left, key);
		}
		return false;
	}
	
//	public static Node delete(Node root,int key) {
//		if(root.data>key) {
//			root.left=delete(root.left, key);
//		}
//		if(root.data<key) {
//			root.right=delete(root.right, key);
//		}
//		if(root.data==key) {
//			//case1
//			if(root.left==null&&root.right==null) {
//				return null;
//			}
//			//case2
//			if(root.right==null) {
//				return root.left;
//			}else if(root.left==null) {
//				return root.right;
//			}
//			
//			Node is = inorderSuccessor(root.right);
//			root.data=is.data;
//			delete(root.right,is.data);
//		}
//		return root;
//	}
//	
	private static Node inorderSuccessor(Node root) {
		while(root.left!=null) {
			root=root.left;
		}
		return root;
	}
	
	public static Node delete(Node root,int key) {
		if(root.data>key) {
			root.left=delete(root.left, key);
		}
		if(root.data<key) {
			root.right=delete(root.right, key);
		}
		if(root.data==key) {
			//case1-leaf node
			if(root.left==null&&root.right==null) {
				return null;
			}
			//case2-one child
			if(root.left==null) {
				return root.right;
			}
			if(root.right==null) {
				return root.left;
			}
			//case3-both child
			Node is = inorderSuccessor(root.right);
			root.data=is.data;
			delete(root.right, is.data);
		}
		return root;
	}
	
	
	public static void printInRnage(Node root,int x, int y) {
		if(root==null) {
			return;
		}
		if(root.data>=x&&root.data<=y) {
			printInRnage(root.left, x, y);
			System.out.print(root.data+" ");
			printInRnage(root.right, x, y);
		}
		if(x>root.data) {
			printInRnage(root.right, x, y);
		}
		if(y<root.data) {
			printInRnage(root.left, x, y);
		}
	}
	
	public static void printPaths(Node root,ArrayList<Integer> paths) {
		if(root==null) {
			return;
		}
		paths.add(root.data);
		if(root.left==null&&root.right==null) {
			printPath(paths);
			System.out.println();
		}else {
			printPaths(root.left, paths);
			printPaths(root.right, paths);
		}
		paths.remove(paths.size()-1);

	}
	
	

	private static void printPath(ArrayList<Integer> paths) {
		for(int i=0;i<paths.size();i++) {
			System.out.print(paths.get(i)+"->");
		}
	}

	public static void main(String args[]) {
//		int[] values = {5,1,3,4,2,7};
//		int[] values = {8,5,3,1,4,6,10,11,14};
		int[] values = {8,5,3,6,10,11,14};
		Node root = null;
		for(int i=0;i<values.length;i++) {
			root=insert(root, values[i]);
		}
//		System.out.println(root.data);
//		System.out.println(search(root, 1));
//		inorder(root);
//		delete(root, 7);
//		inorder(root);
//		printInRnage(root, 6, 10);
		printPaths(root,new ArrayList<>());
	}
	
}
