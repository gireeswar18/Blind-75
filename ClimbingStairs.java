package blind75;

public class ClimbingStairs {
	public static void main(String[] args) {
		int n = 1;
		
		System.out.println(climbStairs(n));
	}

	public static int climbStairs(int n) {
//		if (n == 1) return n;
		
		int a = 1;
		int b = 1;
		
		for (int i = 2; i <= n; i++) {
			int t = b;
			b = a + b;
			a = t;
		}
		
		return b;
	}
}
