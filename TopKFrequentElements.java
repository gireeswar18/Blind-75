package blind75;

import java.util.*;

public class TopKFrequentElements {
	public static void main(String[] args) {
		int[] t1 = { 3, 1, 0, 1 };
		System.out.println(Arrays.toString(topKFrequent(t1, 1)));
		int[] t2 = { 1, 1, 1, 2, 2, 3 };
		System.out.println(Arrays.toString(topKFrequent(t2, 2)));
	}

	public static int[] topKFrequent(int[] nums, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
		int[] res = new int[k];
		
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		for (int num : map.keySet()) {
			pq.add(num);
		}
		
		for (int i = 0; i < k; i++) {
			res[i] = pq.poll();
		}
		
		return res;
	}
}
