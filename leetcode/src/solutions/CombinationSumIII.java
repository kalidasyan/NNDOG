package solutions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        find(candidates, n, k, result, solution, 0);
        return result;
    }
    
    private void find(int[] candidates, int target, int k, List<List<Integer>> result, List<Integer> solution, int start) {
    	if(target == 0 && k == 0) {
    		result.add(new ArrayList<Integer>(solution));
    		return;
    	}
    	
    	for(int i = start; i < candidates.length; i++){
    		if(candidates[i] <= target && k > 0) {
    			solution.add(candidates[i]);
    			find(candidates, target-candidates[i], k-1, result, solution, i+1);
    			solution.remove(solution.size()-1);
    		} else {
    		    break;
    		}
    	}
    }

    
    public void test() {

    	List<List<Integer>> result = combinationSum3(3, 9);
    	
    	for(List<Integer> solution : result) {
    		for(Integer value : solution) {
    			System.out.print(value + ", ");
    		}
    		System.out.println();
    	}
    }
}
