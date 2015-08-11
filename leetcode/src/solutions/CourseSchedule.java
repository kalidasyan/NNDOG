package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int numEdges = prerequisites.length;
		if (numEdges == 0)
			return true;

		List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
		List<Set<Integer>> preNums = new ArrayList<Set<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new HashSet<Integer>());
			preNums.add(new HashSet<Integer>());
		}

		for (int i = 0; i < numEdges; i++) {
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
		
		return visited.size() == numCourses;
		
	}

	public void test() {
		int numCourses = 10;
		int[][] prerequisites = new int[][] { {5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9} }; //10, [[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]]
		System.out.println(canFinish(numCourses, prerequisites));
	}
}
