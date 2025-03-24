package practice_any;

public class Reverse {
	
	   public static int reverse(int x) {
	        int rev = 0;
	        while(x!=0){
	            int n = x%10;
	            rev=(rev*10)+n;
	            x=x/10;
	        }
	        return rev;
	    }
	   
	   public static void main(String[] args) {
		System.out.println(reverse(-1234));
	}

}
