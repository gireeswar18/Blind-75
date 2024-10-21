package blind75;

import java.util.Arrays;

public class MeetingRooms {
	public static void main(String[] args) {
		int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = {{7, 10}, {2, 4}};
        int[][] intervals3 = {{1, 5}, {5, 8}, {8, 10}};
        int[][] intervals4 = {};
        
        System.out.println(canAttend(intervals1)); // Output: false (overlapping intervals)
        System.out.println(canAttend(intervals2)); // Output: true (no overlaps)
        System.out.println(canAttend(intervals3)); // Output: true (end of one meeting equals start of the next)
        System.out.println(canAttend(intervals4)); // Output: true (no meetings)

	}

	public static boolean canAttend(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		
		for (int i = 1; i < intervals.length; i++) {
			
			if (intervals[i - 1][1] > intervals[i][0]) return false;
		}
		
		return true;
	}
}
