import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_1931_회의실배정 { // 제출일 2020-12-15 23:48 41944 kb 544 ms

	static int[][] time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 최대 10만
		// 각 시작시간 종료시간에 대해 겹치지 않게 최대 몇 개를 넣을 수 있는지 확인
		// 정렬 문제
		time = new int[n][2];
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		// 끝나는 시간이 같을 때 더 빨리 시작되는 쪽을 먼저
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		// Arrays.sort(time, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
		int end = time[0][1];
		int ans = 1;
		for (int i = 1; i < n; i++) {
			if (time[i][0] >= end) {
				end = time[i][1];
				ans += 1;
			}
		}
		System.out.println(ans);
	}

}
