package practice_any;

import java.util.Arrays;
import java.util.List;

public class diagonalDiff {
	
	public static int diagonalDifference(List<List<Integer>> arr) {
		int sum1 = 0;
		int sum2=0;
		for(int i=0,j=0;i<arr.size() && j<arr.size();i++,j++) {
			sum1+=arr.get(i).get(j);
		}
		System.out.println(sum1);
		for(int i =0,j = arr.get(0).size()-1;i<arr.size() && j>=0;i++,j--) {
			sum2+=arr.get(i).get(j);
		}
		System.out.println(sum2);
		
		return sum2-sum1;
	}

	public static void main(String args[]) {
		List<List<Integer>> arr = Arrays.asList(
	            Arrays.asList(1, 2, 4),
	            Arrays.asList(4, 5, 6),
	            Arrays.asList(7, 8, 9)
	        );
		
		diagonalDifference(arr);
	}
	
}
