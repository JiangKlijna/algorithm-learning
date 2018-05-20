package util;

import java.util.ArrayList;

/**
 * 由两个栈实现的双端队列
 */
public class DoubleStackDeque<E> {

	private final Stack<E> stackOne = new Stack<>(ArrayList.class);
	private final Stack<E> stackTwo = new Stack<>(ArrayList.class);

	public E addFirst(E e) {
		return stackTwo.push(e);
	}

	public E addLast(E e) {
		return stackOne.push(e);
	}

	public E pollFirst() {
		if (stackTwo.empty()) {
			if (stackOne.empty()) return null;
			pushFromSrc(stackOne, stackTwo);
		}
		return stackTwo.pop();
	}

	public E pollLast() {
		if (stackOne.empty()) {
			if (stackTwo.empty()) return null;
			pushFromSrc(stackTwo, stackOne);
		}
		return stackOne.pop();
	}

	public E peekFirst() {
		return stackTwo.peek();
	}

	public E peekLast() {
		return stackOne.peek();
	}

	public int size() {
		return stackTwo.size() + stackOne.size();
	}

	public boolean isEmpty() {
		return stackTwo.size() == 0 && stackOne.size() == 0;
	}

	private static void pushFromSrc(Stack src, Stack dist) {
		if (src == dist) return;
		while (!src.empty()) dist.push(src.pop());
	}

	@Override
	public String toString() {
		return "DoubleStackDeque {" + "\n\tstackOne=" + stackOne + ",\n\tstackTwo=" + stackTwo + "\n}";
	}

}
