import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1331_문자마름모 { // 제출일 2021-02-26 21:54

	static int n;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new char[n * 2 - 1][n * 2 - 1];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], '_');
		}

		// 시작 위치 0, n-1 에서 좌하로 n-1 A B C
		// 다음 위치 n-1, 0 에서 우하로 n-1 D E F
		// 다음 위치 2(n-1), n-1 에서 우상으로 n-1 G H I
		// 다음 위치 n-1, 2(n-1)에서 좌상으로 n-1 J K L

		// 다음 위치 0 + '1', n-1에서 좌하로 n-1 -1
		// 다음 위치 n-1, 0 +'1' 에서 우하로 n-1 -1
		// 다음 위치 2(n-1) -'1', n-1 에서 우상으로
		// 다음 위치 n-1, 2(n-1) - '1'에서 좌상으로

		// 다음 위치 0 + 'n-1' 이라면 stop

		// 빈칸 채우기
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j < Math.abs(i - n); j++) {
				arr[i - 1][j] = ' ';
			}
		}

		// 글자 채우기
		char start = 'A';
		int nr = 0;
		int nc = 0;
		for (int i = 0; i < n - 1; i++) {
			// 좌하
			nr = 0 + i;
			nc = n - 1;
			for (int j = 0; j < n - 1 - i; j++) {
				arr[nr + j][nc - j] = start++;
				if (start > 'Z') {
					start = 'A';
				}
			}
			// 우하
			nr = n - 1;
			nc = 0 + i;
			for (int j = 0; j < n - 1 - i; j++) {
				arr[nr + j][nc + j] = start++;
				if (start > 'Z') {
					start = 'A';
				}
			}
			// 우상
			nr = 2 * (n - 1) - i;
			nc = n - 1;
			for (int j = 0; j < n - 1 - i; j++) {
				arr[nr - j][nc + j] = start++;
				if (start > 'Z') {
					start = 'A';
				}
			}
			// 좌상
			nr = n - 1;
			nc = 2 * (n - 1) - i;
			for (int j = 0; j < n - 1 - i; j++) {
				arr[nr - j][nc - j] = start++;
				if (start > 'Z') {
					start = 'A';
				}
			}
		}
		arr[n - 1][n - 1] = start;

		// 출력
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i][0]);
			for (int j = 1; j < arr[0].length; j++) {
				if (arr[i][j] == '_') {
					break;
				}
				sb.append(' ').append(arr[i][j]);
			}
			sb.append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}