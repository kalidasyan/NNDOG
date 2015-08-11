package solutions;


public class PalindromePartitioningII {
	public int minCut(String s) {
		int minCut = s.length() - 1;
		int len = s.length();
		if (len == 0) {
			return minCut;
		}

		boolean[][] pTable = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			pTable[i][i] = true;
		}

		buildPalindromeTable(s, pTable);

		int[] minCuts = new int[len];
		minCuts[0] = 0;
		
		for (int i = 1; i < len; i++) {
			if(pTable[0][i]){
				minCuts[i] = 0;
			} else {
				int numCut = minCuts[i-1] + 1;
				for(int j = 1; j < i; j++) {
					if(pTable[j][i] && minCuts[j-1] + 1 < numCut){
						numCut = minCuts[j-1] + 1;
					}
				}
				minCuts[i] = numCut;
			}
		}

		return minCuts[len-1];
	}

	private void buildPalindromeTable(String s, boolean[][] pTable) {
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i + 1; j < s.length(); j++) {
				if (j == i + 1) {
					pTable[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					pTable[i][j] = (s.charAt(i) == s.charAt(j) && pTable[i + 1][j - 1]);
				}
			}
		}
	}

	public void test() {
		//String s = "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
		String s = "cdd";
//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "bbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		
		System.out.println(minCut(s));
	}
}
