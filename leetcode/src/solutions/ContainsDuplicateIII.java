package solutions;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if(k<1 || t<0 || nums==null || nums.length<2) return false;  
    	
    	TreeSet<Long> bst = new TreeSet<Long>();
    	
        for(int i = 0; i < nums.length; i++) {
        	if(!bst.subSet((long)nums[i] - t, (long)nums[i] + t + 1).isEmpty()){
        		return true;
        	}
        	
        	if(i >= k) {
        		bst.remove((long)nums[i-k]);
        	}
        	
        	bst.add((long)nums[i]);
        }
        
        return false;
    }
}
