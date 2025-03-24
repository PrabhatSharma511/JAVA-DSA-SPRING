package practice_any;
import java.util.*;


class SubArrayWithMaxSum {
    
    public static int[] subArrayWithMaxSum(int[] nums){
        int max = Integer.MIN_VALUE;
        int curr = 0;
        int start = 0;
        int end = 0;
        int s = 0;
        for(int i=0;i<nums.length;i++){
            if(curr==0){
                s=i;
            }
            curr=curr+nums[i];
            if(curr>max){
                max=curr;
                start=s;
                end=i;
            }
            if(curr<0){
                curr=0;
            }
        }
        int[] a = new int[end-start+1];
        int j=0;
        for(int i = start;i<=end;i++){
            a[j++]=nums[i];
        }
        return a;
        
    }
    
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.toString(subArrayWithMaxSum(nums)));
    }
}