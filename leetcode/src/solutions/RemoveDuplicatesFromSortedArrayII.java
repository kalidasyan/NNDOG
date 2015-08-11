package solutions;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums == null) {
        	return 0;
        }
        
        if(nums.length < 3) {
        	return nums.length;
        }
        
        int count = 1;
        int current = nums[0];
        Set<Integer> duplicates = new HashSet<Integer>();
        
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] == current) {
        		count++;
        		if(count > 2) {
        			duplicates.add(i);
        		}
        	} else {
        		count = 1;
        		current = nums[i];
        	}
        }
        
        int j = 2;
        for(int i = 2; i < nums.length; i++) {
        	if(!duplicates.contains(i)){
        		nums[j] = nums[i];
        		j++;
        	}
        }
        return j;
    }
    
    public void test(){
//    	int[] nums = new int[]{1,1,1,2,2,3};
    	int[] nums = new int[]{1,1,1,1,1};
    	int size = removeDuplicates(nums);
    	for(int i = 0; i < size; i++) {
    		System.out.print(nums[i] + ", ");
    	}
    }
}
