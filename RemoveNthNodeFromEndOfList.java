package blind75;

public class RemoveNthNodeFromEndOfList {

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

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head.next == null)
			return null;

		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;

		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			prev = slow;
			slow = slow.next;
		}

		if (prev != null) {
			prev.next = slow.next;
			slow.next = null;			
		}
		else {
			head = head.next;
		}

		return head;
	}
}
