package blind75;

public class LongestRepeatingCharacterReplacement {
	public static void main(String[] args) {
		String t1 = "ABAB";
		System.out.println(characterReplacement(t1, 2));
		
		String t2 = "AABABBA";
		System.out.println(characterReplacement(t2, 1));
	}

	public static int characterReplacement(String s, int k) {
		int l = 0, r = 0;
		int n = s.length();
		int max = 0, maxFreq = 0;
		int[] freq = new int[26];
		char[] str = s.toCharArray();
		
		while (r < n) {
			freq[str[r] - 'A']++;
			maxFreq = Math.max(maxFreq, freq[str[r] - 'A']);
			
			while (r - l + 1 - maxFreq > k) {
				freq[str[l] - 'A']--;
				l++;
			}
			
			max = Math.max(max, r - l + 1);
			r++;
		}
		
		return max;
	}
}
