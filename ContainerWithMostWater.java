package blind75;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] t1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int[] t2 = { 1, 1 };

		System.out.println(maxArea(t1));
		System.out.println(maxArea(t2));
	}

	public static int maxArea(int[] height) {
		int max = 0;
		int left = 0, right = height.length - 1;
		
		while (left < right) {
			int currHeight = Math.min(height[left], height[right]);
			System.out.println("LEFT: " + left + " RIGHT: " + right);
			System.out.println("CURR HEIGHT: " + currHeight);
			
			max = Math.max(max, (right - left) * currHeight);
			
			while (left < right && height[left] <= currHeight)
				left++;
			while (left < right && height[right] <= currHeight)
				right--;
			
		}
		
		return max;
	}
}
