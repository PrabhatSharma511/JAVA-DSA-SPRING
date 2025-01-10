package Hash;

import java.util.HashMap;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

	public static void main(String args[]) {
		int arr1[] = {7,3,9};
		int arr2[] = {6,3,9,2,9,4,8,8,8};
		intersection(arr1,arr2);
	}

	private static void intersection(int[] arr1, int[] arr2) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<arr1.length;i++) {
			set.add(arr1[i]);
		}
		HashSet<Integer> intersection = new HashSet<>();
		int count = 0;
		for(int i=0;i<arr2.length;i++) {
			if(set.contains(arr2[i])) {
				intersection.add(arr2[i]);
				count++;
				set.remove(arr2[i]);//this is required otherwise gives wrong ans. in count wala case
			}
		}
		System.out.println(intersection+" "+count);
	}
	
}
