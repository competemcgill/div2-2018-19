import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Test class for implementation of Queue with 2 stacks.
 * 
 * @author Imad Dodin
 * 
 */
public class Question1 {

	public static void main(String[] args) {
		StackQueue<Integer> st = new StackQueue<Integer>();
		st.enqueue(1);
		st.enqueue(2);
		try {
			st.peek();
			st.dequeue();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
		st.enqueue(3);
		st.enqueue(4);
		st.printQueue();
	}

}

/**
 * Implementation of Queue with two stacks.
 * 
 * @author Imad Dodin
 *
 * @param <T> Queue Element Type
 */
class StackQueue<T> {

	/*
	 * Underlying Stacks
	 */
	private Stack<T> st1, st2;

	/**
	 * No arg constructor, constructs Empty Queue, initializing underlying stacks.
	 */
	public StackQueue() {
		this.st1 = new Stack<T>();
		this.st2 = new Stack<T>();
	}

	/**
	 * Enqueue an item of type T.
	 * 
	 * @param item Item to enqueue.
	 * @return Enqueued item.
	 */
	public T enqueue(T item) {
		st1.push(item);
		return item;
	}

	/**
	 * Shift elements from old stack to new stack if empty, to prepare for
	 * peek/dequeue.
	 */
	private void stackShift() {
		if (st2.isEmpty()) {
			while (!st1.isEmpty()) {
				st2.push(st1.pop());
			}
		}
	}

	/**
	 * Dequeue element from Queue.
	 * 
	 * @return Dequeued element.
	 * @throws EmptyQueueException If Queue is Empty, throw EmptyQueueException
	 */
	public T dequeue() throws EmptyQueueException {
		stackShift();
		try {
			T item = st2.pop();
			return item;
		} catch (EmptyStackException e) {
			throw new EmptyQueueException(e);
		}
	}

	/**
	 * Peek at element from Queue.
	 * 
	 * @return Peeked element.
	 * @throws EmptyQueueException If Queue is Empty, throw EmptyQueueException
	 */
	public T peek() throws EmptyQueueException {
		stackShift();
		try {
			T item = st2.peek();
			return item;
		} catch (EmptyStackException e) {
			throw new EmptyQueueException(e);
		}
	}

	/**
	 * Print elements in Queue.
	 */
	@SuppressWarnings("unchecked")
	public void printQueue() {
		Stack<T> copy2 = (Stack<T>) st2.clone();
		Stack<T> copy1 = (Stack<T>) st1.clone();
		System.out.print("[");
		while (!copy2.isEmpty()) {
			System.out.print(copy2.pop() + (copy2.size() == 0 ? "" : ", "));
		}
		while (!copy1.isEmpty()) {
			copy2.push(copy1.pop());
		}
		while (!copy2.isEmpty()) {
			System.out.print(", " + copy2.pop());
		}
		System.out.print(']');
	}
}

/**
 * Implementation of custom exception for EmptyQueue
 * 
 * @author Imad Dodin
 *
 */
class EmptyQueueException extends Exception {

	private static final long serialVersionUID = -5676766096596680695L;

	public EmptyQueueException(Throwable t) {
		super(t);
	}

}
