package Trie;

public class WordBreakProblem {
	
	static class Node{
		Node[] children;
		boolean eow;
		
		public Node() {
			children=new Node[26];
			eow=false;
		}
	}
	
	static Node root = new Node();
	
	private static void insert(String word) {
		Node curr = root;
		for(int i=0;i<word.length();i++) {
			int idx = word.charAt(i)-'a';
			if(curr.children[idx]==null) {
				curr.children[idx]=new Node();
			}
			if(i==word.length()-1) {
				curr.children[idx].eow=true;
			}
			curr=curr.children[idx];
		}
	}
	
	private static boolean search(String word) {
		Node curr = root;
		for(int i=0;i<word.length();i++) {
			int idx=word.charAt(i)-'a';
			if(curr.children[idx]==null) {
				return false;
			}
			if(i==word.length()-1&&curr.children[idx].eow==false) {
				return false;
			}
			curr=curr.children[idx];
		}
		return true;
	}
	
	private static boolean wbp(String key) {
		if(key.length()==0) {
			return true;
		}
		for(int i=1;i<=key.length();i++) {
			String fp = key.substring(0, i);
			String sp = key.substring(i);
			if(search(fp) && wbp(sp)) {
				return true;
			}
		}
		return false;
	}
	

	public static void main(String[] args) {
		String[] words = {"i","like","sam","samsung","mobile","ice"};
		for(int i=0;i<words.length;i++) {
			insert(words[i]);
		}
		System.out.println(search("i"));
		System.out.println(search("likee"));
		System.out.println(search("samsung"));
		System.out.println(search("sams"));

		System.out.println(wbp("ilikesamsung"));

	}
	
}
