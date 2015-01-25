package defaultpackage;

import myutil.MyStack;

/**
 * @author Jonas Lindgren
 *
 *         Tests the class MyStack. Requires more work to be an exhaustive
 *         test..
 */
public class MyStackTest {

	/**
	 * Tests a MyStack full of strings, pushing and popping.
	 */
	private static void testStrings() {
		MyStack<String> stringStack = new MyStack<String>();

		// inserts a few test values
		stringStack.push("Anna");
		stringStack.push("Harry");
		stringStack.push("Ivar");

		// pops a few values and ensures they are correct
		for (int i = 0; i < 3; ++i) {
			String value = stringStack.pop();

			// string comparison is a little special..
			if (i == 0 && value.contentEquals("Ivar")) {
				// do nothing
			} else if (i == 1 && value.contentEquals("Harry")) {
				// do nothing
			} else if (i == 2 && value.contentEquals("Anna")) {
				// do nothing
			} else {
				System.err.println("testStrings: popped unexpected " + value
						+ " when popping value #" + i);
				return;
			}
		}

		// test successful
		System.out.println("testStrings: ok");
	}

	/**
	 * Tests a MyStack full of numbers, pushing and popping.
	 */
	private static void testNumbers() {
		MyStack<Integer> numberStack = new MyStack<Integer>();

		// inserts a few test values
		for (int i = 0; i < 5; ++i) {
			numberStack.push(i);
		}

		// pops a few values and ensures they are correct
		for (int i = 4; i >= 0; --i) {
			int value = numberStack.pop();
			if (value != i) {
				System.err.println("testNumbers: popped " + value
						+ ", expected " + i);
				return;
			}
		}

		// test successful
		System.out.println("testNumbers: ok");
	}

	/**
	 * Tests for exceptions when popping.
	 */
	private static void testExceptions() {
		MyStack<Integer> numberStack = new MyStack<Integer>();

		// makes sure there's an exception when the stack is empty
		try {
			int value = numberStack.pop();
			System.err.println("testExceptions: popped " + value
					+ ", expected an exception");
			return;
		} catch (RuntimeException e) {
			// do nothing
		}

		// insert and remove one value
		numberStack.push(7);
		numberStack.pop();

		// makes sure there's an exception when popping after removing all
		// values
		try {
			int value = numberStack.pop();
			System.err.println("testExceptions: popped " + value
					+ ", expected an exception");
			return;
		} catch (RuntimeException e) {
			// do nothing
		}

		// test successful
		System.out.println("testExceptions: ok");
	}

	/**
	 * Tests the function IsEmpty.
	 */
	private static void testIsEmpty() {
		MyStack<Integer> numberStack = new MyStack<Integer>();

		if (numberStack.isEmpty() == true) {
			// do nothing

		} else {
			System.out
					.println("testIsEmpty got false when the stack was empty");
		}

		// insert value
		numberStack.push(7);

		// Test when value is inserted
		if (numberStack.isEmpty() == false) {
			// do nothing
		} else {
			System.out
					.println("testIsEmpty got true when the stack wasn't empty");
		}
		// test successful
		System.out.println("testIsEmpty: ok");
	}

	/**
	 * Tests the function Size().
	 */
	private static void testSize() {

		MyStack<String> stringStack = new MyStack<String>();

		// inserts a few test values
		stringStack.push("Anna");
		stringStack.push("Harry");
		stringStack.push("Ivar");

		// Checks so that the size is 3

		if (stringStack.size() != 3) {
			
			System.err.println("testSize expected the size 3 but got the size "
					+ stringStack.size());
		}

		// test successful
		System.out.println("testSize: ok");
	}

	public static void main(String args[]) {
		System.out
				.println("Performs a number of tests.  Errors are printed in red if you're using Eclipse.");
		testStrings();
		testNumbers();
		testExceptions();
		testIsEmpty();
		testSize();

	}
}