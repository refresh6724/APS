import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10250
 */
public class Main_BOJ_10250_ACM호텔 { // 제출일 2020-11-02 23:17

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			// 6*12 칸에서
			// 순서대로 101 201 ... 601 102 를 주어
			// 10번째 손님에게 402호를 주는 방식

			int mok = (n - 1) / h; // 뒷자리를 결정
			mok += 1;
			int nam = n % h; // 앞자리를 결정
			if (nam == 0) {
				nam = h;
			}

			if (mok < 10) {
				System.out.println(String.format("%d0%d", nam, mok));
			} else {
				System.out.println(String.format("%d%d", nam, mok));
			}
		}
	}
}
