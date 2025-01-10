package Hash;

import java.util.HashSet;
import java.util.Iterator;

public class UnionOfTwoArrays {

	public static void main(String args[]) {
		int arr1[] = {7,3,9};
		int arr2[] = {6,3,9,2,9,4};
		int[] arr = union(arr1,arr2);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

	private static int[] union(int[] arr1, int[] arr2) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<arr1.length;i++) {
			set.add(arr1[i]);
		}
		for(int i=0;i<arr2.length;i++) {
			set.add(arr2[i]);
		}
//		System.out.println(set);
//		System.out.println(set.size());
		
		int[] arr3 = new int[set.size()];
		Iterator<Integer> it = set.iterator();
		int i=0;
		while(it.hasNext()) {
			arr3[i++]=it.next();
		}
		
		return arr3;
	}
	
}
