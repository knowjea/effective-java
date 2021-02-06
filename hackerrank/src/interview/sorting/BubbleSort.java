package interview.sorting;

import java.util.Scanner;

/**
 * 버블소트의 swap이 몇번 실행되었고, 첫번째 값과 마지막 값이 무엇인지 출력
 * https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
 *
 * 코딩 시간 : 5분 이하
 *
 * @author gwon
 * @history
 *          2021. 2. 5. initial creation
 */
public class BubbleSort {
	// Complete the countSwaps function below.
	static void countSwaps(int[] a) {
		int n = a.length;

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					cnt++;
				}
			}
		}

		System.out.printf("Array is sorted in %d swaps.\n", cnt);
		System.out.printf("First Element: %d\n", a[0]);
		System.out.printf("Last Element: %d\n", a[n - 1]);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		countSwaps(a);

		scanner.close();
	}
}
