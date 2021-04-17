package practice.algorithms.debugging;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 미리 짜져있는 코드를 고쳐보는 문제.
 * 지그재그 시퀀스라고해서, 가운데 숫자를 중심으로 오름차순되었다가 내림차순으로 만드는 값. (사전적으로 가장 작은 값)
 * https://www.hackerrank.com/challenges/zig-zag-sequence/problem
 *
 * 코딩시간 : 20분
 *
 * @author gwon
 * @history
 *          2021. 4. 17. initial creation
 */
public class ZigZagSequence {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner kb = new Scanner(System.in);
		int test_cases = kb.nextInt();
		for (int cs = 1; cs <= test_cases; cs++) {
			int n = kb.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = kb.nextInt();
			}
			findZigZagSequence(a, n);
		}
	}

	/**
	 * 먼저 소트하면 중간에서 앞에건 오름차순이니 해결되고, 뒤에 숫자들은 역순으로 다시 해주면 됨.
	 * 세 곳만 고쳐야된다., (n + 1) / 2 - 1 이나 ((n + 1) / 2) - 1이나 똑같은데 후자는 계속 에러라고 해서 어이없는 문제..
	 */
	public static void findZigZagSequence(int[] a, int n) {
		Arrays.sort(a);
		int mid = (n + 1) / 2 - 1;
		int temp = a[mid];
		a[mid] = a[n - 1];
		a[n - 1] = temp;

		int st = mid + 1;
		int ed = n - 2;
		while (st <= ed) {
			temp = a[st];
			a[st] = a[ed];
			a[ed] = temp;
			st = st + 1;
			ed = ed - 1;
		}
		for (int i = 0; i < n; i++) {
			if (i > 0) {
				System.out.print(" ");
			}
			System.out.print(a[i]);
		}
		System.out.println();
	}
}
