package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class WordLadderII {	
	Map<String, ArrayList<String>> wordTree = new HashMap<String, ArrayList<String>>();
	String end = null;
	Set<String> connected = new HashSet<String>();
	
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	dict.remove(start);
        dict.add(end);
        this.end = end;
        
        Set<String> visited = new HashSet<String>();
        Set<String> connecting = new HashSet<String>();
        
        wordTree.put(start, null);
        
        connecting.add(start);
       	
        while(!connecting.isEmpty()) {
            Set<String> next = new HashSet<String>();
            for(String word : connecting) {
            	findNeighbors(word, dict, visited, next);
            }
            visited.addAll(next);
            connecting = next;
            if(connecting.contains(end)) {
        		break;
        	}
        }
        
        return calculate();
    }
    
    private List<List<String>> calculate() {
    	List<List<String>> result = new ArrayList<List<String>>();
    	for(String word : connected) {
    		ArrayList<String> solution = new ArrayList<String>();
    		solution.add(end);
    		dfs(word, solution, result);
    	}
    	return result;
	}

	private void dfs(String word, ArrayList<String> solution, List<List<String>> result) {
		ArrayList<String> parents = wordTree.get(word);
		if(parents == null) {
			solution.add(word);
			Collections.reverse(solution);
    		result.add(solution);
    		return;
		}
		
		for(String parent : parents) {
			ArrayList<String> s = new ArrayList<String>(solution);
			s.add(word);
			dfs(parent, s, result);
		}
	}

	private void findNeighbors(String word, Set<String> wordDict, Set<String> visited, Set<String> next) {
    	for(int i = 0; i < word.length(); i++) {
    		for(int j = 0; j < 26; j++) {
    			char[] array = word.toCharArray();
    			if(array[i] != (char) ('a' + j) ) {
    				array[i] = (char) ('a' + j);
    				String neighbor = new String(array);
    				if(wordDict.contains(neighbor) && !visited.contains(neighbor)) {
    					next.add(neighbor);
    					
    					if(neighbor.equals(end)) {
    						connected.add(word);
    						return;
    					} else {
    						ArrayList<String> neighborParents = wordTree.get(neighbor);
    						if(neighborParents == null) {
    							neighborParents = new ArrayList<String>();
    							wordTree.put(neighbor, neighborParents);
    						}
    						neighborParents.add(word);
    					}
    				}
    			}
    		}
    	}
    }
    
	//"red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]
    public void test() {
    	String beginWord = "red";
    	String endWord = "tax";
    	Set<String> wordDict = new HashSet<String>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
    	long startTime = System.currentTimeMillis();
    	List<List<String>> result = findLadders(beginWord, endWord, wordDict);
    	long endTime = System.currentTimeMillis();
    	for(List<String> solution : result){
    		System.out.println(solution);
    	}
    	
    	System.out.println(endTime - startTime);
    }
}
