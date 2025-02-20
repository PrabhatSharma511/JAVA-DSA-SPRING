package Trie;

import java.util.HashMap;

public class StartsWithProblem {
	
	static class Node{
		HashMap<Character,Node> children;
		boolean eow;
		
		public Node() {
			children=new HashMap<>();
			eow=false;
		}
	}
	
	public static Node root = new Node();
	
	private static void insert(String word) {
		Node curr = root;
		for(int i=0;i<word.length();i++) {
			Character c = word.charAt(i);
			if(!curr.children.containsKey(c)) {
				curr.children.put(c,new Node());
			}
			curr=curr.children.get(c);
		}
		curr.eow=true;
	}
	
	private static boolean startsWith(String prefix) {
		Node curr = root;
		for(int i =0;i<prefix.length();i++) {
			Character c = prefix.charAt(i);
			if(!curr.children.containsKey(c)) {
				return false;
			}
			curr=curr.children.get(c);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"apple","app","mango","man","woman"};
		for(int i=0;i<words.length;i++) {
			insert(words[i]);
		}
		System.out.println(startsWith("app"));
	}

}
