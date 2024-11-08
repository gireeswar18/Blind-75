package blind75;

import java.util.*;

public class InsertInterval {
	public static void main(String[] args) {
		int[][] t1 = { { 1, 3 }, { 6, 9 } };
		int[][] t2 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, {12, 16} };

		for (int[] x : insert(t1, new int[] { 12, 15 })) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println();

		for (int[] x : insert(t2, new int[] { 4, 8 })) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println();
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> list = new ArrayList<>();
		
		int ind = 0;
		int n = intervals.length;
		
		// adding before new interval, as there are no overlapping intervals in the test case no need to check for merging
		while (ind < n && newInterval[0] > intervals[ind][1]) {
			list.add(intervals[ind]);
			ind++;
		}
		
		// merging on overlaps between the start of old interval and the end of new interval
		while (ind < n && newInterval[1] >= intervals[ind][0]) {
			newInterval[0] = Math.min(newInterval[0], intervals[ind][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[ind][1]);
			ind++;
		}
		list.add(newInterval);
		
		// adding after insertion of new interval
		while (ind < n) {
			list.add(intervals[ind]);
			ind++;
		}
		
		return list.toArray(new int[list.size()][2]);
	}
	
	
}
