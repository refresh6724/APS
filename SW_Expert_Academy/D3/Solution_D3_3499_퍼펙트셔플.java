import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플 { // 제출일 2020-07-02 01:18 24,852 kb 125 ms

	static String[] cards = new String[1000];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cards[i] = st.nextToken();
			}

			sb.append('#').append(tc);
			int pivot = (N - 1) / 2;

			for (int i = 0, j = pivot + 1; j < N; i++, j++) {
				sb.append(' ').append(cards[i]).append(' ').append(cards[j]);
			}

			if (N % 2 == 1) {
				sb.append(' ').append(cards[pivot]);
			}

			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}
}