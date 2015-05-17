package solutions;

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	System.out.println(n);
        int w = n < 0 ? 1 : (n % 2==0 ? 0 : 1);
        
        n = n >> 1;
        System.out.println(n);
        
        while(n != 0) {
            w += n%2;
            n = n/2;
        }
        return w;
    }
    
    public void test(int num) {
    	hammingWeight(num);
    }
}
