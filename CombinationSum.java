package blind75;

import java.util.*;

public class CombinationSum {
	public static void main(String[] args) {
		int[] t1 = { 2, 3, 6, 7 };
		int[] t2 = { 1 };

		System.out.println(combinationSum(t1, 7));
		System.out.println(combinationSum(t2, 0));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);

		List<List<Integer>> res = new ArrayList<>();
		int ind = 0;
		int currSum = 0;

		makeCombination(candidates, ind, target, currSum, new ArrayList<>(), res);

		return res;

	}

	public static void makeCombination(int[] arr, int ind, int target, int currSum, List<Integer> ds,
			List<List<Integer>> res) {

		if (ind == arr.length) {
			if (currSum == target) {
				res.add(new ArrayList<Integer>(ds));
			}
			return;
		}
		if (currSum == target) {
			res.add(new ArrayList<Integer>(ds));
		}
		if (currSum + arr[ind] > target) return;
		
		ds.add(arr[ind]);
		makeCombination(arr, ind, target, currSum + arr[ind], ds, res);
				
		ds.removeLast();
		makeCombination(arr, ind + 1, target, currSum, ds, res);
	}
}
