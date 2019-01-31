
/**
 * Implementation of summing two reversed integer linked lists.
 * @author Imad Dodin
 *
 */
public class Question3 {

	public static void main(String[] args) {
		Node res = sumLL(intToLL(111111), intToLL(222));
		printLL(res);
	}
	

	/**
	 * Utility function to convert an integer into its reversed LinkedList representation.
	 * @param x integer to convert.
	 * @return head of resultant LinkedList.
	 */
	private static Node intToLL(int x) {
		Node dummy = new Node(0);
		Node head = dummy;
		while (x != 0) {
			dummy.next = new Node(x % 10);
			x /= 10;
			dummy = dummy.next;
		}

		return head.next;
	}
	
	/**
	 * Utility function to print contents of a LinkedList
	 * @param head Head of LinkedList to print.
	 */
	private static void printLL(Node head) {
		if (head != null) {
			System.out.print(head.value);
			head = head.next;
		}
		while (head != null) {
			System.out.print("->" + head.value);
			head = head.next;
		}
	}

	/**
	 * Implementation of sum of 2 reversed integer LinkedLists.
	 * @param h1 Head of first reversed integer LinkedList
	 * @param h2 Head of second reversed integer LinkedList
	 * @return Head of reversed integer LinkedList of sum
	 */
	public static Node sumLL(Node h1, Node h2) {
		// Check edge cases.
		if(h1==null && h2==null) return null;
		if(h1==null || h2==null) return h1==null ? h2: h1;
		
		// Instantiate Dummy and Head variable (for eventual return).
		Node dummy = new Node(0);
		Node head = dummy;

		// Instantiate pointers to both LinkedLists.
		// n.b. not required since we will never refer to h1 and h2 again,
		// but this is good practice.
		Node pointer1 = h1;
		Node pointer2 = h2;
		
		// Carry 
		int carry = 0;

		// Loop as long as there is something to sum.
		while (pointer1 != null || pointer2 != null) {
			
			// Sum values if pointers are not null.
			int sum = (pointer1 != null ? pointer1.value : 0) + (pointer2 != null ? pointer2.value : 0) + carry;
			
			// Instantiate next node with sum.
			dummy.next = new Node(sum % 10);
			
			// Take care of carry.
			carry = sum / 10;
			
			// Increment pointers.
			dummy = dummy.next;
			if (pointer1 != null)
				pointer1 = pointer1.next;
			if (pointer2 != null)
				pointer2 = pointer2.next;
		}
		// If we're left with a carry, append it.
		if (carry != 0) {
			dummy.next = new Node(carry);
		}

		// Return real head.
		return head.next;
	}

}
