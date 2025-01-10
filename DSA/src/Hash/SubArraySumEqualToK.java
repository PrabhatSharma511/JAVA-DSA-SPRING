package Hash;

import java.util.ArrayList;
import java.util.List;

//number of subarrays that have sum equal to k
public class SubArraySumEqualToK {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int k = 3;
		method(arr,k);
	}

	private static void method(int[] arr, int k) {
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			int sum = 0;
			for(int j =i;j<arr.length;j++) {
				sum=sum+arr[j];
				if(sum==k) {
					count++;
					List<Integer> list = new ArrayList<>();
					for(int l=i;l<=j;l++) {
						list.add(arr[l]);
					}
					System.out.println(list);
				}
			}
		}
		System.out.println(count);
	}
	
	
}
