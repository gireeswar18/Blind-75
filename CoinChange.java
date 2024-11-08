package blind75;

public class CoinChange {
	public static void main(String[] args) {
		int[] t1 = { 1, 2, 5 };
		int[] t2 = { 2 };
		int[] t3 = { 1 };

		System.out.println(coinChange(t1, 11));
		System.out.println(coinChange(t2, 3));
		System.out.println(coinChange(t3, 0));

	}

	public static int coinChange(int[] coins, int amount) {
		
		// 2D
//		if (amount == 0) return 0;
//		
//		int m = coins.length;
//		
//		int[][] dp = new int[m + 1][amount + 1];
//		
//		for (int i = 0; i < amount + 1; i++) {
//			dp[0][i] = amount + 1;
//		}
//		
//		for (int i = 1; i < m + 1; i++) {
//			for (int j = 1; j < amount + 1; j++) {
//				if (coins[i - 1] > j) {
//					dp[i][j] = dp[i - 1][j];
//				}
//				else {
//					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
//				}
//			}
//		}
//		
//		return dp[m][amount] > amount ? -1 : dp[m][amount];
		
		// 1D
		int[] dp = new int[amount + 1];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = amount + 1;
		}
		
		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];
			for (int j = coin; j < dp.length; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin] + 1);
			}
		}
		
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
