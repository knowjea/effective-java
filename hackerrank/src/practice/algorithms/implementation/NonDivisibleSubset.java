package practice.algorithms.implementation;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

/**
 * 부분집합에 들어있는 값 2개 선택해서 더했을때 k의 배수가 아닌것을 만족하는 부분집합의 최대 사이즈 개수
 * (문제 예제가 잘못된거 아닌가?set of distinct integers 인데, 10이 두 개가 들어있음)
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 *
 * 코딩시간 : 40분 고민해도 모르겠따!
 *
 * @author gwon
 * @history
 *          2021. 4. 3. initial creation
 */
public class NonDivisibleSubset {

	/*
	 * Complete the 'nonDivisibleSubset' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 * 1. INTEGER k
	 * 2. INTEGER_ARRAY s
	 */

	public static int nonDivisibleSubset(int k, List<Integer> s) {

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
		        .map(Integer::parseInt)
		        .collect(toList());

		int result = NonDivisibleSubset.nonDivisibleSubset(k, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
