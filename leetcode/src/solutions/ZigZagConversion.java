package solutions;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
        	return s;
        }
        
    	int len = s.length();
        int step = 2 * numRows - 2;
        
        StringBuffer sb = new StringBuffer();
        
        //first row
        for(int k = 0; k < len; k += step) {
            sb.append(s.charAt(k));
        }
        
        //second to last-1 row
        for(int row = 2; row < numRows; row++) {
            int ka = row - 1;
            int kb = 2 * numRows - row - 1;
            for(; kb < len; ka += step, kb += step) {
                sb.append(s.charAt(ka)).append(s.charAt(kb));
            }
            if(ka < len) {
                sb.append(s.charAt(ka));
            }
        }
        
        //last row
        for(int k = numRows - 1; k < len; k += step) {
            sb.append(s.charAt(k));
        }
        
        return sb.toString();
    }
    
    public void test(String s, int numRows) {
    	System.out.println(convert(s, numRows));
    }
}
