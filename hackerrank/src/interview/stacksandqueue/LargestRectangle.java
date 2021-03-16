package interview.stacksandqueue;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * 최대 직사각형의 크기를 구하기
 * https://www.hackerrank.com/challenges/largest-rectangle/problem
 *
 * 코딩시간 : 2시간
 *
 * @author gwon
 * @history
 *          2021. 3. 16. initial creation
 */
public class LargestRectangle {

	// 분류가 스택, 큐에 되어있으니 스택으로 접근해보게 됨.
	// 만약 분류가 안되어있었으면 아예 시작도 못했을 거 같음.
	// for문 돌면서, 현재 값보다 작은 값이 나오면, 그 작은값보다 작은 값이 스택에 나올떄가지 직사각형 넓이 구하면 됨.
	static long largestRectangle(int[] h) {
		Stack<Integer> stack = new Stack<>();

		int[] arr = new int[h.length + 2];
		for (int i = 1; i < h.length + 1; i++) {
			arr[i] = h[i - 1];
		}

		stack.push(0);
		long max = -1;
		for (int i = 1; i < arr.length; i++) {
			while (arr[i] < arr[stack.peek()]) {
				int idx = stack.pop();

				long val = (i - stack.peek() - 1) * arr[idx];
				if (max < val) {
					max = val;
				}
			}

			stack.push(i);
		}

		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] h = new int[n];

		String[] hItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int hItem = Integer.parseInt(hItems[i]);
			h[i] = hItem;
		}

		long result = largestRectangle(h);

		scanner.close();
	}
}
