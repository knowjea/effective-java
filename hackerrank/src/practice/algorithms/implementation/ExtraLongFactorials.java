package practice.algorithms.implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * Factorials 구하기
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 *
 * 코딩시간 : 5분
 *
 * @author gwon
 * @history
 *          2021. 4. 3. initial creation
 */
public class ExtraLongFactorials {

	// Complete the extraLongFactorials function below.
	static void extraLongFactorials(int n) {
		BigInteger val = new BigInteger("1");

		for (int i = 1; i <= n; i++) {
			val = val.multiply(new BigInteger(String.valueOf(i)));
		}

		System.out.println(val);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		extraLongFactorials(n);

		scanner.close();
	}
}
