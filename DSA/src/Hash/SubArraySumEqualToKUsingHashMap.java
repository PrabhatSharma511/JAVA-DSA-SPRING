package Hash;

import java.util.HashMap;

public class SubArraySumEqualToKUsingHashMap {

	public static void main(String args[]) {
		int arr[] = {10,2,-2,-20,10};
		int k = -10;
		method(arr,k);
	}

	private static void method(int[] arr, int k) {
		HashMap<Integer,Integer> sumMap = new HashMap<>();
		sumMap.put(0,1);
		int sum = 0;
		int ans =0;
		for(int num:arr) {
			sum=sum+num;
			if(sumMap.containsKey(sum-k)) {
				ans=ans+sumMap.get(sum-k);
			}
			if(sumMap.containsKey(sum)) {
				sumMap.put(sum,sumMap.get(sum)+1);
			}else {
				sumMap.put(sum,1);
			}
		}
		System.out.println(ans);
	}
	
}
