package solutions;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        
        if(dividend == 0) {
            return 0;
        }
        
        boolean b1 = false;
        long d1 = dividend;
        if(dividend < 0)
        {
            b1 = true;
            d1 = d1 * -1;
        }
        
        boolean b2 = false;
        long d2 = divisor;
        if(divisor < 0){
            b2 = true;
            d2 = d2 * -1;
        }
        
        boolean isNegtive = b1 ^ b2;
        
        long q = 1;
        long d2tmp = d2;
        while(d1 >= d2tmp) {
            d2tmp = d2tmp << 1;
            q = q << 1;
        }
        q >>= 1;
        d2tmp >>= 1;
        
        long quotient = 0;
        while(d1 >= d2) {
        	if(d1 >= d2tmp){
        		quotient += q;
        		d1 -= d2tmp;
        	}
            q >>= 1;
            d2tmp >>= 1;
        }

        
        if(isNegtive) {
            quotient = quotient * -1;
        }
        
        return (int)quotient;
    }
    
    public void test(){
//    	System.out.println(divide(1, 1));
    	System.out.println(divide(10, 3));
    }
}
