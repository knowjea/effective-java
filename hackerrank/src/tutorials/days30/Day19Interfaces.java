package tutorials.days30;

import java.util.Scanner;

/**
 * 인터페이스 구현 문제이긴 하지만, 그냥 약수의 합 구하는 문제.
 * https://www.hackerrank.com/challenges/30-interfaces/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 7. initial creation
 */
public class Day19Interfaces {
	interface AdvancedArithmetic {
		int divisorSum(int n);
	}

	static class Calculator implements AdvancedArithmetic {
		@Override
		public int divisorSum(int n) {
			int res = 0;
			for (int i = 1; i <= n; i++) {
				if (n % i == 0) {
					res += i;
				}
			}
			return res;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		AdvancedArithmetic myCalculator = new Calculator();
		int sum = myCalculator.divisorSum(n);
		System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
		System.out.println(sum);
	}
}
