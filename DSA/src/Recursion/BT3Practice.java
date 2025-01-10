package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BT3Practice {

	public static void main(String[] args) {
		int[] num = {1,2,3};
		List<Integer> arr = new ArrayList<>();
		List<List<Integer>> bigList = new ArrayList<>();
		numPermutations(num,arr,bigList);
		System.out.println(bigList);
	}

	private static void numPermutations(int[] num, List<Integer> arr,List<List<Integer>> bigList) {
		
		if(num.length == 0) {
			bigList.add(new ArrayList<>(arr));
			return;
		}
		
		for(int i=0;i<num.length;i++) {
			int currentNum = num[i]; 
			int[] remNum = Arrays.stream(num).filter(x->x!=currentNum).toArray();
			arr.add(currentNum);
			numPermutations(remNum, arr,bigList);
			arr.remove(arr.size()-1);
		}
		
	}
	
}

//Recursive Process:
//
//You start with an empty list arr.
//You add elements to arr as you go deeper into the recursion.
//When you reach the base case (i.e., when num is empty), you add arr to bigList.
//Backtracking:
//
//After adding arr to bigList, you backtrack by removing the last added element from arr.
//This allows the recursion to explore other permutations.
//Issue:
//
//When you add arr to bigList, you're actually adding a reference to the arr list, not a copy of its current state.
//Because arr is mutable, subsequent modifications to arr (like adding or removing elements during backtracking) will affect all references to arr in bigList.
