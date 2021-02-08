package tutorials.days30;

import java.util.Scanner;

/**
 * 제네릭 구현해보자
 * https://www.hackerrank.com/challenges/30-generics/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 8. initial creation
 */
public class Day21Generics {
	static class Printer<T> {
		public void printArray(T[] in) {
			for (T t : in) {
				System.out.println(t);
			}
		}
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Integer[] intArray = new Integer[n];
		for (int i = 0; i < n; i++) {
			intArray[i] = scanner.nextInt();
		}

		n = scanner.nextInt();
		String[] stringArray = new String[n];
		for (int i = 0; i < n; i++) {
			stringArray[i] = scanner.next();
		}

		Printer<Integer> intPrinter = new Printer<Integer>();
		Printer<String> stringPrinter = new Printer<String>();
		intPrinter.printArray(intArray);
		stringPrinter.printArray(stringArray);
		if (Printer.class.getDeclaredMethods().length > 1) {
			System.out.println("The Printer class should only have 1 method named printArray.");
		}
	}
}
