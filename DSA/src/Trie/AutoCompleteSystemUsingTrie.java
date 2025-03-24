package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutoCompleteSystemUsingTrie {
	
	static class TrieNode{
		Map<Character,TrieNode> children;
		Map<String,Integer> sentences;
		
		public TrieNode() {
			this.children=new HashMap<>();
			this.sentences=new HashMap<>();
		}
	}
	
	TrieNode root;
	StringBuilder currentInput;
	TrieNode currentNode;
	
	public AutoCompleteSystemUsingTrie(String[] sentences,int[] times) {
		root=new TrieNode();
		currentInput=new StringBuilder();
		currentNode=root;
		for(int i=0;i<sentences.length;i++) {
			addSentence(sentences[i],times[i]);
		}
	}

	private void addSentence(String sentence, int count) {
		TrieNode node = root;
		for(char c: sentence.toCharArray()) {
			node.children.putIfAbsent(c,new TrieNode());
			node=node.children.get(c);
			node.sentences.put(sentence, node.sentences.getOrDefault(sentence,0)+count);
		}
	}
	
	private List<String> input(char c){
		if(c=='#') {
			addSentence(currentInput.toString(), 1);
			String enteredOnSearchBarAndNotPresent = currentInput.toString(); 
			currentInput.setLength(0);
			currentNode=root;
			return List.of(enteredOnSearchBarAndNotPresent);
//			return new ArrayList<>();
		}else {
			List<String> res = new ArrayList<>(); 
			if(!currentNode.children.containsKey(c)) {
				currentNode=root;
				return List.of(currentInput.toString());
//				return new ArrayList<>();
			}
			currentInput.append(c);
			currentNode=currentNode.children.get(c);
			PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<>((a,b)->a.getValue()==b.getValue()?a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue());
			heap.addAll(currentNode.sentences.entrySet());
			for(int i=0;i<3&&!heap.isEmpty();i++) {
				res.add(heap.poll().getKey());
			}
			return res;
		}
	}


	public static void main(String[] args) {
		String[] sentences = {"i love you","island","ironman","i love leetcode"};
		int[] times = {5,3,2,2};
		AutoCompleteSystemUsingTrie a = new AutoCompleteSystemUsingTrie(sentences,times);
		System.out.println("output: "+a.input('i'));
		System.out.println("output: "+a.input(' '));
		System.out.println("output: "+a.input('a'));
		System.out.println("output: "+a.input('m'));
		System.out.println("output: "+a.input('#'));
//		System.out.println("map: "+a.root.children.get('i').sentences);
	}
	
}
