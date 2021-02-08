package tutorials.days30;

import java.util.Scanner;

/**
 * BST 높이 구하기
 * https://www.hackerrank.com/challenges/30-binary-search-trees/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 8. initial creation
 */
public class Day22BinarySearchTrees {
	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static int getHeight(Node root) {
		if (root == null) {
			return -1;
		}

		int leftHeight = getHeight(root.left) + 1;
		int rightHeight = getHeight(root.right) + 1;

		return Integer.max(leftHeight, rightHeight);
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		int height = getHeight(root);
		System.out.println(height);
	}
}
