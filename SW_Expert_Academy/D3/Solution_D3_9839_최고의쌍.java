import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;
// 기존 제출일 2020-05-01 23:52 108,420kb 700ms
// 개선 제출일 2020-05-02 00:38  34,976kb 237ms
public class Solution_D3_9839_최고의쌍 { 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int n, ans, num, last, next, prev;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			n = Integer.parseInt(br.readLine());
			// n 개의 숫자가 주어지면 그 중 둘을 골라 곱하고
			// 그 수가 오름차순이면 정답 후보다
			// n이 1000이므로 nC2 = 499,500

			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			ans = -1;
			Arrays.sort(arr);

			for (int i = n - 1; i > 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					calc(i,j);					
				}		
				if(ans != -1) break;
			}

			sb.append("#").append(tc).append(" ").append(ans).append(" ").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static void calc(int i, int j) {
		int num = arr[i] * arr[j];
		int last = num % 10;
		int next = num / 10;
		int prev = last;
		while (next != 0) {
			last = next % 10;
			if (last != prev - 1) {
				return;
			}
			next = next / 10;
			prev = last;
		}
		ans = num;
	}

}
