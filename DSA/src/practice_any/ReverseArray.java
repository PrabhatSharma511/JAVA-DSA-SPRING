package practice_any;

import java.util.Arrays;

public class ReverseArray {
	
	  
    public static void rotateLeft(int[] nums, int k){
        int n = nums.length;
        for(int i=0;i<k;i++){
            int first = nums[0];
            for(int j=0;j<n-1;j++){
                nums[j]=nums[j+1];
            }
            nums[n-1]=first;
        }
    }
    
    public static void rotateRight(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<k;i++){
            int last = nums[n-1];
            for(int j=n-1;j>0;j--){
                nums[j]=nums[j-1];
            }
            nums[0]=last;
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotateRight(nums,3);
        

           System.out.println(Arrays.toString(nums)); 
        
        
    }

}
