package solutions;
import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Integer> list = new ArrayList<Integer>();
    List<Integer> minList = new ArrayList<Integer>();
    
    public MinStack() {
        minList.add(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        if(x <= minList.get(minList.size() - 1)) {
            minList.add(x);
        }
        list.add(x);
    }

    public void pop() {
        int x = list.remove(list.size() - 1);
        if(x == minList.get(minList.size() - 1)) {
            minList.remove(minList.size() - 1);
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minList.get(minList.size() - 1);
    }
    
    public void test() {
    	MinStack stack = new MinStack();
    	stack.push(2147483646);
    	stack.push(2147483646);
    	stack.push(2147483647);
    	stack.top();
    	stack.pop();
    	stack.getMin();
    	stack.pop();
    	stack.getMin();
    	stack.pop();
    	stack.push(2147483647);
    	stack.top();
    	stack.getMin();
    	stack.push(-2147483648);
    	stack.top();
    	stack.getMin();
    	stack.pop();
    	stack.getMin();
    }
}

