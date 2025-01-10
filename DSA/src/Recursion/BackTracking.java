package Recursion;

public class BackTracking {
	
	public static void permutations(String str, String perm, int idx) {
		
		if(str.length()==0) {
			System.out.println(perm);
		}
		
		for(int i=0;i<str.length();i++) {
			char currentChar = str.charAt(i);
			String remString = str.substring(0, i) + str.substring(i+1);
			permutations(remString, perm+currentChar, idx+1);
		}
	}
	
	public static void main(String[] args) {
		String str = "ABC";
		permutations(str, "",0);
	}
	
}


//Strings are Immutable:
//
//In the permutations method, the perm string is not modified in place. Instead, a new string is created for each recursive call.
//Since strings are immutable, there’s no need to undo changes; each recursive call works with a new string object.
