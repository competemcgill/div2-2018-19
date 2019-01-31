
/**
 * Implementation of solution to finding start of a loop within a LinkedList.
 * @author Imad Dodin
 *
 */
public class Question2 {

	public static void main(String[] args) {
		Node dummy = new Node(0);
		Node head = dummy;
		
		for(int i=1; i<10; i++) {
			dummy.next = new Node(i);
			
			if(i==9) {
				dummy.next.next = head.next.next.next;
			}
			
			dummy = dummy.next;
		}
		
		System.out.println("Loop starts at Node with value: " + findLoop(head.next));
		
	}
	
	/**
	 * Return value of node where LinkedList loop starts.
	 * @param head Head of linked list
	 * @return Value of node where LinkedList loop starts, -1 if no loop.
	 */
	public static int findLoop(Node head) {
		Node slower = head;
		Node faster = head;
		
		// Loop until pointers meet or end of list is reached.
		while(faster!= null && faster.next != null) {
			faster = faster.next.next;
			slower = slower.next;
			if(slower==faster) {
				break;
			}
		}
		
		// Check why we broke previous loop:
		// If end was reached, return -1.
		if(faster==null || faster.next==null) {
			return -1;
		}
		
		// At the end of the first loop. We know that the pointers met
		// LIST_SIZE - LOOP_SIZE nodes before the end of the loop. By
		// resetting the pointer to the head of the list, we ensure they
		// meet again at the start of the loop.
		slower = head;
		while(slower!=faster) {
			slower = slower.next;
			faster = faster.next;
		}
		
		return slower.value;
	}

}

/**
 * Definition of a simple LinkedList Node with integer value.
 * @author Imad Dodin
 *
 */
class Node{
	int value;
	Node next;
	
	public Node(int value) {
		this.value = value;
	}
}
