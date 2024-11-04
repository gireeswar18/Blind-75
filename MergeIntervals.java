package blind75;

import java.util.*;

public class MergeIntervals {
	public static void main(String[] args) {
		int[][] t1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] t2 = { { 1, 4 }, { 4, 5 } };
		int[][] t3 = { { 2, 3 }, { 2, 2 }, { 3, 3 }, { 1, 3 }, { 5, 7 }, { 2, 2 }, { 4, 6 } };

		for (int[] x : merge(t1)) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println();
		for (int[] x : merge(t2)) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println();
		for (int[] x : merge(t3)) {
			System.out.println(Arrays.toString(x));
		}
	}

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		List<int[]> list = new ArrayList<>();

		int[] prev = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
			if (prev[1] >= curr[0]) {
				prev[1] = Math.max(prev[1], curr[1]);
			} 
			else {
				list.add(prev);
				prev = curr;
			}
		}
		
		list.add(prev);

		return list.toArray(new int[0][]);
	}
}
