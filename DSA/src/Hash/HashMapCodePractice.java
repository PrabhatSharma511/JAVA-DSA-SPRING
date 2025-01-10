package Hash;

import java.util.LinkedList;

public class HashMapCodePractice {
	
	static class HashMap<K,V>{
		
		private class Node{
			K key;
			V value;
			
			public Node(K key, V value) {
				this.key=key;
				this.value=value;
			}
		}
		
		private int n;
		private int N;
		private LinkedList<Node> buckets[];
		
		public HashMap() {
			this.N=4;
			this.buckets=new LinkedList[4];
			for(int i=0;i<4;i++) {
				buckets[i] = new LinkedList<>();
			}
		}
		
		public void put(K key, V value) {
			int bi = hashFunction(key);
			int di = searchInLL(bi,key);
			
			if(di==-1) {
				Node node = new Node(key, value);
				buckets[bi].add(node);
				n++;
			}else {
				buckets[bi].get(di).value=value;
			}
			double lambda = (double)n/N;
			if(lambda>2.0) {
				rehash();
			}
		}

		private void rehash() {
			LinkedList<Node> oldData[] = buckets;
			buckets=new LinkedList[N*2];
			for(int i=0;i<N*2;i++) {
				buckets[i]=new LinkedList<Node>();
			}
			for(int i =0;i<oldData.length;i++) {
				LinkedList<Node> ll = oldData[i];
				for(int j=0;j<ll.size();j++) {
					Node node = ll.get(j);
					put(node.key, node.value);
				}
			}
			
			
		}

		private int searchInLL(int bi, K key) {
			LinkedList<Node> ll = buckets[bi];
			for(int i=0;i<ll.size();i++) {
				if(ll.get(i).key==key) {
					return i;
				}
			}
			return -1;
		}

		private int hashFunction(K key) {
			int hash = key.hashCode();
			return Math.abs(hash) % N;
		}
		
		private V get(K key) {
			int bi = hashFunction(key);
			int di = searchInLL(bi, key);
			
			if(di==-1) {
				return null;
			}else {
				return buckets[bi].get(di).value;
			}
		}
		
	}
	
	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("India",140);
		
		System.out.println(map.get("India"));
	}

}
