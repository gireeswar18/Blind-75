package blind75;

import java.util.*;

public class PacificAtlanticWaterFlow {
	public static void main(String[] args) {
		int[][] t1 = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } };
		System.out.println(pacificAtlantic(t1));
	}
	
	public static void dfs(int row, int col, boolean[][] canReach, int prevHeight, int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		
		if (row < 0 || row == m || col < 0 || col == n || canReach[row][col] || heights[row][col] < prevHeight) {
			return;
		}
		
		canReach[row][col] = true;
		
		dfs(row + 1, col, canReach, heights[row][col], heights);
		dfs(row - 1, col, canReach, heights[row][col], heights);
		dfs(row, col + 1, canReach, heights[row][col], heights);
		dfs(row, col - 1, canReach, heights[row][col], heights);
		
	}

	public static List<List<Integer>> pacificAtlantic(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		
		boolean[][] canReachAltantic = new boolean[m][n];
		boolean[][] canReachPacific = new boolean[m][n];
		
		for (int c = 0; c < n; c++) {
			dfs(0, c, canReachAltantic, heights[0][c], heights);
			dfs(m - 1, c, canReachPacific, heights[m - 1][c], heights);
		}
		
		for (int r = 0; r < m; r++) {
			dfs(r, 0, canReachAltantic, heights[r][0], heights);
			dfs(r, n - 1, canReachPacific, heights[r][n - 1], heights);
		}
		
		List<List<Integer>> res = new ArrayList<>();
		
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				
				if (canReachAltantic[r][c] && canReachPacific[r][c]) {
					res.add(Arrays.asList(r, c));
				}
			}
		}
		
		return res;
	}
}
