package Tree;

public class SubtreeOfAnotherTree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data=data;
		}
	}
	
	static class BinaryTree{
		int idx = 0;
		public Node buildTree(int[] nodes) {
			if(idx>=nodes.length || nodes[idx]==-1) {
				idx++;
				return null;
			}
			Node newNode = new Node(nodes[idx]);
			idx++;
			newNode.left=buildTree(nodes);
			newNode.right=buildTree(nodes);
			
			return newNode;
		}
	}
	
	public static void main(String[] args) {
//		int[] values = {3,4,5,1,2};
		int[] values = {3, 4, 1, -1, -1, 2, -1, -1, 5, -1, -1};
		int[] subtreeValues = {4,1,-1,-1,2,-1,-1};
		BinaryTree tree = new BinaryTree();
		BinaryTree subTree = new BinaryTree();
		Node treeRoot = tree.buildTree(values);
		Node subtreeRoot = subTree.buildTree(subtreeValues);
		System.out.print(isSubtree(treeRoot, subtreeRoot));
	}
	
	public static boolean isSubtree(Node root,Node subRoot) {
		if(root==null) {
			return false;
		}
		if(subRoot==null) {
			return true;
		}
		
		if(root.data==subRoot.data) {
			return isIdentical(root,subRoot);
		}
		
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	private static boolean isIdentical(Node root, Node subRoot) {
		if(root==null && subRoot==null) {
			return true;
		}
		if(root==null || subRoot==null) {
			return false;
		}
		if(root.data==subRoot.data) {
			return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
		}
		return false;
	}

}