package solutions;

public class NextPermutation {
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
//    	int[] nums = new int[]{6,9,8,7,5,3,1};
//    	int[] nums = new int[]{1,2,3};
//    	int[] nums = new int[]{3,2,1};
    	int[] nums = new int[]{5,1,1};
    	nextPermutation(nums);
    	for(int i = 0; i < nums.length; i++) {
    		System.out.print(nums[i] + ", ");
    	}
    	System.out.println();
    }
}
