package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieUsingMap {
	
	static class TrieNode{
		Map<Character,TrieNode> children;
		boolean eow;
		
		public TrieNode() {
			children=new HashMap<>();
			eow=false;
		}
	}
	
	static TrieNode root = new TrieNode();
	
	private static void insert(String word) {
		TrieNode curr = root;
		for(int i=0;i<word.length();i++) {
			Character c = word.charAt(i);
			if(!curr.children.containsKey(c)) {
				curr.children.put(c,new TrieNode());
			}
			curr=curr.children.get(c);
		}
		curr.eow=true;
	}

	private static boolean search(String word) {
		TrieNode curr = root;
		for(int i=0;i<word.length();i++) {
			Character c = word.charAt(i);
			if(!curr.children.containsKey(c)) {
				return false;
			}
			curr=curr.children.get(c);
		}
		return curr.eow;
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
