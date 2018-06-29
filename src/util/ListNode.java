package util;

public class ListNode<E> {
	public E val;
	public ListNode next;

	public ListNode(E x) {
		val = x;
	}

	public static <E> ListNode getListNode(E... es) {
		ListNode re = new ListNode(es[0]), prev = re;
		for (int i = 1; i < es.length; i++)
			prev = prev.next = new ListNode(es[i]);
		return re;
	}

	public static void printListNode(ListNode ln) {
		while (ln != null) {
			System.out.print(ln.val + "\t");
			ln = ln.next;
		}
		System.out.println();
	}
}
