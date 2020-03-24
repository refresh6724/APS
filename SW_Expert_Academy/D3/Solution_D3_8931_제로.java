import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D3_8931_제로 { // 제출일 2020-03-24 23:17

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int k = Integer.parseInt(br.readLine());

			Stack<Integer> s = new Stack<Integer>();
			for (int i = 0; i < k; i++) {
				int j = Integer.parseInt(br.readLine());
				if (j == 0) {
					s.pop();
				} else {
					s.add(j);
				}
			}

			int ans = 0;
			while (!s.isEmpty()) {
				ans += s.pop();
			}

			sb.append("#" + tc + " " + ans + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
