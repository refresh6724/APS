import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D0_5644_무선충전 {
	// 최적의 Battery Charger를 구하자
	// 시뮬레이션 + 매초 최적의 순열 찾기

	// 10*10 맵이 주어진다
	static int N;

	// 사용자는 두명이고 1,1과 10,10에서 출발한다
	static int M; // 총 이동시간 20~100, 0초부터 계산해야한다
	static int A; // BC 개수 1~8
	static int C; // 충전 범위 1~4
	static int[] P; // 성능 10 ~ 500

	static ArrayList<Integer>[][] list;

	static int[] moveA;
	static int[] moveB;

	static int[] recordA;
	static int[] recordB;

	static StringTokenizer st;
	static int[] memoization;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = Integer.parseInt(sc.nextLine());
		N = 11;
		for (int tc = 1; tc <= TC; tc++) {
			list = new ArrayList[N][N];
			for (int i = 0; i < N; i++) { // 1~10 사용
				for (int j = 0; j < N; j++) {
					list[i][j] = new ArrayList<>();
				}
			}
			st = new StringTokenizer(sc.nextLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			moveA = new int[M + 1];
			st = new StringTokenizer(sc.nextLine(), " ");
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			moveA[M] = 0;
			moveB = new int[M + 1];
			st = new StringTokenizer(sc.nextLine(), " ");
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			moveB[M] = 0;
			P = new int[A];
			for (int bc = 0; bc < A; bc++) {
				st = new StringTokenizer(sc.nextLine(), " ");
				int Y = Integer.parseInt(st.nextToken());
				int X = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());
				P[bc] = Integer.parseInt(st.nextToken());

				for (int row = X - C; row <= X + C; row++) {
					for (int col = Y - C; col <= Y + C; col++) {
						if (row < 1 || row >= N || col < 1 || col >= N)
							continue;
						if (abs(row - X) + abs(col - Y) > C)
							continue;
						// System.out.printf("bc : %d, row : %d, col : %d\n", bc, row, col);
						list[row][col].add(bc);
					}
				}
			}

			// 입력 종료

			int time = 0;
			int Ax = 1;
			int Ay = 1;
			int Bx = 10;
			int By = 10;
			int sum = 0;
			answer = 0;
			memoization = new int[M + 1];
			go(time, Ax, Ay, Bx, By, sum);
			System.out.printf("#%d %d\n", tc, answer);

		}
	}

	// 0 이동 안함 1상 2우 3하 4좌
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	private static void go(int time, int ax, int ay, int bx, int by, int sum) {
		if (time > 0 && sum < memoization[time - 1])
			return;
		if (time > 0 && sum > memoization[time - 1])
			memoization[time - 1] = sum;

		if (time > M) {
			if (sum > answer)
				answer = sum;
			return;
		}
		// A,B가 선택한 번호가 같다면 절반씩 더하기
		int selectA = list[ax][ay].size(); // A가 선택할 수 있는 경우의 수
		int selectB = list[bx][by].size(); // B가 선택할 수 있는 경우의 수
		int choiceA = 0;
		int choiceB = 0;

		// A,B 둘다 0인 경우
		// 하나만 0인 경우
		// 둘다 0이 아닌경우 총 4가지
		if (selectA != 0 && selectB != 0) {
			for (int i = 0; i < selectA; i++) {
				for (int j = 0; j < selectB; j++) {
					choiceA = list[ax][ay].get(i);
					choiceB = list[bx][by].get(j);
					if (choiceA == choiceB) {
						go(time + 1, ax + dx[moveA[time]], ay + dy[moveA[time]], bx + dx[moveB[time]],
								by + dy[moveB[time]], sum + P[choiceA]);
					} else {
						go(time + 1, ax + dx[moveA[time]], ay + dy[moveA[time]], bx + dx[moveB[time]],
								by + dy[moveB[time]], sum + P[choiceA] + P[choiceB]);
					}
				}
			}
		} else if (selectA == 0 && selectB != 0) {
			for (int i = 0; i < selectB; i++) {
				choiceB = list[bx][by].get(i);
				go(time + 1, ax + dx[moveA[time]], ay + dy[moveA[time]], bx + dx[moveB[time]], by + dy[moveB[time]],
						sum + P[choiceB]);
			}
		} else if (selectB == 0 && selectA != 0) {
			for (int i = 0; i < selectA; i++) {
				choiceA = list[ax][ay].get(i);
				go(time + 1, ax + dx[moveA[time]], ay + dy[moveA[time]], bx + dx[moveB[time]], by + dy[moveB[time]],
						sum + P[choiceA]);
			}
		} else {
			go(time + 1, ax + dx[moveA[time]], ay + dy[moveA[time]], bx + dx[moveB[time]], by + dy[moveB[time]], sum);
		}

	}

	private static int abs(int i) {
		return i >= 0 ? i : -i;
	}
}
