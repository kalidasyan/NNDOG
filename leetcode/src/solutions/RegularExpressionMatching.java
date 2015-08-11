package solutions;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
    	if(s == null) {
    		return false;
    	}
    	
    	int sl = s.length();
    	int pl = p.length();
    	
    	boolean[][] matchTable = new boolean[sl + 1][pl + 1];
    	matchTable[0][0] = true;
    	
    	for(int i = 1; i < sl + 1; i++) {
    		matchTable[i][0] = false;
    	}
    	
    	for(int i = 1; i < pl + 1; i++) {
    		if(p.charAt(i-1) != '*') {
    			matchTable[0][i] = false;
    		} else {
    			matchTable[0][i] = matchTable[0][i-2];
    		}
    	}
    	
    	for(int i = 1; i < sl + 1; i++) {
    		for(int j = 1; j < pl + 1; j++) {
    			char pChar = p.charAt(j-1);
    			if(pChar == '.'){
    				matchTable[i][j] = matchTable[i-1][j-1];
    			} else if(pChar == '*') {
    				boolean match = false;
    				
    				//* match 0 previous character
    				match = match || matchTable[i][j-2];
    				if(match){
    					matchTable[i][j] = true;
    					continue;
    				}
    				
    				//* match multiple previous character
    				char prePChar = p.charAt(j-2);
    				if(prePChar == '.'){
    					//.* match multiple characters
    					for(int k = i-1; k >= 0; k--) {
    						if(matchTable[k][j-2]){
    							match = true;
    							break;
    						}
    					}
        				if(match){
        					matchTable[i][j] = true;
        					continue;
        				}
    				} else {
    					//a* match multiple characters
    					for(int k = i; k > 0; k--) {
    						if(s.charAt(k-1) != prePChar) {
    							match = false;
    							break;
    						} else if (matchTable[k-1][j-2]){
    							match = true;
    							break;
    						}
    					}
        				if(match){
        					matchTable[i][j] = true;
        					continue;
        				}
    				}
    				
    				matchTable[i][j] = false;

    			} else {
    				if(pChar == s.charAt(i-1)){
    					matchTable[i][j] = matchTable[i-1][j-1];
    				} else {
    					matchTable[i][j] = false;
    				}
    			}
    		}
    	}
    	
    	return matchTable[sl][pl];
    }
    
    public void test() {
//    	isMatch("aa","a") → false
//    	isMatch("aa","aa") → true
//    	isMatch("aaa","aa") → false
//    	isMatch("aa", "a*") → true
//    	isMatch("aa", ".*") → true
//    	isMatch("ab", ".*") → true
//    	isMatch("aab", "c*a*b") → true
//    	System.out.println(isMatch("aa","a"));
//    	System.out.println(isMatch("aa","aa"));
//    	System.out.println(isMatch("aaa","aa"));
//    	System.out.println(isMatch("aa", "a*"));
//    	System.out.println(isMatch("aa", ".*"));
//    	System.out.println(isMatch("ab", ".*"));
//    	System.out.println(isMatch("aab", "c*a*b"));
//    	System.out.println(isMatch("", ""));
//    	System.out.println(isMatch("", "."));
    	System.out.println(isMatch("a", ".*..a*"));
    }
}
