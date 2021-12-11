import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

	public static int luckBalance(int k, List<List<Integer>> contests) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int sum = 0;
		for (List<Integer> contest : contests) {
			int L = contest.get(0);
			int T = contest.get(1);
			if (T == 1) {
				pq.add(L);
			} else {
				sum += L;
			}
		}
		while (k-- > 0 && !pq.isEmpty()) {
			sum += pq.poll();
		}
		while (!pq.isEmpty()) {
			sum -= pq.poll();
		}
		return sum;

	}

}

public class Solution_LuckBalance_Easy {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> contests = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				contests.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = Result.luckBalance(k, contests);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
