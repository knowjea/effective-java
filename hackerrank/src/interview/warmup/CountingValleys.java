package interview.warmup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 *
 * @author gwon
 * @history
 *          2021. 1. 25. initial creation
 */

public class CountingValleys {

	/*
	 * Complete the 'countingValleys' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 * 1. INTEGER steps
	 * 2. STRING path
	 */
	public static int countingValleys(int steps, String path) {
		int value = 0;
		int res = 0;
		for (int i = 0; i < steps; i++) {
			if (path.charAt(i) == 'U') {
				value++;
				if (value == 0) {
					res++;
				}
			} else {
				value--;
			}
		}

		return res;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int steps = Integer.parseInt(bufferedReader.readLine().trim());

		String path = bufferedReader.readLine();

		int result = CountingValleys.countingValleys(steps, path);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

}
