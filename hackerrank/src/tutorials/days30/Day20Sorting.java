package tutorials.days30;

import java.util.Scanner;

/**
 * 똑같은 문제임 : https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
 * https://www.hackerrank.com/challenges/30-sorting/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 7. initial creation
 */
public class Day20Sorting {
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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		countSwaps(a);
	}
}
