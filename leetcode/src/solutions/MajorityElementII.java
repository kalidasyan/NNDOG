package solutions;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int m1 = 0;
        int m2 = 0;
        int c1 = 0;
        int c2 = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(c1 == 0 || nums[i] == m1) {
                m1 = nums[i];
                c1++;
            } else if(c2 == 0 || nums[i] == m2) {
                m2 = nums[i];
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == m1) {
                c1++;
            } else if(nums[i] == m2) {
                c2++;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(c1 > nums.length / 3){
        	result.add(m1);
        }
        
        if(c2 > nums.length / 3){
        	result.add(m2);
        }
        
        return result;
    }
}
