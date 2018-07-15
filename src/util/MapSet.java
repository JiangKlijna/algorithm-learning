package util;

import java.util.*;

public class MapSet<E> extends AbstractSet<E> implements Set<E> {

	private transient Map<E, Object> map;

	private static final Object PRESENT = new Object();

	public MapSet() {
		this(new HashMap<>());
	}

	public MapSet(Map<E, Object> map) {
		this.map = map;
	}

	public Iterator<E> iterator() {
		return map.keySet().iterator();
	}

	public int size() {
		return map.size();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public boolean contains(Object o) {
		return map.containsKey(o);
	}

	public boolean add(E e) {
		return map.put(e, PRESENT) == null;
	}

	public boolean remove(Object o) {
		return map.remove(o) == PRESENT;
	}

	public void clear() {
		map.clear();
	}
}