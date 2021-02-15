package tutorials.days30;

import java.util.Scanner;

/**
 * 링크드 리스트에서 중복값 삭제하기
 * https://www.hackerrank.com/challenges/30-linked-list-deletion/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 15. initial creation
 */
public class Day24LinkedList {
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}

	}

	public static Node removeDuplicates(Node head) {
		Node copy = head;

		while (true) {
			if (head == null) {
				break;
			}

			if (head.next == null) {
				break;
			}

			if (head.data == head.next.data) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}

		return copy;
	}

	public static Node insert(Node head, int data) {
		Node p = new Node(data);
		if (head == null) {
			head = p;
		} else if (head.next == null) {
			head.next = p;
		} else {
			Node start = head;
			while (start.next != null) {
				start = start.next;
			}
			start.next = p;

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
		int T = sc.nextInt();
		while (T-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		head = removeDuplicates(head);
		display(head);

	}
}
