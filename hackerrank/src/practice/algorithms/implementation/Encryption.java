package practice.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

/**
 * 문제에 적혀져있는 방식으로 암호화한 결과
 * https://www.hackerrank.com/challenges/encryption/problem
 *
 * 코딩시간 : 15분
 *
 * @author gwon
 * @history
 *          2021. 4. 5. initial creation
 */
public class Encryption {
	// 문제에서 설명한 방식대로 구현하면 될 듯
	static String encryption(String s) {
		double d = Math.sqrt(s.length());

		int a = (int) Math.floor(d);
		int b = (int) Math.ceil(d);

		// rows * columns >= L
		if (a * b < s.length()) {
			a += 1;
		}

		String res = "";
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				try {
					res += s.charAt(j * b + i);
				} catch (StringIndexOutOfBoundsException e) {

				}
			}
			res += " ";
		}

		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = scanner.nextLine();

		String result = encryption(s);
		System.out.println(result);
		scanner.close();
	}
}
