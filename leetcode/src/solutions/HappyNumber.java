package solutions;
import java.util.HashSet;
import java.util.Set;


public class HappyNumber {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        
        Set<Integer> cycle = new HashSet<Integer>();

        while(true) {
            cycle.add(n);
            int result = 0;
            while(n > 0) {
            	int digit = n % 10;
                result += digit * digit;
                n = n / 10;
            }
            System.out.println(result);
            
            if(result == 1) {
                return true;
            }
            
            if(cycle.contains(result)) {
                return false;
            }
            n = result;
        }
    }
    
    public void test(int num) {
    	isHappy(num);
    }

    
}
