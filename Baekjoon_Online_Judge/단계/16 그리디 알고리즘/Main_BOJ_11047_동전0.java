import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11047_동전0 { // 제출일 2020-12-14 22:48 14520 kb 132 ms

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0, mok = 0;
		while (k != 0) {
			mok = k / coin[--n];
			k -= coin[n] * mok;
			ans += mok;
		}
		System.out.println(ans);
	}

}
