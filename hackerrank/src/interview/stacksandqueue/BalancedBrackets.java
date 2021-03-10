package interview.stacksandqueue;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Brackets이 제대로 이루어져있는지
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 *
 * 코딩시간 : 10분
 *
 * @author gwon
 * @history
 *          2021. 3. 10. initial creation
 */
public class BalancedBrackets {

	// 스택 가장 기본 문제.
	static String isBalanced(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '{':
			case '[':
			case '(':
				stack.push(s.charAt(i));
				break;
			case '}':
			case ']':
			case ')':
				if (stack.isEmpty()) {
					return "NO";
				}
				Character ch = stack.pop();
				if (ch == null) {
					return "NO";
				}
				if ((ch == '{' && s.charAt(i) == '}') || (ch == '[' && s.charAt(i) == ']')
				        || (ch == '(' && s.charAt(i) == ')')) {
					break;
				} else {
					return "NO";
				}
			}
		}

		if (!stack.isEmpty()) {
			return "NO";
		}

		return "YES";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();

			String result = isBalanced(s);
			System.out.println(result);
		}

		scanner.close();
	}
}
