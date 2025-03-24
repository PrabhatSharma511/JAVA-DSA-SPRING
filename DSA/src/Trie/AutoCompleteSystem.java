package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutoCompleteSystem {
	
	static class Node{
		String sentence;
		int times;
		
		public Node(String sentence,int times) {
			this.sentence=sentence;
			this.times=times;
		}
	}
	
	Map<String,Integer> map = new HashMap<>();
	public String current_input_char = "";
	
    public AutoCompleteSystem(String sentences[], int times[]) {
        for(int i=0;i<sentences.length;i++) {
        	map.put(sentences[i], times[i]);
        }
    }

    ArrayList<String> input(char c) {
    	ArrayList<String> res = new ArrayList<>();
    	if(c=='#') {
    		map.put(current_input_char, map.getOrDefault(current_input_char,0)+1);
    		current_input_char="";
    	}else {
    		PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.times==b.times?a.sentence.compareTo(b.sentence):b.times-a.times);
        	List<Node> list = new ArrayList<>();
        	current_input_char=current_input_char+c;
    		for(String key:map.keySet()) {
    			if(key.startsWith(current_input_char)) {
    				q.add(new Node(key,map.get(key)));
    			}	
    		}
    		
    		int count = 0;
    		while(!q.isEmpty() && count<3) {
    			res.add(q.poll().sentence);
    			count++;
    		}
    		
    		//O(nlogn) time complexity for sort method where n is number of sentences in current match
//        	Collections.sort(list,(a,b) -> a.times==b.times ? a.sentence.compareTo(b.sentence) : b.times-a.times);
//        	for(int i=0;i<Math.min(3,list.size());i++) {
//        		res.add(list.get(i).sentence);
//        	}
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		String[] sentences = {"i love you","island","ironman","i love leetcode"};
		int[] times = {5,3,2,2};
		AutoCompleteSystem a = new AutoCompleteSystem(sentences,times);
		System.out.println("output: "+a.input('i'));
		System.out.println("output: "+a.input(' '));
		System.out.println("output: "+a.input('a'));
		System.out.println("output: "+a.input('m'));
		System.out.println("output: "+a.input('#'));
		System.out.println("map: "+a.map);

	}

}
