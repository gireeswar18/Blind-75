package blind75;

public class MissingNumber {
	public static void main(String[] args) {
		int[] arr = {2, 0, 1};
		
		System.out.println(missingNumber(arr));
	}

	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int total = (n * (n + 1)) / 2;
		
		for (int num : nums) {
			total -= num;
		}
		
		return total;
	}
}
