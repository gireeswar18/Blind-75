package blind75;

public class ReverseLinkedList {
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

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode curr = head;
		ListNode before = null;
		ListNode after;
		
		while (curr != null) {
			after = curr.next;
			curr.next = before;
			before = curr;
			curr = after;
		}
		
		return before;
	}
}
