package tutorials.days30;

import java.util.Scanner;

/**
 *
 *
 * @author gwon
 * @history
 *          2021. 1. 24. initial creation
 */
public class Day2Operators {

	// Complete the solve function below.
	static void solve(double meal_cost, int tip_percent, int tax_percent) {
		double tip = (meal_cost * tip_percent) / 100.0;
		double tax = (meal_cost * tax_percent) / 100.0;
		int cost = (int) Math.round(meal_cost + tip + tax);
		System.out.println(cost);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		double meal_cost = scanner.nextDouble();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int tip_percent = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int tax_percent = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		solve(meal_cost, tip_percent, tax_percent);

		scanner.close();
	}
}
