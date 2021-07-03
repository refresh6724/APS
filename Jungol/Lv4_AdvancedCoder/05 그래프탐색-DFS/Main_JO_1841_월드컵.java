import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1841_월드컵 { // 제출일 2021-07-04 06:28

	static int[][][] table;
	static int[][] now;
	static int[] answer, win, draw, lose, teamA, teamB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 6개국이 서로 한번씩, 각 국가별로 5번의 경기를 치른다
		// 첫째 줄부터 넷째 줄까지
		// 각 줄마다 6개국의 결과가 나라별로 승,무,패 순서로 18개 숫자로 주어진다
		answer = new int[4];
		int wdl = 0;
		table = new int[4][6][3]; // win draw lose
		now = new int[6][3];
		teamA = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
		teamB = new int[] { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			for (int j = 0; j < 6; j++) {
				wdl = 0;
//				for (int k = 0; k < 3; k++) {
//					now[j][k] = Integer.parseInt(st.nextToken());
//					wdl += now[j][k];
//				}
				win[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
				wdl += win[j] + draw[j] + lose[j];
				if (wdl != 5) {
					break;
				}
			}
			// 개별국가에 있어 승무패의 합이 5가 아니면 오류이므로 0을 기록한다
			if (wdl != 5) {
				continue;
			} else {
//				dfs_2d(i, 0, 1);
				dfs_1d(i, 0);
			}
		}
		// 입력에서 주어진 각 줄에 대해서 가능한 결과라면 1을 아니라면 0을 출력
//		now = new int[6][3];
//		dfs_3d(0, 1);
		System.out.println(String.format("%d %d %d %d", answer[0], answer[1], answer[2], answer[3]));
	}

	// 게임별로 승무패를 1차원 배열로 관리
	// Success(100) 249 ms
	private static void dfs_1d(int idx, int game) {
		if (answer[idx] == 1) {
			return;
		}

		if (game > 14) {
			answer[idx] = 1;
			return;
		}

		int a = teamA[game];
		int b = teamB[game];

		if (win[a] > 0 && lose[b] > 0) {
			win[a]--;
			lose[b]--;
			dfs_1d(idx, game + 1);
			if (answer[idx] == 1) {
				return;
			}
			win[a]++;
			lose[b]++;
		}

		if (draw[a] > 0 && draw[b] > 0) {
			draw[a]--;
			draw[b]--;
			dfs_1d(idx, game + 1);
			if (answer[idx] == 1) {
				return;
			}
			draw[a]++;
			draw[b]++;
		}

		if (lose[a] > 0 && win[b] > 0) {
			lose[a]--;
			win[b]--;
			dfs_1d(idx, game + 1);
			if (answer[idx] == 1) {
				return;
			}
			lose[a]++;
			win[b]++;
		}

	}

	// 이번엔 전체를 탐색하지 않고
	// 현재 있는 값으로 가능한 경기만 확인
	// 2차원 배열 사용
	// Success(100) 373 ms
	private static void dfs_2d(int idx, int a, int b) {
		if (answer[idx] == 1) {
			return;
		}

		if (b == 6) {
			a++;
			b = a + 1;
		}

		if (a == 5) { // 마지막 15번째 5번과 6번의 경기까지 끝났다면
			answer[idx] = 1;
			return;
		}

		if (now[a][0] > 0 && now[b][2] > 0) {
			now[a][0]--;
			now[b][2]--;
			dfs_2d(idx, a, b + 1);
			if (answer[idx] == 1) {
				return;
			}
			now[a][0]++;
			now[b][2]++;
		}

		if (now[a][1] > 0 && now[b][1] > 0) {
			now[a][1]--;
			now[b][1]--;
			dfs_2d(idx, a, b + 1);
			if (answer[idx] == 1) {
				return;
			}
			now[a][1]++;
			now[b][1]++;
		}

		if (now[a][2] > 0 && now[b][0] > 0) {
			now[a][2]--;
			now[b][0]--;
			dfs_2d(idx, a, b + 1);
			if (answer[idx] == 1) {
				return;
			}
			now[a][2]++;
			now[b][0]++;
		}

	}

	// 완전 탐색 dfs backtracking
	// 3차원 배열 사용
	// 15경기의 승패를 모두 체크 = 3^15
	// Time Limit Exceed(90) 1083 ms
	private static void dfs_3d(int a, int b) {
		if (b == 6) {
			a++;
			b = a + 1;
		}
		if (a == 5) {
			for (int i = 0; i < 4; i++) {
				if (answer[i] == 0 && isTableEqualNow(i)) {
					answer[i] = 1;
				}
			}
			return;
		}

		// 승 패
		now[a][0]++;
		now[b][2]++;
		dfs_3d(a, b + 1);
		now[a][0]--;
		now[b][2]--;
		// 무 무
		now[a][1]++;
		now[b][1]++;
		dfs_3d(a, b + 1);
		now[a][1]--;
		now[b][1]--;
		// 패 승
		now[a][2]++;
		now[b][0]++;
		dfs_3d(a, b + 1);
		now[a][2]--;
		now[b][0]--;
	}

	private static boolean isTableEqualNow(int idx) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (now[i][j] != table[idx][i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
