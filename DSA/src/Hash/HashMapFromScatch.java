package Hash;

import java.util.Arrays;
import java.util.LinkedList;

public class HashMapFromScatch {
	
	static class HashMap<K,V>{
		private class Node{
			K key;
			V value;
			
			public Node(K key, V value) {
				this.key=key;
				this.value=value;
			}
		}
		int n;
		int N;
		LinkedList<Node> buckets[];
		
		@SuppressWarnings("unchecked")
		public HashMap() {
			N=2;
			buckets=new LinkedList[N];
			for(int i=0;i<N;i++) {
				buckets[i]=new LinkedList<>();
			}
		}
		public void rehash() {
			LinkedList<Node>[] original = buckets;
			N=N*2;
			buckets = new LinkedList[N];
			for(int i=0;i<N;i++) {
				buckets[i]=new LinkedList<>();
			}
			n=0;
			for(int i=0;i<original.length;i++) {
				LinkedList<Node> ll = original[i];
				for(int j=0;j<ll.size();j++) {
					Node node = ll.get(j);
					put(node.key,node.value);
				}
			}
		}
		public int hash(K key) {
			int bi = key.hashCode();
			return Math.abs(bi) % N;
		}
		
		public int searchInLL(K key,int bi) {
				LinkedList<Node> ll = buckets[bi];
				for(int j=0;j<ll.size();j++) {
					if(ll.get(j).key==key) {
						return j;
					}
				}
			return -1;
		}
		
		private void put(K key, V value) {
			int bi = hash(key);
			int di = searchInLL(key, bi);
			
			if(di == -1) {
				Node node = new Node(key,value);
				buckets[bi].add(node);
				n++;
			}else {
				Node node = buckets[bi].get(di);
				node.value=value;
			}
			
			double lambda = (double)n/N;
			if(lambda>=2.0) {
				rehash();
			}
		}
		
		private V get(K key) {
			int bi = hash(key);
			int di = searchInLL(key, bi);
			
			if(di==-1) {
				System.out.println("No such key");
				return null;
			}else {
				return buckets[bi].get(di).value;
			}
		}
		private boolean containsKey(K key) {
			int bi = hash(key);
			LinkedList<Node> ll = buckets[bi];
			for(int i=0;i<ll.size();i++) {
				if(ll.get(i).key==key) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public String toString() {
			String result = "";
			for(int i=0;i<buckets.length;i++) {
				for(int j=0;j<buckets[i].size();j++) {
					result = result + buckets[i].get(j).key+" = "+buckets[i].get(j).value+", ";
				}	
			}
			return "{"+result+ "}";
		}
		
		private int size() {
			return n;
		}
	}
	
	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("Prabhat",25);
		map.put("any", 29);
		
		System.out.println(map.get("Prabhat"));
		System.out.println(map.containsKey("Prabhat"));
		
		System.out.println(map.size());
		map.put("s", 1);
		System.out.println(map.size());
		map.put("7", 1);
		System.out.println(map.size());map.put("j", 1);
		System.out.println(map.size());
		System.out.println(map);

	}

}
