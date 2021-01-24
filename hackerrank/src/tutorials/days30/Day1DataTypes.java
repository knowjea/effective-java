package tutorials.days30;

import java.util.Scanner;

/**
 *
 *
 * @author gwon
 * @history
 *          2021. 1. 24. initial creation
 */
public class Day1DataTypes {
	public static void main(String[] args) {
		int i = 4;
		double d = 4.0;
		String s = "HackerRank ";

		Scanner scan = new Scanner(System.in);

		/* Declare second integer, double, and String variables. */
		int ii = 0;
		double dd = 0;
		String ss = "";
		/* Read and save an integer, double, and String to your variables. */
		// Note: If you have trouble reading the entire String, please go back and review the
		// Tutorial closely.

		ii = scan.nextInt();
		dd = scan.nextDouble();
		scan.nextLine();
		ss = scan.nextLine();

		/* Print the sum of both integer variables on a new line. */
		System.out.println(ii + i);
		/* Print the sum of the double variables on a new line. */
		System.out.println(dd + d);
		/*
		 * Concatenate and print the String variables on a new line;
		 * the 's' variable above should be printed first.
		 */
		System.out.println(s + ss);

		scan.close();
	}
}
