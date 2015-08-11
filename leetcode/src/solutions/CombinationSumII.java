package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
	public Set<Integer> startWith = new HashSet<Integer>();
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        find(candidates, target, result, solution, 0);
        return result;
    }
    
    private void find(int[] candidates, int target, List<List<Integer>> result, List<Integer> solution, int start) {
    	if(target == 0) {
    		if(isDuplicated(result, solution)) return;
    		result.add(new ArrayList<Integer>(solution));
    		startWith.add(solution.get(0));
    		return;
    	}
    	
    	for(int i = start; i < candidates.length; i++){
    		if(solution.isEmpty() && startWith.contains(candidates[i])){
    			continue;
    		}
    		
    		if(candidates[i] <= target) {
    			solution.add(candidates[i]);
    			find(candidates, target-candidates[i], result, solution, i+1);
    			solution.remove(solution.size()-1);
    		} else {
    		    break;
    		}
    	}
    }
    
    private boolean isDuplicated(List<List<Integer>> result, List<Integer> solution) {
    	for(List<Integer> s : result) {
    		if(s.get(0) < solution.get(0)) {
    			continue;
    		} else if (s.get(0) > solution.get(0)) {
    			break;
    		} else {
    			if(s.size() == solution.size()) {
    				int i = 0;
    				for(; i < solution.size(); i++) {
    					if(s.get(i) != solution.get(i)) break;
    				}
    				if(i == solution.size()) return true;
    			}
    		}
    	}
    	return false;
    }
    
    public void test() {
    	int[] candidates = new int[]{2,2,2};
    	int target = 4;
    	List<List<Integer>> result = combinationSum2(candidates, target);
    	
    	for(List<Integer> solution : result) {
    		for(Integer value : solution) {
    			System.out.print(value + ", ");
    		}
    		System.out.println();
    	}
    }
}
