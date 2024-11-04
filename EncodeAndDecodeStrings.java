package blind75;

import java.util.*;

public class EncodeAndDecodeStrings {
	public static void main(String[] args) {
		List<String> t1 = Arrays.asList("This is a single long string for testing.");
		
		String e = encode(t1);
		System.out.println(e);
		System.out.println(decode(e));
		
	}
	
	public static String encode(List<String> strings) {
		StringBuilder res = new StringBuilder();
		
		for (String str : strings) {
			res.append(str.length()).append('#').append(str);
		}
		
		return res.toString();
	}
	
	public static List<String> decode(String string) {
		int ind = 0;
		int n = string.length();
		List<String> res = new ArrayList<>();
		
		while (ind < n) {
			int len = 0;
			
			while (string.charAt(ind) >= '0' && string.charAt(ind) <= '9') {
				len = len * 10 + (string.charAt(ind) - '0');
				ind++;
			}
			
			res.add(string.substring(ind + 1, ind + 1 + len));
			ind = ind + 1 + len;
		}
		
		return res;
	}
}
