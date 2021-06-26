
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_2251_전구 { // 제출일 2021-06-26 23:30

	static int n;
	static int[] swch, bulb;

	public static void main(String[] args) throws Exception {
		input();
		go();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine().trim()); // 전구와 스위치의 수 1 이상 1만 이하
		swch = new int[n + 1];
		bulb = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			swch[num] = i;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			bulb[i] = Integer.parseInt(st.nextToken());
		}

		// 12345 순서
		// 24153 스위치
		// 45132 전구
		// 24351 역위치
		// 12231 LIS
		// 스위치 2번이 전구2번을 켠다
		// 첫번째 스위치가 다섯번째 전구를 켠다

	}

	private static void go() throws Exception {
		// 1 역위치 계산
		int[] rev = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			rev[i] = swch[bulb[i]];
		}
		// 2 LIS
		int[] prev = new int[n + 1];
		int[] lis = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (rev[i] > rev[j] && lis[i] < lis[j] + 1) {
					prev[i] = j;
					lis[i] = lis[j] + 1;
				}
			}
		}
		// 3 최댓값 찾기
		int maxIdx = 0;
		int maxVal = 0;
		for (int i = 1; i < lis.length; i++) {
			if (lis[i] > maxVal) {
				maxVal = lis[i];
				maxIdx = i;
			}
		}
		// 4 스위치 찾기
		int[] ans = new int[maxVal];
		int idx = 0;
		ans[idx++] = bulb[maxIdx];
		int sw = prev[maxIdx];
		while (sw != 0) {
			ans[idx++] = bulb[sw];
			sw = prev[sw];
		}
		Arrays.parallelSort(ans);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(maxVal).append('\n');
		sb.append(ans[0]);
		for (int i = 1; i < maxVal; i++) {
			sb.append(' ').append(ans[i]);
		}
		bw.write(sb.toString());
		bw.flush();
	}

}