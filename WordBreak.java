package blind75;

import java.util.*;

public class WordBreak {
	public static void main(String[] args) {
		String t1 = "leetcode";
		List<String> dict1 = List.of("leet", "code");
		
		String t2 = "applepenapple";
		List<String> dict2 = List.of("applen", "pen");
		
		String t3 = "applepenapple";
		List<String> dict3 = List.of("cats","dog","sand","and","cat");
		
		System.out.println(wordBreak(t1, dict1));
		System.out.println(wordBreak(t2, dict2));
		System.out.println(wordBreak(t3, dict3));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[n] = true;
		
		for (int i = n - 1; i >= 0; i--) {
			for (String word : wordDict) {
				int size = word.length();
				if (i + size <= n && s.substring(i, i + size).equals(word)) {
					dp[i] = dp[i + size];
				}
				if (dp[i]) break;
			}
		}
		return dp[0];
	}
}
