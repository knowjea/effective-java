package rule6;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 8. initial creation
 */
public class StackTest {

	public static void main(String[] args) {
		StackTest stack = new StackTest();

		stack.push(new Object());
		stack.push(new Object());
		stack.push(new Object());
		stack.push(new Object());

		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

		// Objects between 0 and 3 is obsolete reference.
		for (int i = 0; i < stack.elements.length; i++) {
			System.out.println("#idx-" + i + "  " + stack.elements[i]);
		}

		System.out.println("############################");

		StackTest stackDoThis = new StackTest();

		stackDoThis.push(new Object());
		stackDoThis.push(new Object());
		stackDoThis.push(new Object());
		stackDoThis.push(new Object());

		stackDoThis.popDoThis();
		stackDoThis.popDoThis();
		stackDoThis.popDoThis();
		stackDoThis.popDoThis();

		for (int i = 0; i < stack.elements.length; i++) {
			System.out.println("#idx-" + i + "  " + stackDoThis.elements[i]);
		}

	}

	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 16;

	public StackTest() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	/**
	 * Do this
	 */
	public Object popDoThis() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		Object result = elements[--size];
		elements[size] = null; /* to let gc do its work */

		return result;
	}

	/**
	 * Do not do this.
	 * This method only decreases the size of the stack.
	 * The object at the corresponding array index becomes an obsolete reference.
	 */
	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		return elements[--size];
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}
