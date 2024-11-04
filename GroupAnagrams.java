package blind75;

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] t1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
		String[] t2 = { "" };
		String[] t3 = { "a" };

		System.out.println(groupAnagrams(t1));
		System.out.println(groupAnagrams(t2));
		System.out.println(groupAnagrams(t3));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);

			String sortedStr = String.valueOf(arr);

			List<String> list;
			if (map.containsKey(sortedStr)) {
				list = map.get(sortedStr);
			}
			else {
				list = new ArrayList<>();
			}
			list.add(str);
			map.put(sortedStr, list);
		}
		
		List<List<String>> res = new ArrayList<>();
		
		for (List<String> list : map.values()) {
			res.add(list);
		}
		
		return res;
	}
}
