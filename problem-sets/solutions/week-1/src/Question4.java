import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Implementation of Zig Zag Traversal
 * @author Imad Dodin
 *
 */
public class Question4 {

	public static void main(String[] args) {
		List<TreeNode> ls = zigZagTraverse(constructTree());
		System.out.print("[");
		for(TreeNode t : ls) System.out.print(t.value + " ");
		System.out.print("]");
	}
	
	/**
	 * Helper function to construct tree. 
	 * @return Tree, as given in Problem Set.
	 */
	public static TreeNode constructTree(){
		TreeNode rootLeft = new TreeNode(3, new TreeNode(4), new TreeNode(7));
		TreeNode rootRight = new TreeNode(2, new TreeNode(9), new TreeNode(8));
		return new TreeNode(6, rootLeft, rootRight);
	}
	
	/**
	 * Outputs list in Zig-Zag Order Traversal.
	 * @param root of Tree to traverse.
	 * @return list in Zig-Zag Order Traversal.
	 */
	public static List<TreeNode> zigZagTraverse(TreeNode root){
		
		// List to contain traversed nodes. Alternatively, store integers
		// directly into list.
		List<TreeNode> out = new ArrayList<TreeNode>();
		
		// Queue (as with a standard level-order traversal).
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		// Stack (used in every other level to output level in reverse order).
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		// Boolean used to indicate every other level (to output for reverse order).
		Boolean reverse = false;
		
		// Add root to start traversal
		q.add(root);
		
		// Continuously add levels until queue is empty.
		while(!q.isEmpty()) {
			
			// At every level loop across nodes in level. 
			int size = q.size();
			for(int i=0; i<size; i++) {
				
				// Traverse level in normal order.
				if(!reverse) {
					TreeNode popped = q.remove();
					
					if(popped.left!=null)q.add(popped.left);
					if(popped.right!=null)q.add(popped.right);
					
					out.add(popped);
					
				}
				
				// For reverse traversal, add nodes into stack (eventually popped).
				else {
					TreeNode popped = q.remove();
					
					if(popped.left!=null)q.add(popped.left);
					if(popped.right!=null)q.add(popped.right);
					
					s.push(popped);
				}
				
			}
			
			// Pop nodes in stack to output in reverse order.
			while(!s.isEmpty()) {
				out.add(s.pop());
			}
			reverse = !reverse;
			
		}
		
		return out;
	}
	
	/**
	 * Definition of simple Tree node with Integer values.
	 * @author Imad Dodin
	 *
	 */
	private static class TreeNode{
		TreeNode left;
		TreeNode right;
		int value;
		
		/**
		 * Construct TreeNode with null children and specified value.
		 * @param value - Value contained in Node.
		 */
		public TreeNode(int value) {
			this.value = value;
		}
		
		/**
		 * Construct TreeNode with value and specified Left and Right subtree root nodes.
		 * @param value - Value contained.
		 * @param left - Root of left subtree.
		 * @param right - Root of right subtree.
		 */
		public TreeNode(int value, TreeNode left, TreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
	}
	
}


