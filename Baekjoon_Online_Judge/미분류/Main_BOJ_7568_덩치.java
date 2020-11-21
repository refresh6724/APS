import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7568
 */
public class Main_BOJ_7568_덩치 { // 제출일 2020-11-21 23:02

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] body = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			body[i][0] = Integer.parseInt(st.nextToken());
			body[i][1] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int k = 1;
			for (int j = 0; j < N; j++) {
				if(body[i][0] < body[j][0] && body[i][1] < body[j][1]) {
					k++;
				}
			}
			sb.append(k).append(' ');
		}
		System.out.println(sb.toString().trim());
	}

}
