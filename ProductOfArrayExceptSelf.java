package blind75;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		int[] t1 = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(productExceptSelf(t1)));

		int[] t2 = { -1, 1, 0, -3, 3 };
		System.out.println(Arrays.toString(productExceptSelf(t2)));
	}

	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		int curr = 1;
		
		for (int i = 0; i < n; i++) {
			res[i] = curr;
			curr *= nums[i];
		}
		// 1 1 2 6
		
		curr = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= curr;
			curr *= nums[i];
		}
		
		// 24 12 8 6
		
		return res;
	}
}
