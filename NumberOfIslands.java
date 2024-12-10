package blind75;

public class NumberOfIslands {
	
	public static void main(String[] args) {
		char[][] t1 = {
			    {'1', '1', '1', '1', '0'},
			    {'1', '1', '0', '1', '0'},
			    {'1', '1', '0', '0', '0'},
			    {'0', '0', '0', '0', '1'}
			};
		
		System.out.println(numIslands(t1));
	}
	
	public static void bfs(int i, int j, char[][] grid, boolean[][] visited) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; 
		
		visited[i][j] = true;
		
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			
			if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1' && !visited[x][y]) {
				bfs(x, y, grid, visited);
			}
		}
	}
	
	public static int numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		boolean[][] visited = new boolean[m][n];
		int cnt = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					bfs(i, j, grid, visited);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}
