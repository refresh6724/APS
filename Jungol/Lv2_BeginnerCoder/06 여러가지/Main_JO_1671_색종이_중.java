import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1671_색종이_중 { // 제출일 2021-03-14 22:56
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		boolean[][] paper = new boolean[101][101];
		int n = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// 두 개의 자연수
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for (int j = a; j < a + 10; j++) {
				for (int k = b; k < b + 10; k++) {
					paper[j][k] = true;
				}
			}

		}

		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] != paper[i][j + 1]) {
					sum++;
				}
				if (paper[j][i] != paper[j + 1][i]) {
					sum++;
				}
			}
		}
		sb.append(sum);

		bw.write(sb.toString());
		bw.flush();
	}

}