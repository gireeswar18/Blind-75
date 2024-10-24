package blind75;

import java.util.*;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] t1 = { 100, 4, 200, 1, 3, 2 };
		int[] t2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };

		System.out.println(longestConsecutive(t1));
		System.out.println(longestConsecutive(t2));
	}

	public static int longestConsecutive(int[] nums) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		int max = 0;

		for (int num : nums) {
			map.put(num, false);
		}

		for (int i = 0; i < nums.length; i++) {

			if (!map.get(nums[i])) {
				int preNum = nums[i] - 1;
				int seq = 1;
				
				while (map.containsKey(preNum) && !map.get(preNum)) {
					seq++;
					map.put(preNum, true);
					preNum--;
				}

				int nextNum = nums[i] + 1;
				
				while (map.containsKey(nextNum) && !map.get(nextNum)) {
					seq++;
					map.put(nextNum, true);
					nextNum++;
				}

				max = Math.max(max, seq);
				
			}
		}

		return max;
	}
}
