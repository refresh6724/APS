import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_15953_상금헌터 { // 제출일 2020-05-09 11:59

	static int[][] prize2017 = { { 0, 0 }, { 500, 1 }, { 300, 2 }, { 200, 3 }, { 50, 4 }, { 30, 5 }, { 10, 6 } };
	static int[][] prize2018 = { { 0, 0 }, { 512, 1 }, { 256, 2 }, { 128, 4 }, { 64, 8 }, { 32, 16 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// 1회 본선 진출 a등, 2회 본선 진출 b등
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int sum = 0;
			if (a != 0) {
				if (a < 2) { // 1등
					sum += prize2017[1][0];
				} else if (a < 4) { // 2-3등
					sum += prize2017[2][0];
				} else if (a < 7) { // 4-6등
					sum += prize2017[3][0];
				} else if (a < 11) { // 7-10등
					sum += prize2017[4][0];
				} else if (a < 16) { // 11-15등
					sum += prize2017[5][0];
				} else if (a < 22) { // 16-21등
					sum += prize2017[6][0];
				}
			}

			if (b != 0) {
				if (b < 1 << 1) { // b == 1
					sum += prize2018[1][0];
				} else if (b < 1 << 2) {
					sum += prize2018[2][0];
				} else if (b < 1 << 3) {
					sum += prize2018[3][0];
				} else if (b < 1 << 4) {
					sum += prize2018[4][0];
				} else if (b < 1 << 5) {
					sum += prize2018[5][0];
				}
			}
			sb.append(sum * 10000).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
