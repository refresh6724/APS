import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'countSwaps' function below.
	 *
	 * The function accepts INTEGER_ARRAY a as parameter.
	 */

	public static void countSwaps(List<Integer> a) {

		int n = a.size();
		int[] arr = a.stream().mapToInt(x -> x).toArray();
		int swap = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					swap++;
				}
			}
		}

		System.out.println(String.format("Array is sorted in %d swaps.", swap));
		System.out.println(String.format("First Element: %d", arr[0]));
		System.out.println(String.format("Last Element: %d", arr[n - 1]));

	}

}

public class Solution_Sorting_BubbleSort_Easy {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

		Result.countSwaps(a);

		bufferedReader.close();
	}
}
