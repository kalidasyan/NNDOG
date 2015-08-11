package solutions;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
    	if(numerator == 0) {
    		return "0";
    	}
    	
    	boolean p1 = true;
    	boolean p2 = true;
    	long n = numerator;
    	long d = denominator;
    	if(n < 0){
    		p1 = false;
    		n = n * -1;
    	}
    	if(d < 0){
    		p2 = false;
    		d = d * -1;
    	}
    	
    	boolean isNegtive = p1 ^ p2;
    	
    	long intPart = n / d;
    	long remaining = n % d;
    	
    	Map<Long, Integer> rs = new HashMap<Long, Integer>();
    	int start = -1;
    	StringBuffer sb = new StringBuffer();
    	
    	while(remaining != 0){
    		if(rs.containsKey(remaining)){
    			start = rs.get(remaining);
    			break;
    		}
    		
    		rs.put(remaining, sb.length());
    		long val = remaining * 10 / d;
    		sb.append(val + "");
    		remaining = remaining * 10 % d;
    	}
    	
    	StringBuffer result = new StringBuffer();
    	if(isNegtive) {
    		result.append('-');
    	}
    	result.append(intPart + "");
    	if(start >= 0) {
    		result.append('.');
    		result.append(sb.substring(0, start));
    		result.append('(');
    		result.append(sb.substring(start));
    		result.append(')');
    	} else if(sb.length() > 0){
    		result.append('.');
    		result.append(sb);
    	}
    	
    	return result.toString();
    }
    
    public void test(){
    	System.out.println(fractionToDecimal(3, 7));
    	System.out.println(fractionToDecimal(1, 2));
    	System.out.println(fractionToDecimal(2, 1));
    	System.out.println(fractionToDecimal(2, 3));
    	System.out.println(fractionToDecimal(16, 5));
    	System.out.println(fractionToDecimal(1, 333));
    	System.out.println(fractionToDecimal(1, 6));
    	System.out.println(fractionToDecimal(-50, 8));
    	System.out.println(0/-5);
    	System.out.println(-0/5);
    	System.out.println(fractionToDecimal(7, -12));
    }
}
