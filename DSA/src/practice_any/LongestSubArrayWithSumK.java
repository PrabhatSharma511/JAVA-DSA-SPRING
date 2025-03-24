package practice_any;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
	
	public static int method(int[] arr,int k) {
		
		Map<Integer,Integer> map = new HashMap<>();
		int sum = 0;
		int length = 0;
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
			if(sum==k) {
				length=i+1;
			}
			if(map.containsKey(sum-k)) {
				length=Math.max(i-map.get(sum-k), length);
			}
			if(!map.containsKey(sum)) {
				map.put(sum,i);
			}
		}
		return length;
		
	}
	
	public static void main(String[] args) {
		int arr[] = {-5, 8, -14, 2, 4, 12};
		int k = -5;
		System.out.println(method(arr,k));
	}

}
