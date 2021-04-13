package interview.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 손으로도 못풀겠다.
 * https://www.hackerrank.com/challenges/reverse-shuffle-merge/problem
 *
 * @author gwon
 * @history
 *          2021. 3. 1. initial creation
 */
public class ReverseShuffleMerge {

	// Complete the reverseShuffleMerge function below.
	static String reverseShuffleMerge(String s) {

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String result = reverseShuffleMerge(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
