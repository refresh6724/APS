import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1314_문자사각형2 { // 제출일 2021-02-18 23:24

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// nxn 사각형에 A~Z를 세로순 역세로 번갈아 출력
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];
		char start = 'A';
		for (int col = 0; col < n; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < n; row++) {
					arr[row][col] = start++;
					if (start > 'Z') {
						start = 'A';
					}
				}
			} else {
				for (int row = n - 1; row >= 0; row--) {
					arr[row][col] = start++;
					if (start > 'Z') {
						start = 'A';
					}
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