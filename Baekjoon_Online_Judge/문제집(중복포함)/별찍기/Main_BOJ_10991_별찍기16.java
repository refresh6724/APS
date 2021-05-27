import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_10991_별찍기16 { // 제출일 2020-02-25 21:10
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		// 시작 위치 0, n-1 부터 i개를 n줄 출력
		
		int start = n-1;
		for (int row = 0; row < n; row++) {
			for (int i = 0; i < start; i++) {
				sb.append(" ");
			}
			sb.append("*");
			for (int repeat = 0; repeat < row; repeat++) {
				sb.append(" ").append("*");
			}
			sb.append("\n");
			start--;
		}

		System.out.println(sb.toString());

	}

}