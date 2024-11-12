package blind75;

public class FindMinimumInRotatedSortedArray {
	public static void main(String[] args) {
		int[] t1 = { 3, 4, 5, 1, 2 };
		int[] t2 = { 4, 5, 6, 7, 0, 1, 2 };
		int[] t3 = { 11, 13, 15, 17 };

		System.out.println(findMin(t1));
		System.out.println(findMin(t2));
		System.out.println(findMin(t3));
	}

	public static int findMin(int[] nums) {
		int st = 0, end = nums.length - 1;
		
		while (st < end) {
			int mid = (st + end) / 2;
			
			if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) return nums[mid];
			
			if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) return nums[mid + 1];

			if (nums[mid] < nums[end]) {
				end = mid - 1;
			}
			else {
				st = mid + 1;
			}
		}
		
		return nums[0];
	}
}
