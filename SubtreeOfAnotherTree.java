package blind75;

public class SubtreeOfAnotherTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {

		if (root == null)
			return false;

		if (root.val == subRoot.val && check(root.left, subRoot.left) && check(root.right, subRoot.right)) {
			return true;
		}

		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public static boolean check(TreeNode a, TreeNode b) {
		if (a == null && b == null)
			return true;

		if (a == null || b == null)
			return false;

		if (a.val == b.val)
			return check(a.left, b.left) && check(a.right, b.right);

		return false;
	}
}
