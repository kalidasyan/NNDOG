package solutions;

public class SearchForARange {
	public int[] searchRange(int a[], int target) {
		int[] result = new int[]{-1, -1};
		if(a == null || a.length == 0) {
			return result;
		}
		
		int left = 0;
		int right = a.length - 1;
		int middle = 0;
		//Binary search: find the target
		while(left <= right) {
			middle = (left + right) / 2;
			if(a[middle] < target){
				left = middle + 1;
			} else if (a[middle] > target) {
				right = middle - 1;
			} else {
				break;
			}
		}
		
		//Could not find target
		if(left > right) {
			return result;
		}
		
		result[0] = findBoundary(a, left, middle, target, true);
		result[1] = findBoundary(a, middle, right, target, false);
		
		return result;
	}
	
	private int findBoundary(int[] a, int left, int right, int target, boolean small) {
		while(left + 1 < right) {
			int middle = (left + right) / 2;
			if(a[middle] < target) {
				left = middle + 1;
			} else if(a[middle] > target) {
				right = middle - 1;
			} else {
				if(small){
					right = middle;
				} else {
					left = middle;
				}
			}
		}
		
		if(small) {
			if(a[left] == target) {
				return left;
			} else {
				return right;
			}
		} else {
			if(a[right] == target) {
				return right;
			} else {
				return left;
			}
		}
	}
	
	public void test(){
		int a[] = new int[]{7};
		int target = 7;
		int[] result = searchRange(a, target);
		System.out.print(result[0] + ", " + result[1]);
	}
}
