package blind75;

public class HouseRobber_II {
	public static void main(String[] args) {
		int[] t1 = { 1, 2, 3, 1 };
		System.out.println(rob(t1));
		
		int[] t2 = {2, 3, 2};
		System.out.println(rob(t2));
		
		int[] t3 = { 1, 2, 3 };
		System.out.println(rob(t3));
	}
	
	public static int rob(int[] nums) {
		int n = nums.length;
		
		if (n == 1) return nums[0];
		
		if (n == 2) return Math.max(nums[0], nums[1]);
		
		return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
	}

	public static int rob(int[] arr, int st, int end) {
		int[] dp = new int[arr.length];
		
		dp[1] = arr[st];
		int dpInd = 2;
		
		for (int arrInd = st + 1; arrInd <= end; arrInd++) {
			dp[dpInd] = Math.max(dp[dpInd - 1], arr[arrInd] + dp[dpInd - 2]);
			dpInd++;
		}
		
		return dp[arr.length - 1];
	}
}
