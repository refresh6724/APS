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
	 * 새치기한 사람 수를 리턴. 단, 한명이 3명을 제쳤을 경우 Too chaotic 출력 21534 2번이 1번을 제치고, 5번이 4, 3번을
	 * 제친 경우 3 출력 21543 2번이 1번을 제치고, 5번이 4, 3번을 제치고 4번이 3번을 제친 경우 4 출력 125463 4
	 * 134562 4 145623 6 145632 7 정확한 제한 조건이 안나와있어서 Too chaotic이 출력되는 기준을 모르겠다
	 */

	public static void minimumBribes(List<Integer> q) {

		int[] arr = new int[q.size()];
		Iterator<Integer> it = q.iterator();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = it.next();
		}

		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
			for (int j = Math.max(0, arr[i] - 2); j < i; j++) {
				if (arr[j] > arr[i]) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}

public class Solution_NewYearChaos_Medium {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

				Result.minimumBribes(q);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}
}
