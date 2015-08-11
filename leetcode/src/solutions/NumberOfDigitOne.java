package solutions;

import java.util.ArrayList;
import java.util.List;

public class NumberOfDigitOne {
	public int countDigitOne(int n) {
        int num = n;
		List<Integer> digits = new ArrayList<Integer>();
        while(num > 0) {
        	digits.add(num % 10);
        	num = num / 10;
        }
        
        int base = 1;
        int count = 0;
        
        for(int i = 0; i < digits.size(); i++) {
        	int number = n;
        	int lowerDigits = number % base;
        	int digit = digits.get(i);

            number -= lowerDigits;
            number -= digit * base;
            count += number / 10;
            
        	if(digit == 1) {
        		count += lowerDigits + 1;
        	} else if(digit > 1) {
        		count += base;
        	}
        	
        	base *= 10;
        }
        
        return count;
    }
	
	public void test() {
		System.out.println(countDigitOne(11));
		System.out.println(countDigitOne(1));
		System.out.println(countDigitOne(200));
	}
}
