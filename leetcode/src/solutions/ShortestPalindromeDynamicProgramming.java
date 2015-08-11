package solutions;

public class ShortestPalindromeDynamicProgramming {
    public String shortestPalindrome(String s) {
        int len = s.length();
        if(len == 0) {
            return s;
        }
        
        boolean[][] pTable = new boolean[2][len];
        pTable[1][len-1] = true;
        int row = len-2;
        
        for(int i = len - 2; i >= 0; i--, row--) {
            pTable[i-row][i] = true;
            
            for(int j = i + 1; j < len; j++) {
                if(j == i+1) {
                    pTable[i-row][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    pTable[i-row][j] = (s.charAt(i) == s.charAt(j) && pTable[i+1-row][j-1]);
                }
            }
            
            for(int j = i + 1; j < len; j++) {
                pTable[i+1-row] = pTable[i-row];
            }
        }
        
        int i = len - 1;
        for(;i >= 0; i--){
            if(pTable[0][i]) break;
        }
        StringBuffer sb = new StringBuffer();
        for(int j = len - 1; j > i; j--) {
            sb.append(s.charAt(j));
        }
        
        return sb.append(s).toString();
    }
}
