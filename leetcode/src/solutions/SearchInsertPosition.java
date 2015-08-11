package solutions;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int left = 0;
		int right = nums.length - 1;
		int middle = 0;
		//Binary search: find the target
		while(left <= right) {
			middle = (left + right) / 2;
			if(nums[middle] < target){
				left = middle + 1;
			} else if (nums[middle] > target) {
				right = middle - 1;
			} else {
				break;
			}
		}
		
		//target found
		if(left <= right) {
			return middle;
		}
		
		if(right < 0) { //check if right < 0: target < nums[0]
			return 0;
		} else if(nums[right] > target) {
			return right;
		} else {
			return right + 1;
		}
		
	}
	
	public void test(){
		int a[] = new int[]{1,3};
		int target = 4;
		int result = searchInsert(a, target);
		System.out.print(result);
	}
}
