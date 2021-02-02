package tutorials.days30;

import java.util.Scanner;

/**
 *
 * String을 int로 못바꿀 경우 에러
 * https://www.hackerrank.com/challenges/30-exceptions-string-to-integer/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 2. initial creation
 */
public class Day16Exceptions {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		try {
			String S = in.next();
			System.out.println(Integer.parseInt(S));
		} catch (Exception e) {
			System.out.println("Bad String");
		}

	}
}
