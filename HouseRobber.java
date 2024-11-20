package blind75;

public class HouseRobber {
	public static void main(String[] args) {
		int[] t1 = { 1, 2, 3, 1 };
		System.out.println(rob(t1));

		int[] t2 = { 2, 7, 9, 3, 1 };
		System.out.println(rob(t2));

		int[] t3 = { 2, 1, 1, 2 };
		System.out.println(rob(t3));
	}

	public static int rob(int[] nums) {
		int[] dp = new int[nums.length + 1];
		
		dp[1] = nums[0];
		
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
		}
		
		return dp[nums.length];
	}
}
