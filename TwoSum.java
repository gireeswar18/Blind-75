package blind75;

import java.util.*;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}

	public static int[] twoSum(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(target - arr[i])) {
				return new int[] {map.get(target - arr[i]), i};
			}
			map.put(arr[i], i);
		}
		
		return null;
	}
}
