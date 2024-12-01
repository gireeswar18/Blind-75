package blind75;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] t1 = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(t1));

		int[] t2 = { 0, 1, 0, 3, 2, 3 };
		System.out.println(lengthOfLIS(t2));

		int[] t3 = { 7, 7, 7, 7, 7, 7, 7 };
		System.out.println(lengthOfLIS(t3));
	}

	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		
		dp[0] = 1;
		
		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			
			dp[i] = max + 1;
		}
		
		int res = 1;
		
		for (int num : dp)
			res = Math.max(res, num);
		
		return res;
	}
}
