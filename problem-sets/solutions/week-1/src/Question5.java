
/**
 * Implementation of Tree Reconstruction with inOrder and postOrder traversals
 * 
 * @author Imad Dodin
 *
 */
public class Question5 {
	static int postIndex;

	public static void main(String[] args) {
		int[] in = new int[] { 4, 13, 2, 11, 1, 6, 8, 7 };
		int[] post = new int[] { 13, 4, 11, 2, 6, 7, 8, 1 };

		postIndex = post.length - 1;

		TreeNode root = reconstruct(in, post, 0, post.length - 1);

		preOrderTraverse(root);

	}

	/**
	 * Traverse tree in PreOrder, to test generated tree.
	 * 
	 * @param root - Root Node of Tree to Traverse.
	 */
	public static void preOrderTraverse(TreeNode root) {
		if (root == null)
			return;

		System.out.println(root.value);
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}

	/**
	 * Reconstruct a tree with inOrder and postOrder traversals.
	 * 
	 * @param in      - InOrder traversal array.
	 * @param post    - PostOrder traversal array.
	 * @param inStart - Start index of current subset of InOrder traversal array.
	 * @param inEnd   - End index of current subset of InOrder traversal array.
	 * @return Root Node of reconstructed tree.
	 */
	public static TreeNode reconstruct(int in[], int post[], int inStart, int inEnd) {

		// Base case
		if (inStart > inEnd)
			return null;

		// Construct current Node.
		TreeNode node = new TreeNode(post[postIndex]);
		postIndex--;

		// No children, don't bother recursing
		if (inStart == inEnd)
			return node;

		// Find index of current node to know how to split
		// into subsets.
		int index = search(in, inStart, inEnd, node.value);

		// Recurse into subsets.
		node.right = reconstruct(in, post, index + 1, inEnd);
		node.left = reconstruct(in, post, inStart, index - 1);

		return node;

	}

	/**
	 * Search for value in specified subset of array.
	 * 
	 * @param in      - array to search
	 * @param inStart - start index of subset
	 * @param inEnd   - end index of subset
	 * @param val     - value to search for
	 * @return
	 */
	public static int search(int[] in, int inStart, int inEnd, int val) {
		int i;
		for (i = inStart; i <= inEnd; i++) {
			if (in[i] == val)
				break;
		}
		if (i > inEnd)
			return -1;
		return i;
	}

	/**
	 * Definition of simple Tree node with Integer values.
	 * 
	 * @author Imad Dodin
	 *
	 */
	private static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		/**
		 * Construct TreeNode with null children and specified value.
		 * 
		 * @param value - Value contained in Node.
		 */
		public TreeNode(int value) {
			this.value = value;
		}
	}

}
