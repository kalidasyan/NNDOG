package solutions;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        
        int left = 0;
        int right = 0;
        Set<Character> chars = new HashSet<Character>();
        int maxLen = 0;
        
        while(right < s.length()){
        	char c = s.charAt(right);
        	if(chars.contains(c)){
        		while(true){
        			char c1 = s.charAt(left);
        			left++;
        			chars.remove(c1);
        			if(c1 == c){
        				break;
        			}
        		}
        	} else {
        		chars.add(c);
        		right++;
        		int len = right - left;
        		maxLen = maxLen > len ? maxLen : len;
        	}
        }
        
        return maxLen;
    }
    
    public void test(){
    	System.out.println(lengthOfLongestSubstring("abcabcbb"));
    	System.out.println(lengthOfLongestSubstring("bbbbb"));
    	System.out.println(lengthOfLongestSubstring("b"));
    }
}
