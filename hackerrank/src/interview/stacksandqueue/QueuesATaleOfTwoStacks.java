package interview.stacksandqueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 스택 2개로 큐를 만들라는데..
 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
 *
 * 코딩시간 : 25분
 *
 * @author gwon
 * @history
 *          2021. 3. 10. initial creation
 */
public class QueuesATaleOfTwoStacks {

	// 어찌어찌 구현은 했는데.. 왜 이런 문제가 있는지 모르겠다
	public static class MyQueue<T> {
		Stack<T> a = new Stack<>();
		Stack<T> b = new Stack<>();

		public void enqueue(T nextInt) {
			a.push(nextInt);
		}

		public T dequeue() {
			if (b.isEmpty()) {
				while (!a.isEmpty()) {
					b.push(a.pop());
				}
			}

			return b.pop();
		}

		public T peek() {
			if (b.isEmpty()) {
				while (!a.isEmpty()) {
					b.push(a.pop());
				}
			}

			return b.lastElement();
		}

	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}
