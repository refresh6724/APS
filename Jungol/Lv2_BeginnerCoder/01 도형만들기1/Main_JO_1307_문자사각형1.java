import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1307_문자사각형1 { // 제출일 2021-02-18 23:18

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// nxn 사각형에 A~Z를 역세로순으로 출력
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];
		char start = (char) (((n * n) % 26 - 1) % 26 + 'A');
		for (int col = 0; col < n; col++) {
			for (int row = 0; row < n; row++) {
				arr[row][col] = start--;
				if (start < 'A') {
					start = 'Z';
				}
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(arr[i][0]);
			for (int j = 1; j < n; j++) {
				sb.append(' ').append(arr[i][j]);
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

}