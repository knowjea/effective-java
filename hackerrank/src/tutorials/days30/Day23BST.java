package tutorials.days30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 바이너리 서치 트리 BFS 방식으로 순회했을 때 결과
 * https://www.hackerrank.com/challenges/30-binary-trees/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 15. initial creation
 */
public class Day23BST {
	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	static void levelOrder(Node root) {
		List<Node> list = new ArrayList<>();
		list.add(root);

		while (true) {
			if (list.size() == 0) {
				break;
			}

			Node node = list.get(0);
			list.remove(0);
			System.out.print(node.data + " ");
			if (node.left != null) {
				list.add(node.left);
			}

			if (node.right != null) {
				list.add(node.right);
			}

		}
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
		levelOrder(root);
	}

}
