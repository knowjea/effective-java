package practice.algorithms.warmup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * 배열에서 최대값의 개수
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 *
 * 코딩시간 : 3분
 *
 * @author gwon
 * @history
 *          2021. 3. 21. initial creation
 */
public class BirthdayCakeCandles {

	/*
	 * Complete the 'birthdayCakeCandles' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts INTEGER_ARRAY candles as parameter.
	 */

	public static int birthdayCakeCandles(List<Integer> candles) {
		int max = candles.stream().max(Comparator.comparing(x -> x)).get();
		return (int) candles.stream().filter(x -> x.equals(max)).count();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
		        .map(Integer::parseInt)
		        .collect(Collectors.toList());

		int result = BirthdayCakeCandles.birthdayCakeCandles(candles);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
