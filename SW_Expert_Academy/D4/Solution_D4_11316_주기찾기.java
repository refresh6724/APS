import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_11316_주기찾기 { // 제출일 2021-02-01 15:15

	static int[] arr = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 0 <= s,p,q < m <= 10^6 = 1000000
		// 최소 0,0,0,1
		// 최대 999999,999999,999999,1000000
		// ps+q int 범위 초과

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int cnt = 1;
			Arrays.fill(arr, 0, m + 1, 0);
			int a = s;
			while (true) {
				a = (int) (((long) p * a + q) % m);
				if (arr[a] != 0) {
					answer = cnt - arr[a];
					break;
				}
				arr[a] = cnt++;
				s = a;
			}
			sb.append("#").append(i).append(' ').append(answer).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
