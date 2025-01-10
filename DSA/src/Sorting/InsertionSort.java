package Sorting;

//It is a stable sorting algorithm, meaning that elements with equal values maintain their relative order in the sorted output.

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {3,1,5,2};
		int n= arr.length;
		
		for(int i=1;i<n;i++) {
			int current = arr[i];
			int j=i-1;
			while(j>=0 && current<arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = current;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
}
