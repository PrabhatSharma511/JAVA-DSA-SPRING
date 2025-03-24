package practice_any;
import java.util.*;
public class MajorityElement {
    
    public static List<Integer> majority(int[] nums){
        int element1 = 0;
        int element2 = 1;
        int count1 =0;int count2 =0;
        int n= nums.length;
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            if(num==element1){
                count1++;
            }else if(num==element2){
                count2++;
            }else if(count1==0){
                element1=num;
            }else if(count2==0){
                element2=num;
            }else{
                count1--;
                count2--;
            }
        }
        count1 =0;count2=0;
        for(int num:nums){
            if(num==element1){
                count1++;
            }else if(num==element2){
                count2++;
            }
        }
        if(count1>n/3){
            list.add(element1);
        }
        if(count2>n/3){
            list.add(element2);
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 2, 2, 1, 1, 1};
        System.out.println(majority(nums));
    }
}