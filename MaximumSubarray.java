package blind75;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] t1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] t2 = { 1 };
		int[] t3 = { 5, 4, -1, 7, 8 };

		System.out.println(maxSubArray(t1));
		System.out.println(maxSubArray(t2));
		System.out.println(maxSubArray(t3));
	}

	public static int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		
		int sum = 0;
		for (int num : nums) {
			sum += num;
			
            max = sum > max ? sum : max;

			if (sum < 0) sum = 0;
		}
		
		return max;
	}
}
