package blind75;

public class UniquePaths {
	public static void main(String[] args) {
		int m1 = 3, n1 = 7;
		int m2 = 3, n2 = 2;
		
		System.out.println(uniquePaths(m1, n1));
		System.out.println(uniquePaths(m2, n2));
	}

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		
		return dp[m - 1][n - 1];
	}
}
