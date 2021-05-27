import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_1004_어린왕자 { // 제출일 2020-06-14 01:22 14440 kb 108 ms

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {

			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 도착점과 출발점을 잇는 직선 방정식 ax+by+c = 0
			// x1 != x2 일때 y = (y2-y1)/(x2-x1) * (x-x1) + y1
			// (y2-y1)x + (x1-x2) y + (x2y1 - x1y2) = 0
			// x1 == x2 일때 x = x1
			int n = Integer.parseInt(br.readLine());
			// n 개의 원에 대해
			// 시작점이나 끝점 중 하나만 원 안에 포함되는 경우 answer++
			int answer = 0;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				// 원의 방정식 (x-cx)^2 + (y-cy)^2 = r^2
				boolean c1 = (r * r) > (x1 - cx) * (x1 - cx) + (y1 - cy) * (y1 - cy);
				boolean c2 = (r * r) > (x2 - cx) * (x2 - cx) + (y2 - cy) * (y2 - cy);
				// 둘 중 하나만 true 여야 한다
				if (c1 ^ c2) {
					answer++;
				}
			}
			bw.write(String.valueOf(answer) + "\n");
		}
		bw.flush();
	}

}