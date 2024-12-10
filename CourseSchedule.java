package blind75;

import java.util.*;

public class CourseSchedule {
	public static void main(String[] args) {
		int[][] t1 = { { 1, 0 } };
		System.out.println(canFinish(2, t1));

		int[][] t2 = { { 1, 0 }, { 0, 1 } };
		System.out.println(canFinish(2, t2));
	}
	
	public static boolean dfs(boolean[] visited, int curr, List<List<Integer>> adjList) {
		if (visited[curr]) return false;
		
		visited[curr] = true;
		
		for (int v : adjList.get(curr)) {
			if (!dfs(visited, v, adjList))
				return false;
		}
		
		visited[curr] = false;
		adjList.set(curr, new ArrayList<Integer>());
		
		return true;
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean[] visited = new boolean[numCourses];
		
		List<List<Integer>> adjList = new ArrayList<>();
		
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for (int[] pre : prerequisites) {
			adjList.get(pre[0]).add(pre[1]);
		}
		
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(visited, i, adjList)) {
				return false;
			}
		}
		return true;
	}
}
