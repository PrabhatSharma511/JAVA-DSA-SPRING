package Tree;

import java.util.ArrayList;

public class BSTRevision {
	
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
	
	public static Node insert(Node root,int key) {
		if(root==null) {
			root = new Node(key);
			return root;
		}
		if(root.data>key) {
			root.left=insert(root.left, key);
		}
		if(root.data<key) {
			root.right=insert(root.right, key);
		}
		return root;
	}
	
	public static void inorderTraversal(Node root) {
		if(root==null) {
			return ;
		}
		inorderTraversal(root.left);
		System.out.print(root.data+" ");
		inorderTraversal(root.right);
	}
	
	public static boolean search(Node root,int key) {
		if(root == null) {
			return false;
		}
		if(root.data==key) {
			return true;
		}
		if(root.data>=key) {
			return search(root.left,key);
		}
		if(root.data<key) {
			return search(root.right,key);
		}
		
		return false;
	}
	
	public static Node delete(Node root,int key) {
		if(root.data>key) {
			root.left=delete(root.left, key);
		}
		if(root.data<key) {
			root.right=delete(root.right, key);
		}
		if(root.data==key) {
			//case1 no child
			if(root.left==null && root.right==null) {
				return null;
			}
			//case2 one child
			if(root.left==null) {
				return root.right;
			}else if(root.right==null){
				return root.left;
			}
			
			//case3 both child
			Node is = inorderSuccessor(root.right);
			root.data=is.data;
			delete(root.right, is.data);
		}
		return root;
	}
	
	private static Node inorderSuccessor(Node root) {
		while(root.left!=null) {
			root=root.left;
		}
		return root;
	}
	
	public static void printInRnage(Node root,int x,int y) {
		if(root == null) {
			return;
		}
		if(root.data>=x&&root.data<=y) {
			printInRnage(root.left, x, y);
			System.out.print(root.data+" ");
			printInRnage(root.right, x, y);
		}
		if(root.data<x) {
			printInRnage(root.right, x, y);
		}
		if(root.data>y) {
			printInRnage(root.left, x, y);
		}
	}
	
	public static void printPaths(Node root,ArrayList<Integer> paths) {
		if(root==null) {
			return;
		}
		paths.add(root.data);
		if(root.left==null && root.right==null) {
			printPath(paths);
		}else {
			printPaths(root.left, paths);
			printPaths(root.right, paths);
		}
		paths.remove(paths.size()-1);
	}

	private static void printPath(ArrayList<Integer> paths) {
		for(int i=0;i<paths.size();i++) {
			System.out.print(paths.get(i)+" ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		int[] nodes = {5,1,3,4,2,7};
		Node root = null;
		for(int i=0;i<nodes.length;i++) {
			root = insert(root, nodes[i]);
		}
		System.out.println(root.data);
		inorderTraversal(root);
		System.out.println(search(root, 1));
//		printInRnage(root, 2, 7);
		printPaths(root, new ArrayList<>());
	}

}
