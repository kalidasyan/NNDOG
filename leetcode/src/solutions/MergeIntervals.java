package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() <= 1) {
        	return intervals;
        }
        
        Collections.sort(intervals, new Cmp());
        
        Interval currentIn = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
        	Interval in = intervals.get(i);
        	if(currentIn.end < in.start){
        		result.add(new Interval(currentIn.start, currentIn.end));
        		currentIn = in;
        	} else {
        		currentIn.start = Math.min(currentIn.start, in.start);
        		currentIn.end = Math.max(currentIn.end, in.end);
        	}
        }
        result.add(currentIn);
        
        return result;
    }
    
    private class Cmp implements Comparator<Interval> {
    	@Override
    	public int compare(Interval i1, Interval i2) {
    		if(i1.start < i2.start) {
    			return -1;
    		} else if (i1.start > i2.start){
    			return 1;
    		} else {
    			if(i1.end < i2.end){
    				return -1;
    			} else if(i1.end > i2.end) {
    				return 1;
    			} else {
    				return 0;
    			}
    		}
    	}
    }
    
    public void test() {
    	List<Interval> intervals = new ArrayList<Interval>();
    	Interval i1 = new Interval(1,3);
    	Interval i2 = new Interval(2,6);
    	Interval i3 = new Interval(8,10);
    	Interval i4 = new Interval(15,18);
    	intervals.add(i1);
    	intervals.add(i2);
    	intervals.add(i3);
    	intervals.add(i4);
    	List<Interval> result = this.merge(intervals);
    	for(Interval in : result) {
    		System.out.print(in + "  ");
    	}
    	System.out.println();
    }
}
