import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_10992_별찍기17 { // 제출일 2020-02-25 21:17
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		// 시작 위치 0, n-1 부터 i개를 n줄 출력
		// 15와 같으나 마지막 줄만 풀로 출력한다

		// 첫줄 n-1개의 빈칸 + 하나의 별
		for (int j = 0; j < n - 1; j++) {
			sb.append(" ");
		}
		sb.append("*").append("\n");

		// 중간 줄 n-1-i개의 빈칸 + 별 +
		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j < (n << 1); j++) {
				if (j == n - 1 - i) {
					sb.append("*");
				} else if (j == n - 1 + i) {
					sb.append("*");
					break;
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}

		if (n > 1) {
			for (int i = 1; i < (n << 1); i++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

}