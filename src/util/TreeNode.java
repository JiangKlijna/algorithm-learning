package util;

public class TreeNode<E> {
	public E val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(E x) {
		val = x;
	}

	public static <E> TreeNode<E> getTreeNode(E... is) {
		TreeNode[] tns = new TreeNode[is.length];
		for (int i = 0; i < tns.length; i++)
			tns[i] = new TreeNode(is[i]);
		for (int i = 0; i < tns.length; i++) {
			int left = 2 * i + 1, right = left + 1;
			if (left >= tns.length) break;
			tns[i].left = tns[left];
			if (right >= tns.length) break;
			tns[i].right = tns[right];
		}
		return tns[0];
	}

	public static void printTreeNode(TreeNode node) {

	}

	// 先序遍历 递归版
	public static void preOrderRecursive(TreeNode tn) {
		if (tn == null) return;
		System.out.print(tn.val + "\t");
		preOrderRecursive(tn.left);
		preOrderRecursive(tn.right);
	}

	// 中序遍历 递归版
	public static void inOrderRecursive(TreeNode tn) {
		if (tn == null) return;
		inOrderRecursive(tn.left);
		System.out.print(tn.val + "\t");
		inOrderRecursive(tn.right);
	}

	// 后序遍历 递归版
	public static void postOrderRecursive(TreeNode tn) {
		if (tn == null) return;
		postOrderRecursive(tn.left);
		postOrderRecursive(tn.right);
		System.out.print(tn.val + "\t");
	}

	//Iterative 平衡二叉树
	public static void main(String[] args) {
		preOrderRecursive(getTreeNode(0, 1, 2, 3, 4, 5, 6));
		System.out.println();
		inOrderRecursive(getTreeNode(0, 1, 2, 3, 4, 5, 6));
		System.out.println();
		postOrderRecursive(getTreeNode(0, 1, 2, 3, 4, 5, 6));
		System.out.println();
	}
}
