package Trie;

public class LongestWordWwithAllPrefixes {
	
	static class Node{
		Node[] children;
		boolean eow;
		
		public Node() {
			children=new Node[26];
			eow=false;
		}
	}
	
	static Node root = new Node();
	
	static String ans = "";
	
	public static String lwwap(Node root,StringBuilder sb) {
		for(int i=0;i<26;i++) {
			if(root.children[i]!=null && root.children[i].eow==true) {
				sb.append((char)(i+'a'));
				if(sb.length()>ans.length()) {
					ans=sb.toString();
				}
				lwwap(root.children[i], sb);
				sb.deleteCharAt(sb.length()-1);
			}
		}
		return ans;		
	}
	
	

	public static void main(String[] args) {
		String[] words = {"a","banana","app","appl","ap","apply","apple"};
		for(int i=0;i<words.length;i++) {
			insert(words[i]);
		}
		System.out.println(lwwap(root, new StringBuilder()));
	}

	private static void insert(String word) {
		Node curr = root;
		for(int i=0;i<word.length();i++) {
			int idx = word.charAt(i)-'a';
			if(curr.children[idx]==null) {
				curr.children[idx]=new Node();
			}
			curr=curr.children[idx];
		}
		curr.eow=true;
	}
	
}
