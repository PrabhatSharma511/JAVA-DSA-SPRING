package Trie;

public class TrieUsingArray {
	
	static class Node{
		Node[] children;
		boolean eow;
		
		public Node() {
			children=new Node[26];//a-z
//			for(int i=0;i<26;i++) {
//				children[i]=null;
//			}
			eow=false;
		}
	}
	
	static Node root = new Node();
	
	private static void insert(String word) { //O(l) l is length of word
		Node curr = root;
		for(int i=0;i<word.length();i++) {
			int idx = word.charAt(i)-'a';
			if(curr.children[idx]==null) {
				curr.children[idx]=new Node();
			}
			if(i==word.length()-1) {
				curr.eow=true;
			}
			curr=curr.children[idx];
		}
	}
	
	private static boolean search(String word) { //O(l) l is length of word
		Node curr = root;
		for(int i=0;i<word.length();i++) {
			int idx = word.charAt(i)-'a';
			if(curr.children[idx]==null) {
				return false;
			}
			if(i==word.length()-1 && curr.eow==false) {
				return false;
			}
			curr=curr.children[idx];
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"the","a","there","their","any"};
		for(int i=0;i<words.length;i++) {
			insert(words[i]);
		}
		
		System.out.println(search("their"));
		System.out.println(search("thor"));
		System.out.println(search("an"));

	}

}
