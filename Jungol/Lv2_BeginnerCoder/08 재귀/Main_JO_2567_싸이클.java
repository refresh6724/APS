import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2567_싸이클 { // 제출일 2021-04-03 23:21

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n, p, s, cnt, next;
		int[] visited = new int[1001];

		n = Integer.parseInt(st.nextToken()); // 1 이상 1천 이하
		p = Integer.parseInt(st.nextToken()); // 2 이상 97 이하
		s = (n * n) % p;
		cnt = 1;

		next = s;
		visited[s] = cnt;
		do {
			next = (next * n) % p;
			cnt += 1;
			if (visited[next] != 0) {
				cnt = cnt - visited[next];
				break;
			}
			visited[next] = cnt;
		} while (next != s);

		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
	}

}