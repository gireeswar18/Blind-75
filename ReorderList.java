package blind75;

public class ReorderList {
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

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) return;
		
		// find mid
		ListNode slow = head, fast = head, beforeMid = null;
		while (fast != null && fast.next != null) {
			beforeMid = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		// reverse
		beforeMid.next = null;
		ListNode before = null, curr = slow, after;
		while (curr != null) {
			after = curr.next;
			curr.next = before;
			before = curr;
			curr = after;
		}
		// make connections
		ListNode first = head, second = before, temp1, temp2, prev = null;
		while (first != null && second != null) {
			if (first != null && first.next == null) {
				prev = second;
			}
			temp1 = first.next;
			temp2 = second.next;
			
			first.next = second;
			second.next = temp1;
			
			first = temp1;
			second = temp2;
			
		}
		
		if (prev != null) {
			prev.next = second;
		}
		
	}

}
