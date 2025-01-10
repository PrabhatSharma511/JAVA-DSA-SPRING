package Hash;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
	
	static class HashMap<K,V>{
		private class Node{
			K key;
			V value;
			
			public Node(K key, V value) {
				this.key=key;
				this.value=value;
			}
		}
		private int n; //total number of nodes of linked lists
		private int N; //number of array index or size of array
		private LinkedList<Node> buckets[]; //N=buckets.length
		
		@SuppressWarnings("unchecked")
		public HashMap() {
			this.N=4;
			this.buckets=new LinkedList[4];
			for(int i=0;i<4;i++) {
				this.buckets[i]=new LinkedList<>();
			}
		}
		
		private int hashFunction(K key) {
			int bi = key.hashCode();
			return Math.abs(bi) % N;
		}
		
		private int searchInLL(K key, int bi) {
			LinkedList<Node> ll = buckets[bi];
			for(int i =0;i<ll.size();i++) {
				if(ll.get(i).key==key) {
					return i;
				}
			}
			return -1;
		}
		
		private void rehash() {
			LinkedList<Node> oldBucket[] = buckets;
			buckets=new LinkedList[N*2];
			for(int i =0;i<N*2;i++) {
				buckets[i]=new LinkedList<Node>();
			}
			for(int i=0;i<oldBucket.length;i++) {
				LinkedList<Node> ll = oldBucket[i];
				for(int j=0;j<ll.size();j++) {
					Node node = ll.get(j);
					put(node.key,node.value);
				}
			}
		}
		
		public void put(K key, V value) {
			int bi = hashFunction(key);
			int di = searchInLL(key,bi);
			
			if(di==-1) {
				buckets[bi].add(new Node(key,value));
				n++;
			}else {
				Node node = buckets[bi].get(di);
				node.value=value;
				
			}
			
			double lambda = (double)n/N;
			if(lambda>2.0) {
				rehash();;
			}
		}

		public boolean containsKey(K key) {
			int bi = hashFunction(key);
			int di = searchInLL(key,bi);
		
			if(di==-1) {
				return false;
			}else {
				return true;
			}
		}
		
		public V remove(K key) {
			int bi = hashFunction(key);
			int di = searchInLL(key,bi);
		
			if(di==-1) {
				return null;
			}else {
				LinkedList<Node> ll = buckets[bi];
				Node node = ll.remove(di);
				n--;
				return node.value;
			}
		}
		
		public V get(K key) {
			int bi = hashFunction(key);
			LinkedList<Node> ll = buckets[bi];
			for(int i =0;i<ll.size();i++) {
				if(ll.get(i).key==key) {
					return ll.get(i).value;
				}
			}
			return null;
		}
		
		public ArrayList<K> keySet(){
			ArrayList<K> list = new ArrayList<>();
			for(int i =0;i<buckets.length;i++) {
				for(int j=0;j<buckets[i].size();j++) {
					list.add(buckets[i].get(j).key);
				}
			}
			return list;
		}
		
		public boolean isEmpty() {
			return false;
		}
	}
	
	public static void main(String args[]) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("India", 145);
		map.put("USA",35);
		
		System.out.println(map.keySet());
		System.out.print(map.remove("USA"));
		System.out.print(map.get("USA"));
	}

}
