import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_1016_제곱ㄴㄴ수 { // 제출일 2021-11-07 23:26

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());

		// 1 ≤ min ≤ 1,000,000,000,000
		// min ≤ max ≤ min + 1,000,000
		// min 보다 크거나 같고, max보다 작은 제곱ㄴㄴ수의 개수
		//
		// 1 10 > 7
		// 정수 1, 2, 3 은 1보다 큰 제곱수 4, 9, 16 으로 나누어 떨어지지 않는 수
		// 정수 4는 1보다 큰 제곱수 4로 나누어 떨어진다
		// 정수 5, 6, 7은 4로 나누어 떨어지지 않고 9 미만이므로 제곱ㄴㄴ수이다.
		// 정수 8은 4로 정수 9는 9로 나누어 떨어진다
		// 정수 10은 4나 8로 나누어 떨어지지 않는다
		// 1,2,3,5,6,7,10 > 7개

		// 4의 배수, 9의 배수, 16의 배수, 25의 배수

		boolean[] nonosu = new boolean[(int) (max - min) + 1];

		for (int j = 2; j < 1100000; j++) {
			long jj = (long) j * j;
			if (jj > max) {
				break;
			}

			long mok = min / jj;
			long least = jj * mok;
			if (least < min) {
				least += jj;
			}
			for (long check = least; check <= max; check += jj) {
				nonosu[(int) (check - min)] = true;
			}

		}

		int cnt = 0;
		for (long i = min; i <= max; i++) {
			if (!nonosu[(int) (i - min)]) {
				cnt++;
			}
		}
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
	}

}