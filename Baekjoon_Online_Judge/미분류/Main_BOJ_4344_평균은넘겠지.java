import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_4344_평균은넘겠지 { // 제출일 2020-10-04 23:36

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int c = Integer.parseInt(br.readLine());
		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			double avg = 0;
			int[] score = new int[n];
			for (int j = 0; j < n; j++) {
				score[j] = Integer.parseInt(st.nextToken());
				avg += score[j];
			}
			avg /= n;
			double cnt = 0;
			for (int j = 0; j < n; j++) {
				if (avg < score[j]) {
					cnt++;
				}
			}
			cnt *= 100;
			cnt /= n;
			sb.append(String.format("%.3f%%\n", cnt));
		}
		bw.write(sb.toString());
		bw.flush();
	}

}