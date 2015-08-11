package solutions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        int len = s.length();
        if(len == 0) {
            return result;
        }
        
        boolean[][] pTable = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            pTable[i][i] = true;
        }
        
        buildPalindromeTable(s, pTable);
        
        dfs(s, pTable, 0, result, new ArrayList<String>());
        
        return result;
    }
    
    private void buildPalindromeTable(String s, boolean[][] pTable) {
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if(j == i+1) {
                    pTable[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    pTable[i][j] = (s.charAt(i) == s.charAt(j) && pTable[i+1][j-1]);
                }
            }
        }
    }
    
    private void dfs(String s, boolean[][] pTable, int position, List<List<String>> result, List<String> solution) {
        if(position == s.length()) {
            result.add(new ArrayList<String>(solution));
            return;
        }
        
        for(int i = position; i < s.length(); i++) {
            if(pTable[position][i]) {
                solution.add(s.substring(position, i+1));
                dfs(s, pTable, i+1, result, solution);
                solution.remove(solution.size() - 1);
            }
        }
    }
    
    public void test(){
    	List<List<String>> result = partition("aabbaacc");
    	for(List<String> solution : result) {
    		for(String s : solution) {
    			System.out.print(s + ", ");
    		}
    		System.out.println();
    	}
    }
}
