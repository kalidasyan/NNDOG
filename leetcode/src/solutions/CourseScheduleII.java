package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
		List<Set<Integer>> preNums = new ArrayList<Set<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new HashSet<Integer>());
			preNums.add(new HashSet<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int[] edge = prerequisites[i];
			preNums.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		List<Integer> visiting = new ArrayList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (preNums.get(i).isEmpty()) {
				visiting.add(i);
			}
		}

		List<Integer> visited = new ArrayList<Integer>();
		while (!visiting.isEmpty()) {
			int node = visiting.remove(visiting.size() - 1);

			Set<Integer> dependents = graph.get(node);
			for (Integer dependent : dependents) {
				preNums.get(dependent).remove(node);
				if (preNums.get(dependent).isEmpty()) {
					visiting.add(dependent);
				}
			}
			visited.add(node);
		}

		if (visited.size() == numCourses) {
			int[] orders = new int[numCourses];
			for (int i = 0; i < numCourses; i++) {
				orders[i] = visited.get(i);
			}
			return orders;
		} else {
			return new int[0];
		}
	}
}
