package tutorials.days30;

import java.util.Scanner;

/**
 *
 *
 * @author gwon
 * @history
 *          2021. 1. 24. initial creation
 */
public class Day6Char {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		scan.nextLine();

		for (int i = 0; i < n; i++) {
			String str = scan.nextLine();

			for (int j = 0; j < str.length(); j += 2) {
				System.out.print(str.charAt(j));
			}

			System.out.print(" ");
			for (int j = 1; j < str.length(); j += 2) {
				System.out.print(str.charAt(j));
			}

			System.out.println();
		}
	}
}
