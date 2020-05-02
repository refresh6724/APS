import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_8500_극장좌석 { // 제출일 2020-05-02 23:51
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int n, ans, num, last, next, prev;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			n = Integer.parseInt(br.readLine());

			// 1번 테스트케이스
			// 2 3 2
			// 1번 사람은 좌우로 2개 좌석이 비어있다
			// 2번 사람은 좌우로 3개 좌석이 비어있다
			// 3번 사람은 좌우로 2개 좌석이 비어있다
			// 0010010001000
			// 정답 13

			// 2+1 + 2+1 + 3+1 + 마지막 수 3

			st = new StringTokenizer(br.readLine());
			int max = 0;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				int a = Integer.parseInt(st.nextToken());
				max = Math.max(max, a);
				sum += a;
			}
			sum += n + max;

			sb.append("#").append(tc).append(" ").append(sum).append(" ").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static void calc(int i, int j) {
		int num = arr[i] * arr[j];
		int last = num % 10;
		int next = num / 10;
		int prev = last;
		while (next != 0) {
			last = next % 10;
			if (last != prev - 1) {
				return;
			}
			next = next / 10;
			prev = last;
		}
		ans = num;
	}

}
