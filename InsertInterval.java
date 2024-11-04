package blind75;

import java.util.*;

public class InsertInterval {
	public static void main(String[] args) {
		int[][] t1 = { { 1, 3 }, { 6, 9 } };
		int[][] t2 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, {12, 16} };

		for (int[] x : insert(t1, new int[] { 2, 5 })) {
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
		boolean isAdded = false;
		
		for (int[] interval : intervals) {
			if (!isAdded && interval[0] > newInterval[0]) {
				list.add(newInterval);
			}
			list.add(interval);
		}
		
		if (!isAdded) {
			list.add(newInterval);
		}
		
		return merge(list);
	}
	
	public static int[][] merge(List<int[]> intervals) {

		List<int[]> list = new ArrayList<>();

		int[] prev = intervals.get(0);

		for (int i = 1; i < intervals.size(); i++) {
            int[] curr = intervals.get(i);
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
