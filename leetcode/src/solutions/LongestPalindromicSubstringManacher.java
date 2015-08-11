package solutions;

public class LongestPalindromicSubstringManacher {
	
	private static final char SHARP = '#';
	public String longestPalindrome(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		
		int len = s.length();
		char[] array = new char[2 * len + 1];
		int[] p = new int[2 * len + 1];
		array[2 * len] = SHARP;
		p[0] = 1;
		
		//Add len + 1 of '#'
		for(int i = 0; i < len; i++) {
			array[2*i] = SHARP;
			array[2*i + 1] = s.charAt(i);
		}
		
		int index = 0;
		int maxLen = 1;
		int pivot = 0;
		for(int i = 1; i < 2 * len + 1; i++) {
			if(p[index] + index > i){
				p[i] = Math.min(p[2 * index - i], p[index] - (i - index));
			} else {
				p[i] = 1;
			}
			
			while(i >= p[i] && i + p[i] <= 2 * len && array[i + p[i]] == array[i - p[i]]) ++p[i];
			
			if(p[i] + i > p[index] + index){
				index = i;
			}
			
			if(maxLen < p[i]) {
				maxLen = p[i];
				pivot = i;
			}
		}
		
		int center = pivot / 2;
		int semid = maxLen / 2;
		int start = 0;
		if(array[pivot] == '#') {
			start = center - semid;
		} else {
			start = center - semid + 1;
		}
		
		return s.substring(start, maxLen + start - 1);
	}
	
    public void test(){
    	String s = "aaaabaaa";
    	System.out.println(longestPalindrome(s));
    }
}
