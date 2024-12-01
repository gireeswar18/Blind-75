package blind75;

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static class TreeNode {
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

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> inorderMap = new HashMap<>();

		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
	}

	public static TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd,
			HashMap<Integer, Integer> inorderMap) {

		if (preStart > preEnd || inStart > inEnd)
			return null;

		TreeNode curr = new TreeNode(preorder[preStart]);

		int ind = inorderMap.get(preorder[preStart]);
		int elementsInLeft = ind - inStart;

		curr.left = helper(preorder, inorder, preStart + 1, preStart + elementsInLeft, inStart, ind - 1, inorderMap);
		curr.right = helper(preorder, inorder, preStart + elementsInLeft + 1, preEnd, ind + 1, inEnd, inorderMap);

		return curr;
	}
}
