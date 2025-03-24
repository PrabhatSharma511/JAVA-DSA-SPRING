package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class NextPermutationLC31 {
	
	public static void main(String[] args) {
//		int[] arr = {1,2,3};
//		int[] arr2 = {3,2,1};
		int[] arr3 = {1,1,5};
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list = allPermutations(arr3,new ArrayList<>(),list);
		list=new ArrayList(new HashSet(list)); // to remove duplicates
		list.sort((a,b)->{
			for(int i=0;i<a.size();i++) {
				if(a.get(i)!=b.get(i)) {
					return a.get(i)-b.get(i);
				}
			}
			return 0;
		});
		ArrayList<Integer> numsList = new ArrayList<>();
		for(int num: arr3) {
			numsList.add(num);
		}
		
		System.out.println("All Permutations: "+list);
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals(numsList)) {
				if(i+1<list.size()) {
					System.out.println("Next Permutation: "+ Arrays.toString(list.get(i+1).stream().toArray()));
				}else {
					System.out.println("Next Permutation: "+ Arrays.toString(list.get(0).stream().toArray()));
				}
			}
		}
	}

	private static ArrayList<ArrayList<Integer>> allPermutations(int[] arr, ArrayList<Integer> permutation,
			ArrayList<ArrayList<Integer>> list) {
		
		if(arr.length==0) {
			list.add(new ArrayList<>(permutation));
			return list;
		}
		
		for(int i=0;i<arr.length;i++) {
			int curr = arr[i];
			int[] rem = new int[arr.length-1];
			int index = 0;
			for(int j=0;j<arr.length;j++) {
				if(i!=j) {
					rem[index++]=arr[j];
				}
			}
			permutation.add(curr);
			allPermutations(rem, permutation, list);
			permutation.remove(permutation.size()-1);
		}
		return list;
	}

}
