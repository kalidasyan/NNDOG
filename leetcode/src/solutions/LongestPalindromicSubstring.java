package solutions;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0) {
            return s;
        }
        
        boolean[][] pTable = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            pTable[i][i] = true;
        }
        
        int longest = 1;
        int start = 0;
        int end = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if(j == i+1) {
                    pTable[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    pTable[i][j] = (s.charAt(i) == s.charAt(j) && pTable[i+1][j-1]);
                }
                
                if(pTable[i][j] && longest < j - i + 1) {
                    longest = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        
        return s.substring(start, end+1);
    }
    
    public void test(){
    	String s = "aaaabaaa";
    	System.out.println(longestPalindrome(s));
    }
}
