package blind75;

public class JumpGame {
	public static void main(String[] args) {
		int[] t1 = { 2, 3, 1, 1, 4 };
		int[] t2 = { 3, 2, 1, 0, 4 };
		int[] t3 = { 1, 1, 2, 2, 0, 1, 1 };
		int[] t4 = { 2, 5, 0, 0 };

		System.out.println(canJump(t1));
		System.out.println(canJump(t2));
		System.out.println(canJump(t3));
		System.out.println(canJump(t4));
	}

	public static boolean canJump(int[] nums) {

		int max = 0;
		int n = nums.length - 1;

		for (int i = 0; i < n; i++) {
			if (i > max) {
				return false;
			}

			max = Math.max(max, i + nums[i]);

			if (max >= n)
				return true;
		}

		return max >= n;
	}
}
