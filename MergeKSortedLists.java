package blind75;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	public ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		
		while (a != null && b != null) {
			if (a.val < b.val) {
				temp.next = a;
				a = a.next;
			}
			else {
				temp.next = b;
				b = b.next;
			}
			temp = temp.next;
		}
		
		if (a != null) {
			temp.next = a;
		}
		if (b != null) {
			temp.next = b;
		}
		
		return dummy.next;
		
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) return null;
		
		ListNode prev = lists[0];
		
		for (int i = 1; i < lists.length; i++) {
			prev = merge(prev, lists[i]);
		}
		
		return prev;
	}
	
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists.length == 0) return null;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for (ListNode head : lists) {
			while (head != null) {
				minHeap.add(head.val);
				head = head.next;
			}
		}
		
		ListNode dummy = new ListNode();
		ListNode curr = dummy;
		
		while (!minHeap.isEmpty()) {
			curr.next = new ListNode(minHeap.poll());
			curr = curr.next;
		}
		
		return dummy.next;
		
	}
}







