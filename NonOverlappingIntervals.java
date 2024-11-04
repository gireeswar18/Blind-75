package blind75;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public static void main(String[] args) {
		int[][] t1 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }; // [1, 2] [1, 3] [2, 3] [3, 4]
		int[][] t2 = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
		int[][] t3 = { { 1, 2 }, { 2, 3 } };

		System.out.println(eraseOverlapIntervals(t1));
		System.out.println(eraseOverlapIntervals(t2));
		System.out.println(eraseOverlapIntervals(t3));

	}

	public static int eraseOverlapIntervals(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

		int cnt = 0;
		int prev = 0;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[prev][1] <= intervals[i][0]) {
				prev = i;
			}
			else {
				cnt++;
			}
		}

		return cnt;
	}
}
