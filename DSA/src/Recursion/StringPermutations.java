package Recursion;

import java.util.ArrayList;

public class StringPermutations {
	
	public static ArrayList<String> allPermutations(String original,String making, ArrayList<String> arrayList){
		
		if(original.length()==0) {
			arrayList.add(making);
			return arrayList;
		}
		
		for(int i=0;i<original.length();i++) {
			char curr = original.charAt(i);
			String rem = original.substring(0,i) + original.substring(i+1);
			allPermutations(rem, making+curr,arrayList);
		}
		return arrayList;
	}
	
	public static void main(String[] args) {
		String str = "ABC";
		System.out.println("All Permutations: "+allPermutations(str,"",new ArrayList()));
	}

}
