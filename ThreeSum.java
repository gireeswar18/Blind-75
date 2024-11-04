package blind75;

import java.util.*;

public class ThreeSum {
	public static void main(String[] args) {
		int[] t1 = { -1, 0, 1, 2, -1, -4 }; // [[-1,-1,2],[-1,0,1]]
		int[] t2 = { 0, 1, 1 }; // []
		int[] t3 = { 0, 0, 0, 0 }; // [[0, 0, 0]]

		System.out.println(threeSum(t1));
		System.out.println(threeSum(t2));
		System.out.println(threeSum(t3));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);

		int n = nums.length, j, k, sum;
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < n - 2; i++) {
			int curr = nums[i];

			if (i != 0 && curr == nums[i - 1])
				continue;

			j = i + 1;
			k = n - 1;

			while (j < k) {
				sum = curr + nums[j] + nums[k];
				if (sum < 0) {
					j++;
					continue;
				} else if (sum > 0) {
					k--;
					continue;
				}

				res.add(new ArrayList<>(List.of(curr, nums[j], nums[k])));
				j++;
				k--;
				while (j < k && nums[j] == nums[j - 1]) {
					j++;
				}
			}
		}

		return res;
	}
}
