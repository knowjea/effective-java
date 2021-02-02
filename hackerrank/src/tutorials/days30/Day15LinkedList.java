package tutorials.days30;

import java.util.Scanner;

/**
 * 링크드리스트 insert 구현
 * https://www.hackerrank.com/challenges/30-linked-list/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 2. initial creation
 */
public class Day15LinkedList {
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static Node insert(Node head, int data) {
		// Complete this method
		if (head == null) {
			return new Node(data);
		} else {
			Node node = head;
			while (node.next != null) {
				node = node.next;
			}

			node.next = new Node(data);
		}

		return head;
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int N = sc.nextInt();

		while (N-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		display(head);
		sc.close();
	}
}
