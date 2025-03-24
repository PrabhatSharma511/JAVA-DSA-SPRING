package Map;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class HashMapImplementation {
	
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
		
		public HashMap() {
			N=4;
			buckets=new LinkedList[N];
			for(int i=0;i<N;i++) {
				buckets[i]=new LinkedList<>();
			}
		}
		
		public int hashcode(K key) {
			int bi = key.hashCode();
			return Math.abs(bi) % N;
		}
		
		public int searchInBucket(K key,int bi) {
			LinkedList<Node> ll = buckets[bi];
			for(int i=0;i<ll.size();i++) {
				if(ll.get(i).key==key) {
					return i;
				}
			}
			return -1;
		}
		
		public void rehash() {
			LinkedList<Node> oldBucket[] = buckets;
			N=N*2;
			buckets = new LinkedList[N];
			for(int i=0;i<N;i++) {
				buckets[i]=new LinkedList<>();
			}
			n=0;
			for(int i = 0;i<oldBucket.length;i++) {
				for(int j=0;j<oldBucket[i].size();j++) {
					Node node = oldBucket[i].get(j);
					put(node.key,node.value);
				}
			}
		}
		
		public V get(K key) {
			int bi = hashcode(key);
			int ni = searchInBucket(key, bi);
			
			if(ni==-1) {
				return null;
			}else {
				return buckets[bi].get(ni).value;
			}
		}
		
		public void put(K key, V value) {
			int bi = hashcode(key);
			int ni = searchInBucket(key,bi);
			
			if(ni==-1) {
				buckets[bi].add(new Node(key,value));
				n++;
			}else {
				Node node = buckets[bi].get(ni);
				node.value=value;
			}
			
			Double lambda = (double)n/N;
			if(lambda>=2.0) {
				rehash();
			}
		}
		
		public int size() {
			return n;
		}
		
		public Set<K> keySet(){
			Set<K> set = new HashSet<>();
			for(int i=0;i<buckets.length;i++) {
				for(int j=0;j<buckets[i].size();j++) {
					set.add(buckets[i].get(j).key);
				}
			}
			return set;
		}
		
		public boolean containsKey(K key) {
			int bi = hashcode(key);
			int di = searchInBucket(key, bi);
			
			if(di==-1) {
				return false;
			}
			return true;
		}
		
		public V remove(K key) {
			
			int bi = hashcode(key);
			int ni = searchInBucket(key, bi);
			
			if(ni==-1) {
				return null;
			}else {
				Node node = buckets[bi].get(ni);
				buckets[bi].remove(ni);
				n--;
				
				double lambda = (double)n/N;
				if(lambda<0.5) {
					decreaseSize();
				}
				
				return node.value;
			}
			
		}
		
		public int capacity() {
			return N;
		}
		
		public void decreaseSize() {
			LinkedList<Node> old[] = buckets;
			N=N/2;
			if(N<4) {
				N=4;
			}
			buckets=new LinkedList[N];
			for(int i=0;i<N;i++) {
				buckets[i]=new LinkedList<Node>();
			}
			n=0;
			for(int i=0;i<old.length;i++) {
				for(int j=0;j<old[i].size();j++) {
					Node node = old[i].get(j);
					put(node.key,node.value);
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		HashMap<String,Integer> map =new HashMap<>();
		map.put("One",1);
		map.put("two",2);
		map.put("three",3);
		map.put("four",4);
		System.out.println(map.get("three"));
		System.out.println(map.size());
		map.put("five",5);
		map.put("six",6);
		map.put("seven",7);
		map.put("eight",8);
		System.out.println(map.keySet());
		System.out.println(map.capacity());
		map.remove("eight");
		map.remove("seven");

		System.out.println(map.capacity()+"dimnish");
		map.remove("six");
		map.remove("five");
		map.remove("four");
		System.out.println(map.capacity()+"dimnish2");
		System.out.println(map.containsKey("two"));
		System.out.println(map.remove("two"));
		System.out.println(map.containsKey("two"));
		System.out.println(map.size());
		


	}

}
