import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2259_참외밭 { // 제출일 2021-03-20 23:24

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int mul = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[7][2];
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			// 동 1 서 2 남 3 북 4
			map[i][0] = Integer.parseInt(st.nextToken());
			// 길이
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		map[6][0] = map[0][0];
		map[6][1] = map[0][1];

		// 가장 긴 동서 * 남북 거리에서 세번째로 나오는 동서 * 남북 거리를 뺀다
		// 반시계방향으로 이동 42314231
		// 즉 시계방향일 경우 41324132 그 곳이 빼야하는 넓이가 된다

		int max12 = 0;
		int max34 = 0;
		for (int i = 0; i < 6; i++) {
			if (map[i][0] == 1 || map[i][0] == 2) {
				max12 = Math.max(max12, map[i][1]);
			} else {
				max34 = Math.max(max34, map[i][1]);
			}
		}
		int minus = 0;
		for (int i = 0; i < 6; i++) {
			if (map[i][0] == 4 && map[i + 1][0] == 1) {
				minus = map[i][1] * map[i + 1][1];
				break;
			} else if (map[i][0] == 1 && map[i + 1][0] == 3) {
				minus = map[i][1] * map[i + 1][1];
				break;
			} else if (map[i][0] == 3 && map[i + 1][0] == 2) {
				minus = map[i][1] * map[i + 1][1];
				break;
			} else if (map[i][0] == 2 && map[i + 1][0] == 4) {
				minus = map[i][1] * map[i + 1][1];
				break;
			}
		}
		sb.append(mul * (max12 * max34 - minus));

		bw.write(sb.toString());
		bw.flush();
	}

}