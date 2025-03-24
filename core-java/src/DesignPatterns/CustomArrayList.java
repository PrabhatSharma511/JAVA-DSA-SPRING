package DesignPatterns;

import java.util.Arrays;

public class CustomArrayList<T> {
	
	private int capacity;
	T[] arr;
	private int size;
	
	public CustomArrayList(){
		this.capacity=10;
		this.size=0;
		this.arr = (T[]) new Object[capacity];
	}
	
	public CustomArrayList(int capacity){
		this.capacity=capacity;
		this.size=0;
		this.arr = (T[]) new Object[capacity];
		
	}
	
	public void add(T e) {
		if(size>0.75*capacity) {
			increaseSize();
		}
		arr[size++]=e;
	}
	
	public void increaseSize() {
		capacity=capacity*2;
		arr=Arrays.copyOf(arr, capacity);
	}
	
	public void remove(int index) {
		if(index<0 || index>size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for(int i =index;i<size-1;i++) {
			arr[i]=arr[i+1];
			arr[size-1]=null;
			size--;
		}
	}
	
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public T get(int index) {
		return arr[index];
	}
	
	
	
	public static void main(String[] args) {
		CustomArrayList<Integer> ca = new CustomArrayList<>();
		ca.add(1);
		ca.add(2);
		ca.remove(0);
		System.out.println(ca.size+" "+ca.capacity);
//		System.out.println(ca.get(1));
	}

}
