package solutions;

public class BitwiseANDNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == n) return m;
        
        int base = 1;
        int result = 0;
        int upper = getUpperBound(m);
        if(n > upper) return 0;
        
        while(m > 0) {
            int i = m;
            for(; i <= n && i > 0; i++) {
                if(i % 2 == 0) break;
            }
            if(i == n + 1){
                result += base;
            }
            m /= 2;
            n /= 2;
            base *= 2;
        }
        
        return result;
    }
    
    private int getUpperBound(int m) {
        int base = 1;
        int result = m;
        while(m > 0) {
            if(m % 2 == 0){
                result += base;
            }
            m /= 2;
            base *= 2;
        }
        System.out.println(result);
        
        return result;
    }

	public void test() {
		System.out.println(rangeBitwiseAnd(5,6));
	}
}
