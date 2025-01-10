package practice_any;

class Solution {
	
	public static boolean isPalindrome(String s) {
		int i =0,j=s.length()-1;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
    public static String longestPalindrome(String s) {
        String result="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++) {
            	String sub = s.substring(i,j+1);
            	if(isPalindrome(sub)){
                    result=sub.length()>result.length()?sub:result;
                 }
            }
            
        }
        return result;
    }
    
    public static void main(String[] args) {
    	String s = "babad";
    	System.out.println(longestPalindrome(s));
    }
    
}
