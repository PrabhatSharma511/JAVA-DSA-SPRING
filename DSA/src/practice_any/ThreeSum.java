package practice_any;
import java.util.*;
public class ThreeSum {
	
	
    // Set<List<Integer>> set = new HashSet<>();
    // for(int i=0;i<nums.length;i++){
    //     Set<Integer> s = new HashSet<>();
    //     int e1 = nums[i];
    //     for(int j=i+1;j<nums.length;j++){
    //         int e2 = nums[j];
    //         int e3 = -(e1+e2);
    //         if(s.contains(e3)){
    //             List<Integer> l = Arrays.asList(e1,e2,e3);
    //             Collections.sort(l);
    //             set.add(l);
    //         }
    //         s.add(e2);
    //     }
    // }
    // List<List<Integer>> list = new ArrayList<>(set);
    // return list;
    
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n= nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                    list.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j-1]==nums[j]) j++;
                    while(j<k && nums[k+1]==nums[k]) k--;
                }
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}