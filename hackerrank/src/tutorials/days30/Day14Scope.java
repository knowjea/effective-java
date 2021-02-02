package tutorials.days30;

import java.util.Scanner;

/**
 * 절대값의 차이가 제일 큰 값을 출력, 양수만 입력되며, 범위는 1~100
 * https://www.hackerrank.com/challenges/30-scope/problem
 *
 * @author gwon
 * @history
 *          2021. 1. 31. initial creation
 */
public class Day14Scope {
	static class Difference {
		private int[] elements;
		public int maximumDifference;

		public Difference(int[] elements) {
			this.elements = elements;
		}

		public void computeDifference() {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < elements.length; i++) {
				if (max < elements[i]) {
					max = elements[i];
				}

				if (min > elements[i]) {
					min = elements[i];
				}
			}

			maximumDifference = max - min;
		}

	} // End of Difference class

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		Difference difference = new Difference(a);

		difference.computeDifference();

		System.out.print(difference.maximumDifference);
	}
}
