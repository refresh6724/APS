import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1438_색종이_초 { // 제출일 2021-03-14 21:33

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		boolean[][] paper = new boolean[100][100];
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
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if (paper[j][k]) {
					sum++;
				}
			}
		}
		sb.append(sum);

		bw.write(sb.toString());
		bw.flush();
	}

}