package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        find(candidates, target, result, solution, 0);
        return result;
    }
    
    private void find(int[] candidates, int target, List<List<Integer>> result, List<Integer> solution, int start) {
    	if(target == 0) {
    		result.add(new ArrayList<Integer>(solution));
    		return;
    	}
    	
    	for(int i = start; i < candidates.length; i++){
    		if(candidates[i] <= target) {
    			solution.add(candidates[i]);
    			find(candidates, target-candidates[i], result, solution, i);
    			solution.remove(solution.size()-1);
    		} else {
    		    break;
    		}
    	}
    }
    
    public void test() {
    	int[] candidates = new int[]{2,3,6,7};
    	int target = 7;
    	List<List<Integer>> result = combinationSum(candidates, target);
    	
    	for(List<Integer> solution : result) {
    		for(Integer value : solution) {
    			System.out.print(value + ", ");
    		}
    		System.out.println();
    	}
    }
}
