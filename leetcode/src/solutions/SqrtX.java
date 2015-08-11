package solutions;

public class SqrtX {
    public int mySqrt(int x) {
        if(x < 0) {
            return 0;
        }
        
        if(x == 0) {
            return 0;
        }
        
        long num = 1;
        while(num * num <= x) {
            num <<= 1;
        }
        num >>= 1;
        
        long lowerBound = num;
        
        while(num > 0 && (lowerBound+1) * (lowerBound+1) <= x) {
            if((lowerBound+num) * (lowerBound+num) <= x){
            	lowerBound += num;
            }

            num >>= 1;
        }

        return (int)lowerBound;
    }
    
    public void test() {
    	System.out.println(mySqrt(2147395600));
    	System.out.println(mySqrt(1));
    	System.out.println(mySqrt(2));
    	System.out.println(mySqrt(4));
    }
}
