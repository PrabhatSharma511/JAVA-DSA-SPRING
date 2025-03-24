package Collections;

import java.util.Arrays;

public class ArrayListImplementation {
	
	static class ArrayList<T>{
		int size;
		int capacity;
		T[] elements;
		
		public ArrayList() {
			this.size=0;
			this.capacity=3;
			elements = (T[])new Object[capacity];
		}
		
		public void resize() {
			capacity=capacity*2;
			elements=Arrays.copyOf(elements, capacity);
		}
		
		public void add(T element) {
			elements[size]=element;
			size++;
			if(size==capacity) {
				resize();
			}
		}
		
		public void dimnishSize() {
			capacity = capacity/2;
			if(capacity<3) {
				capacity=3;
			}
		}
		
		public T remove(int index) {
			T ele = elements[index]; 
			for(int i=index;i<size-1;i++) {
				elements[i] = elements[i+1];
			}
			elements[size-1]=null;
			size--;
			if(size < capacity/2) {
				dimnishSize();
			}
			
			return ele;
		}
		
		public T get(int index) {
			if(index < 0 || index >=size) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return elements[index];
		}
		
		public int size() {
			return size;
		}
		
		@Override
		public String toString() {
			T[] arr = Arrays.copyOf(elements, size);
			return Arrays.toString(arr);
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		System.out.println(list.capacity);
		System.out.println(list.remove(0));
		System.out.println(list.remove(1));
		System.out.println(list.capacity);
		list.add(87);
		System.out.println(list.get(0));
		System.out.print(list);		
	}

}
