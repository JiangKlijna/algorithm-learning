package util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Queue<E> {
	private final Deque<E> data;

	public Queue() {
		this(LinkedList.class);
	}

	public Queue(Class<? extends Deque> cls) {
		Deque<E> list;
		try {
			list = cls.newInstance();
		} catch (ReflectiveOperationException e) {
			list = new ArrayDeque();
		}
		data = list;
	}

	public E offer(E item) {
		data.addLast(item);
		return item;
	}

	public E poll() {
		return data.removeFirst();
	}

	public E peek() {
		return data.getFirst();
	}

	public boolean empty() {
		return size() == 0;
	}

	public int size() {
		return data.size();
	}

	@Override
	public String toString() {
		return data.toString();
	}

	@Override
	public int hashCode() {
		return data.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return data.equals(obj);
	}
}
