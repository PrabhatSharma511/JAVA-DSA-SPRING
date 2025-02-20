package Trie;

import java.util.ArrayList;
import java.util.List;

public class CountUniqueSubstringUsingTrie {
	
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
				curr.children[idx]= new Node();
			}
			if(i==word.length()-1) {
				curr.eow=true;
			}
			curr=curr.children[idx];
		}
	}
	
	private static int numberOfNodes(Node root) {
		if(root==null) {
			return 0;
		}
		int count = 0;
		for(int i=0;i<26;i++) {
			if(root.children[i]!=null) {
				count=count+numberOfNodes(root.children[i]);
			}
		}
		return count+1;
	}

	public static void main(String[] args) {
		String str = "ababa";
		List<String> allSuffix = allUniqueSuffix(str);
		for(String s:allSuffix) {
			insert(s);
		}
		System.out.println(numberOfNodes(root));
	}

	private static List<String> allUniqueSuffix(String str) {
		List<String> list = new ArrayList<>();
		for(int i=0;i<str.length();i++) {
			list.add(str.substring(i));
		}
		return list;
	}
	
}
