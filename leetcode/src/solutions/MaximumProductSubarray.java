package solutions;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        
        int max = Integer.MIN_VALUE;
        int start = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
            	max = Math.max(max, 0);
                max = Math.max(max, maxProduct(nums, start, i - 1));
                int j = i + 1;
                for(; j < nums.length; j++) {
                    if(nums[j] != 0) {
                        start = j;
                        i = j;
                        break;
                    }
                }
                if(j == nums.length) {
                    start = -1;
                    break;
                }
            }
        }
        
        if(start >= 0) {
            max = Math.max(max, maxProduct(nums, start, nums.length - 1));
        }
        
        return max;
    }
    
    public int maxProduct(int[] nums, int start, int end) {
        if(start > end) return 0;
        if(start == end) return nums[start];
        
        int firstNegtive = -1;
        int lastNegtive = -1;
        int count = 0;
        for(int i = start; i <= end; i++) {
            //nums[i] could not be zero since we cut the array based on the 0s in maxProduct(int[] nums).
            if(nums[i] < 0) {
                if(firstNegtive < 0) {//first negtive number
                    firstNegtive = i;
                }
                lastNegtive = i;
                count++;
            }
        }
        
        if(count % 2 == 0) {
            return product(nums, start, end);
        } else {
            return Math.max(product(nums, start, lastNegtive - 1), product(nums, firstNegtive + 1, end));
        }
    }
    
    public int product(int[] nums, int start, int end) {
        if(start > end) return 0;
        int result = 1;
        for(int i = start; i <= end; i++) {
            result *= nums[i];
        }
        return result;
    }
    
    public void test() {
    	int[] nums = new int[]{0, 2};
    	System.out.println(maxProduct(nums));
    }
}
