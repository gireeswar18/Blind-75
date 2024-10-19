package blind75;

import java.util.*;

public class ContainsDuplicate {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1 };

		System.out.println(containsDuplicate(arr));
	}

	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (!set.add(num)) {
				return true;
			}
		}
		
		return false;
	}
}
