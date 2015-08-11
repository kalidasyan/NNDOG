package solutions;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> result = new ArrayList<Interval>();
    	if(intervals == null || newInterval == null) {
    		return null;
    	}
    	
    	if(intervals.size() == 0) {
    		result.add(newInterval);
    		return result;
    	}
    	
    	for(int i = 0; i < intervals.size(); i++) {
    		Interval interval = intervals.get(i);
    		if(interval.start > newInterval.end){
    			result.add(newInterval);
    			for(int j = i; j < intervals.size(); j++) {
    				result.add(intervals.get(j));
    			}
    			return result;
    		} else if(interval.end < newInterval.start) {
    			result.add(interval);
    		} else {
    			//If two intervals overlap, merge and move on.
    			newInterval.start = Math.min(interval.start, newInterval.start);
    			newInterval.end = Math.max(interval.end, newInterval.end);
    		}
    	}
    	
    	result.add(newInterval);
    	return result;
    }
    
    public void test() {
    	List<Interval> intervals = new ArrayList<Interval>();
    	Interval i1 = new Interval(1,2);
    	Interval i2 = new Interval(3,5);
    	Interval i3 = new Interval(6,7);
    	Interval i4 = new Interval(8,10);
    	Interval i5 = new Interval(12,16);
    	intervals.add(i1);
    	intervals.add(i2);
    	intervals.add(i3);
    	intervals.add(i4);
    	intervals.add(i5);
    	Interval newInterval = new Interval(4,9);
    	List<Interval> result = this.insert(intervals, newInterval);
    	for(Interval in : result) {
    		System.out.print(in + "  ");
    	}
    	System.out.println();
    }
}
