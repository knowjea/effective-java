package interview.search;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 배열 세 개가 주어졌을때, 하나씩 꺼내서, a <= b, b b>= c를 만족하는 경우의 수를 구하기
 * https://www.hackerrank.com/challenges/triple-sum/problem
 *
 * 코딩시간 : 30분해도 안됨
 *
 * @author gwon
 * @history
 *          2021. 3. 6. initial creation
 */
public class TripleSum {
	// n은 10^5
	static long triplets(int[] a, int[] b, int[] c) {
		a = Arrays.stream(a).distinct().boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue)
		        .toArray();
		b = Arrays.stream(b).distinct().boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue)
		        .toArray();
		Arrays.stream(c).distinct().sorted();

		long res = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] > b[j]) {
					break;
				}

				for (int k = 0; k < c.length; k++) {
					if (b[j] < c[k]) {
						break;
					}

					res++;
				}
			}
		}

		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] lenaLenbLenc = scanner.nextLine().split(" ");

		int lena = Integer.parseInt(lenaLenbLenc[0]);

		int lenb = Integer.parseInt(lenaLenbLenc[1]);

		int lenc = Integer.parseInt(lenaLenbLenc[2]);

		int[] arra = new int[lena];

		String[] arraItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lena; i++) {
			int arraItem = Integer.parseInt(arraItems[i]);
			arra[i] = arraItem;
		}

		int[] arrb = new int[lenb];

		String[] arrbItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lenb; i++) {
			int arrbItem = Integer.parseInt(arrbItems[i]);
			arrb[i] = arrbItem;
		}

		int[] arrc = new int[lenc];

		String[] arrcItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lenc; i++) {
			int arrcItem = Integer.parseInt(arrcItems[i]);
			arrc[i] = arrcItem;
		}

		long ans = triplets(arra, arrb, arrc);

		scanner.close();
	}
}
