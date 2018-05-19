package util;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Stack<E> {
	private final List<E> data;

	public Stack() {
		this(LinkedList.class);
	}

	public Stack(Class<? extends List> cls) {
		List<E> list;
		try {
			list = cls.newInstance();
		} catch (ReflectiveOperationException e) {
			list = new Vector();
		}
		data = list;
	}

	public E push(E item) {
		data.add(item);
		return item;
	}

	public E pop() {
		if (empty()) return null;
		return data.remove(size() - 1);
	}

	public E peek() {
		if (empty()) return null;
		return data.get(size() - 1);
	}

	public boolean empty() {
		return size() == 0;
	}

	public int search(E o) {
		return data.indexOf(o);
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
