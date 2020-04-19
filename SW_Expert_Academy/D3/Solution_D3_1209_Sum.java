import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1209_Sum { // 제출일 2020-04-19 23:43
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

//		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= 10; tc++) {

			int t = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;

			for (int row = 0; row < 100; row++) {
				int temp = 0;
				for (int col = 0; col < 100; col++) {
					temp += arr[row][col];
				}
				if (temp > max) {
					max = temp;
				}
			}

			for (int col = 0; col < 100; col++) {
				int temp = 0;
				for (int row = 0; row < 100; row++) {
					temp += arr[row][col];
				}
				if (temp > max) {
					max = temp;
				}
			}

			// 대각선?

			sb.append("#").append(tc).append(" ").append(max).append(" ").append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

}
