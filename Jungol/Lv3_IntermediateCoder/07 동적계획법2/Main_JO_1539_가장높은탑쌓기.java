import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 요약 : LIS 응용
public class Main_JO_1539_가장높은탑쌓기 { // 제출일 2021-06-25 23:39

	static int n;
	static int[] link, tower;
	static int[][] block;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine().trim()); // 벽돌의 수 최대 100개
		block = new int[n + 1][4];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int area = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			block[i] = new int[] { i, area, height, weight };
		}
		link = new int[n + 1];
		tower = new int[n + 1];

//		(조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
//		(조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
//		(조건3) 벽돌들의 높이는 같을 수도 있다.
//		(조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
//		(조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.

		Arrays.sort(block, (o1, o2) -> o1[1] - o2[1]); // 면적을 기준으로 오름차순 정렬
		// 4개가 주어지고
		// 면적, 높이, 무게, prev, tower
		// 0 0 0 0 0
		// 1 5 2 0 5
		// 4 4 6 1 9
		// 9 2 3 1 7
		// 16 2 5 3 9
		// 25 3 4 3 10

		link[0] = -1;
		for (int i = 1; i <= n; i++) {
			// 면적을 기준으로 정렬했으므로 j번째 면적은 i번째 면적보다 무조건 작다
			for (int j = 0; j < i; j++) {
				if (block[j][3] < block[i][3] && tower[i] < tower[j] + block[i][2]) {
					link[i] = j;
					tower[i] = tower[j] + block[i][2];
				}
			}
		}

		int maxIdx = 0;
		int maxHgt = 0;
		for (int i = 1; i <= n; i++) {
			if (maxHgt < tower[i]) {
				maxIdx = i;
				maxHgt = tower[i];
			}
		}

		//
		Stack<Integer> order = new Stack<>();
		order.add(block[maxIdx][0]);
		int idx = link[maxIdx];
		int cnt = 1;
		while (idx != 0) {
			order.add(block[idx][0]);
			idx = link[idx];
			cnt++;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append('\n');
		while (!order.isEmpty()) {
			sb.append(order.pop()).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

}