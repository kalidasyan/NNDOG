package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(len < 3) return result;
        
        int i = 0;
        
        while(i < len - 2 && nums[i] <= 0){
        	int first = nums[i];
            int j = i + 1;
            int k = len - 1;
            while(j < k) {
                if(first + nums[j] + nums[k] < 0) {
                    j++;
                } else if (first + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    List<Integer> solution = new ArrayList<Integer>();
                    int second = nums[j];
                    int third = nums[k];
                    
                    solution.add(first);
                    solution.add(second);
                    solution.add(third);
                    result.add(solution);
                    j++;
                    k--;
                    
                    while(j < k && nums[j] == second){
                        j++;
                    }
                    
                    while(j < k && nums[k] == third){
                        k--;
                    }
                }
            }
            
            while(nums[i] == first && i < len - 2) i++;
        }
        
        return result;
    }
    
    public void test() {
    	int[] nums = new int[]{7,5,-8,-6,-13,7,10,1,1,-4,-14,0,-1,-10,1,-13,-4,6,-11,8,-6,0,0,-5,0,11,-9,
    			8,2,-6,4,-14,6,4,-5,0,-12,12,-13,5,-6,10,-10,0,7,-2,-5,-12,12,-9,12,-9,6,-11,1,14,8,-1,7,
    			-13,8,-11,-11,0,0,-1,-15,3,-11,9,-7,-10,4,-2,5,-4,12,7,-8,9,14,-11,7,5,-15,-15,-4,0,0,-11,
    			3,-15,-15,7,0,0,13,-7,-12,9,9,-3,14,-1,2,5,2,-9,-3,1,7,-12,-3,-1,1,-2,0,12,5,7,8,-7,7,8,7,-15};
    	List<List<Integer>> result = threeSum(nums);
    	for(int i = 0; i < nums.length; i++) {
    		System.out.print(nums[i] + " ");
    	}
    	System.out.println();
    	
    	System.out.println(result);
    }
}
