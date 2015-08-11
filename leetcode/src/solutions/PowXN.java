package solutions;

import java.util.ArrayList;
import java.util.List;

public class PowXN {
    public double myPow(double x, int n) {
    	if(n == 0) {
    		return 1;
    	}
    	
    	if(x == 0){
    		return 0;
    	}
    	
    	boolean negtiveN = false;
    	if(n < 0) {
    		negtiveN = true;
    		n *= -1;
    	}
    	
    	boolean isNegtive = false;
    	if(x < 0) {
    		isNegtive = (n % 2 == 1);
    		x = x * -1;
    	}
    	
        List<Double> pows = new ArrayList<Double>();
        
        double val = x;
        long count = 1;
        int numPow = 0;
        while(count <= n) {
        	pows.add(val);
        	count <<= 1;
        	numPow++;
        	val *= val;
        }
        
        numPow--;
        count >>= 1;
        	
        double result = 1.0;
        while(n > 0){
        	if(n >= count) {
        		result *= pows.get(numPow);
        		n -= count;
        	}
        	numPow--;
        	count >>= 1;
        }
        
        if(negtiveN) {
        	result = 1 / result;
        }
        
        if(isNegtive){
        	result *= -1;
        }
        
        return result;
    }
    
    public void test(){
    	System.out.println(myPow(-2,-1));
    	System.out.println(myPow(-2,-2));
    	System.out.println(myPow(-2,-3));
    	System.out.println(myPow(-2,-4));
    	System.out.println(myPow(-2,-5));
    }
}
