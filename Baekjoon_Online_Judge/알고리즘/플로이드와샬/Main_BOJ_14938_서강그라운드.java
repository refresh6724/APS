import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14938_서강그라운드 { // 제출일 2020-02-04 10:00

	private static long result;	
	private static int n; // 지역의 개수 = vertex
	private static int m; // 수색 범위 = 최종적으로 이 숫자 이하
	private static int r; // 길의 개수 = 최초 연결 edge
	private static int[] item; // 각 지역 아이템 개수
	private static int[][] map; // 지도

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // delim 사용시 런타임 에러
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		item = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		map = new int[n+1][n+1]; // 1번 ~ n번
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				map[i][j] = 20;
			}
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[a1][a2] = d;
			map[a2][a1] = d;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			int cur = 0;
			for (int j = 1; j <= n; j++) {
				if (map[i][j] <= m) {
					cur += item[j];
				}
			}
			result = result < cur ? cur : result;
		}
		System.out.println(result);
	}
}
