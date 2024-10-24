package blind75;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String t1 = "babad";
		String t2 = "rxihafahj";
		
		System.out.println(longestPalindrome(t1));
		System.out.println(longestPalindrome(t2));
	}

	public static String longestPalindrome(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		char[] str = s.toCharArray();
		
		int maxLen = 1;
		int st = 0;
		
		for (int subLen = 1; subLen <= n; subLen++) {
			for (int j = 0; j <= n - subLen; j++) {
				if (subLen == 1) {
					dp[j][j] = 1;
				}
				else if (subLen == 2 && str[j] == str[j + 1]) {
					dp[j][j + 1] = 2;
					maxLen = 2;
					st = j;
				}
				else if (str[j] == str[j + subLen - 1] && dp[j + 1][j + subLen - 2] != 0) {
					dp[j][j + subLen - 1] = subLen;
					if (subLen > maxLen) {
						maxLen = subLen;
						st = j;
					}
				}
			}
		}
		
		return s.substring(st, st + maxLen);
	}
}
