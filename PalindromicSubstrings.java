package blind75;

public class PalindromicSubstrings {
	public static void main(String[] args) {
		String t1 = "abc";
		String t2 = "aaa";
		
		System.out.println(countSubstrings(t1));
		System.out.println(countSubstrings(t2));
	}

	public static int countSubstrings(String s) {
		char[] str = s.toCharArray();
		int n = str.length;
		boolean[][] dp = new boolean[n][n];
		int count = 0;
		
		for (int subLen = 1; subLen <= n; subLen++) {
			for (int j = 0; j <= n - subLen; j++) {
				if (subLen == 1) {
					dp[j][j] = true;
					count++;
				}
				else if (subLen == 2 && str[j] == str[j + 1]) {
					count++;
					dp[j][j + 1] = true;
				}
				else if (str[j] == str[j + subLen - 1] && dp[j + 1][j + subLen - 2]) {
					count++;
					dp[j][j + subLen - 1] = true;
				}
			}
		}
		
		return count;
	}
}
