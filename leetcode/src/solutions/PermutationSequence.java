package solutions;


public class PermutationSequence {
    public String getPermutation(int n, int k) {
    	if(n <= 0){
    		return null;
    	}
    	
        int[] nums = new int[n];
        double factorial = 1;
        for(int i = 1; i <= n; i++) {
        	nums[i-1] = i;
        	factorial *= i;
        }
        
        if(factorial <= k){
        	k = (k-1) % (int)(factorial);
        }
        
        if(k-1 <= 0){
        	return arrayToString(nums);
        }
        
        for(int i = 0; i < k-1; i++) {
        	nextPermutation(nums);
        }
        
        return arrayToString(nums);
    }
    
    private String arrayToString(int[] nums){
    	StringBuffer sb = new StringBuffer();
    	for(int i = 0; i < nums.length; i++) {
    		sb.append(nums[i]);
    	}
    	return sb.toString();
    }
    
    public void nextPermutation(int[] nums) {
    	if(nums == null || nums.length < 2) {
    		return;
    	}
    	
    	int small = -1;
    	for(int i = nums.length-1; i > 0; i--){
    		if(nums[i] > nums[i-1]){
    			small = i-1;
    			break;
    		}
    	}
    	
    	if(small == -1) {
    		reverse(nums, 0, nums.length-1);
    		return;
    	}
    	
    	int next = -1;
    	for(int i = small+1; i < nums.length; i++) {
    		if(nums[i] <= nums[small]){
    			next = i-1;
    			break;
    		}
    	}
    	if(next == -1){
    		next = nums.length-1;
    	}
    	
    	int tmp = nums[small];
    	nums[small] = nums[next];
    	nums[next] = tmp;
    	reverse(nums, small+1, nums.length-1);
    }
    
    private void reverse(int[] nums, int left, int right) {
    	if(left >= right) {
    		return;
    	}
    	
    	while(left < right) {
    		int tmp = nums[left];
    		nums[left] = nums[right];
    		nums[right] = tmp;
    		left++;
    		right--;
    	}
    }
    
    public void test(){
    	System.out.println(getPermutation(3,5));
    }
}
