import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_212_형성평가8 { // 제출일 2021-02-16 23:11

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 첫째 줄에 정수 n(2≤n≤100)을 입력받고
		// 다음 줄부터 n명 학생의 3과목 점수를 입력받아 평균을 구하여 점수가 높은 순으로 출력하시오.
		// 단, 평균은 소수 둘째 자리에서 반올림하여 소수 첫째 자리까지 출력하시오.

		int n = Integer.parseInt(br.readLine());
		double[] avg = new double[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			avg[i] = (double) sum / 3;
		}

		Arrays.parallelSort(avg);
		for (int i = n - 1; i >= 0; i--) {
			sb.append(String.format("%.1f", avg[i])).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}