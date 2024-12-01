package blind75;

public class DecodeWays {
	public static void main(String[] args) {
		String t1 = "12";
		System.out.println(numDecodings(t1));

		String t2 = "226";
		System.out.println(numDecodings(t2));

		String t3 = "06";
		System.out.println(numDecodings(t3));

		String t4 = "5";
		System.out.println(numDecodings(t4));
	}

	public static int numDecodings(String s) {
		int n = s.length();
		int[] dp = new int[n + 1];
		
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		
		if (dp[1] == 0) return 0;
		
		for (int i = 2; i < n + 1; i++) {
			int oneDigit = Integer.valueOf(s.substring(i - 1, i));
			int twoDigit = Integer.valueOf(s.substring(i - 2, i));
			
			if (oneDigit >= 1) {
				dp[i] += dp[i - 1];
			}
			if (twoDigit >= 10 && twoDigit <= 26) {
				dp[i] += dp[i - 2];
			}
		}
				
		return dp[n];
	}
}
