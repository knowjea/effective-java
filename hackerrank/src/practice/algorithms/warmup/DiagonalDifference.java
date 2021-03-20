package practice.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 이차배열 대각선방향 각각 구해서 절대값 차이 구하기
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 *
 * 코딩시간 : 3분
 *
 * @author gwon
 * @history
 *          2021. 3. 21. initial creation
 */
public class DiagonalDifference {

	/*
	 * Complete the 'diagonalDifference' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
	 */

	public static int diagonalDifference(List<List<Integer>> arr) {
		int aa = 0;
		int bb = 0;
		for (int i = 0; i < arr.size(); i++) {
			List<Integer> list = arr.get(i);
			aa += list.get(i);
		}

		for (int i = 0; i < arr.size(); i++) {
			List<Integer> list = arr.get(i);
			bb += list.get(arr.size() - 1 - i);
		}

		return Math.abs(aa - bb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> arr = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				arr.add(
				        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				                .map(Integer::parseInt)
				                .collect(Collectors.toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = DiagonalDifference.diagonalDifference(arr);

		bufferedReader.close();
	}
}
