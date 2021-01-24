package tutorials.days30;

import java.util.Scanner;

/**
 *
 *
 * @author gwon
 * @history
 *          2021. 1. 24. initial creation
 */
public class Day5Loops {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 1; i <= 10; i++) {
			System.out.println(n + " x " + i + " = " + n * i);
		}

		scanner.close();
	}
}
