package blind75;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		int[] t1 = {2, 3, -2, 4};
		int[] t2 = {-2, 0, -1};
		int[] t3 = {-2};
		
		System.out.println(maxProduct(t1));
		System.out.println(maxProduct(t2));
		System.out.println(maxProduct(t3));
	}
	
	public static int maxProduct(int[] nums) {
       int res = nums[0];
       int min = res;
       int max = res;
       
       for (int i = 1; i < nums.length; i++) {
    	   if (nums[i] < 0) {
    		   int temp = min;
    		   min = max;
    		   max = temp;
    	   }
    	   
    	   min = Math.min(nums[i], min * nums[i]);
    	   max = Math.max(nums[i], max * nums[i]);
    	   
    	   res = Math.max(res, max);
       }
       
       return res;
    }
}
