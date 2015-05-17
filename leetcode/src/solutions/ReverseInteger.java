package solutions;

public class ReverseInteger {
    public int reverse(int x) {
        int n = x;
        if(n <= 9 && n >= -9) return n;
        
        int sign = n < 0 ? -1 : 1;
        
        n = n * sign;
        int len = Integer.toString(n).length();
        
        long result = 0;
        int i = 0;
        for(; i < len; i++) {
            result += n % 10;
            result *= 10;
            n /= 10;
        }
        
        System.out.println(result);
        
        int r = (int)(result / 10);
        
        System.out.println(r);
        
        //result = result << (31 - i);
        
        return r * sign;
    }
    
    public void test(int num) {
    	reverse(num);
    }
}
