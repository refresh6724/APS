import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * 6*6 배열에서 I 모양의 합 중 최대값을 리턴
	 */

	static int[][] map;

	public static int hourglassSum(List<List<Integer>> arr) {
		map = new int[6][6];
		int idx = 0;
		for (List<Integer> row : arr) {
			map[idx++] = row.stream().mapToInt(x->x).toArray();			
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				max = Math.max(max, sum(i,j));
			}
		}
		return max;
	}

	private static int sum(int i, int j) {
		int ret = 0;
		ret += map[i][j] + map[i][j+1] + map[i][j+2];
		ret += map[i+1][j+1];
		ret += map[i+2][j]+ map[i+2][j+1] + map[i+2][j+2];
		return ret;
	}

}

public class Solution_2D_Array_DS_Easy {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		List<List<Integer>> arr = new ArrayList<>();

		IntStream.range(0, 6).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = Result.hourglassSum(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
