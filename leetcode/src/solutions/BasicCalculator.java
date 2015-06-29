package solutions;

import java.util.HashMap;
import java.util.Stack;

public class BasicCalculator {
    static private HashMap<Character, Integer> priorities = new HashMap<Character, Integer>();
    static {
        priorities.put('+', 1);
        priorities.put('-', 1);
        priorities.put('*', 2);
        priorities.put('/', 2);
    }
    
    public int calculate(String s) {
        Stack<Long> numbers = new Stack<Long>();
        Stack<Character> stack = new Stack<Character>();
        
        //http://www.cnblogs.com/zghaobac/p/3394705.html
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') continue;
            
            if(isNumber(c)) {
            	int start = i++;
            	while(i < s.length() && isNumber(s.charAt(i))) {
            		i++;
            	}
            	String number = s.substring(start, i);
                numbers.push(Long.parseLong(number));
                if(i != s.length()) i--;
            } else if (stack.isEmpty()) {
            	stack.push(c);
            } else if(c == '(') {
                stack.push('(');
            } else if (c == ')') {
                while(stack.peek() != '('){
                	calculate(stack.pop(), numbers);
                }
                stack.pop();
            } else {
                int p = priorities.get(c);
                if (priorities.get(stack.peek()) == null) {
                	stack.push(c);
                } else if (p > priorities.get(stack.peek())) {
                    stack.push(c);
                } else {
                    while(!stack.isEmpty() && priorities.get(stack.peek()) != null && p <= priorities.get(stack.peek())) {
                    	calculate(stack.pop(), numbers);
                    }
                    stack.push(c);
                }
            }
        }
        
        while(!stack.isEmpty()) {
        	calculate(stack.pop(), numbers);
        }
        
        return numbers.pop().intValue();
    }
    
    private boolean isNumber(char c) {
    	return (c >= '0' && c <= '9');
    }
    
    private void calculate(Character operand, Stack<Long> numbers) {
    	long op2 = numbers.pop();
		long op1 = numbers.pop();
		switch(operand) {
		case '+' : numbers.push(op1 + op2); break;
		case '-' : numbers.push(op1 - op2); break;
		case '*' : numbers.push(op1 * op2); break;
		case '/' : numbers.push(op1 / op2); break;
		}
	}

	public void test(){
    	System.out.println(calculate("(1+(4+5)*3)"));
    	System.out.println(calculate("2147483647"));
    }
}
