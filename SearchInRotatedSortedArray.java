package blind75;

public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] t1 = { 4, 5, 6, 7, 0, 1, 2 };
		int[] t2 = { 1 };
		int[] t3 = {1, 3};

		System.out.println(search(t1, 0));
		System.out.println(search(t1, 1));
		System.out.println(search(t1, 2));
		System.out.println(search(t1, 3));
		System.out.println(search(t1, 4));
		System.out.println(search(t1, 5));
		System.out.println(search(t1, 6));
		System.out.println(search(t1, 7));
		System.out.println(search(t2, 0));
		System.out.println(search(t3, 3));
	}

	public static int search(int[] nums, int target) {
		
		int low = 0, high = nums.length - 1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			
			if (nums[mid] == target) {
				return mid;
			}
			else if (nums[low] <= nums[mid]) {
				if (target < nums[mid] && target >= nums[low]) {
					high = mid - 1;
				}
				else {
					low = mid + 1;
				}
			}
			else {
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				}
				else {
					high = mid - 1;
				}
			}
		}
		
		return -1;
	}
}
