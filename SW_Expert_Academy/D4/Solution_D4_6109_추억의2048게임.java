import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
// 제출일 2019-10-31 11:03 (풀이시간 10:16~11:03 약 40분)
public class Solution_D4_6109_추억의2048게임 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder answer;
	static int N;
	static String order;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			order = sc.next();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 입력 종료
			switch (order) {
			case "up":
				up();
				break;
			case "down":
				down();
				break;
			case "right":
				right();
				break;
			case "left":
				left();
				break;
			}

			// 정답 출력
			answer = new StringBuilder();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					answer.append(map[i][j]).append(" ");
				}
				answer.append("\n");
			}

			bw.write(String.format("#%d\n%s", tc, answer.toString()));
			bw.flush();
		}

	}

	private static void up() {
		// 행 또는 열 마다
		int i = 0;
		int j = 1;
		for (int col = 0; col < N; col++) {
			// 0 압축 // 위에 숫자가 있거나 갈 수 없을때까지 올린다
			i = 0;
			j = 1;
			while (i < j && i < N && j < N) {
				if (map[i][col] == 0) {
					if (map[j][col] != 0) {
						// swap(i,j);
						map[i][col] = map[j][col];
						map[j][col] = 0;
					} else {
						j++;
					}
				} else {
					i++;
					j++;
				}
			}

			// printMap();

			// 같으면 더하고, 더해준 값은 뺀다
			for (int row = 1; row < N; row++) {
				if (map[row][col] == map[row - 1][col]) {
					map[row - 1][col] <<= 1;
					map[row][col] = 0;
				}
			}
			// 0 압축
			i = 0;
			j = 1;
			while (i < j && i < N && j < N) {
				if (map[i][col] == 0) {
					if (map[j][col] != 0) {
						// swap(i,j);
						map[i][col] = map[j][col];
						map[j][col] = 0;
					} else {
						j++;
					}
				} else {
					i++;
					j++;
				}
			}
		}
	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

	private static void down() {
		// 행 또는 열 마다
		int i = 0;
		int j = 1;
		for (int col = 0; col < N; col++) {
			// 0 압축 // 위에 숫자가 있거나 갈 수 없을때까지 올린다
			i = N-1;
			j = N-2;
			while (i > j && i >= 0 && j >= 0) {
				if (map[i][col] == 0) {
					if (map[j][col] != 0) {
						// swap(i,j);
						map[i][col] = map[j][col];
						map[j][col] = 0;
					} else {
						j--;
					}
				} else {
					i--;
					j--;
				}
			}

			// printMap();

			// 같으면 더하고, 더해준 값은 뺀다
			for (int row = N-2; row >= 0; row--) {
				if (map[row][col] == map[row + 1][col]) {
					map[row + 1][col] <<= 1;
					map[row][col] = 0;
				}
			}
			// 0 압축
			i = N-1;
			j = N-2;
			while (i > j && i >= 0 && j >= 0) {
				if (map[i][col] == 0) {
					if (map[j][col] != 0) {
						// swap(i,j);
						map[i][col] = map[j][col];
						map[j][col] = 0;
					} else {
						j--;
					}
				} else {
					i--;
					j--;
				}
			}
		}
	}

	private static void right() {
		// 행 또는 열 마다
				int i = 0;
				int j = 1;
				for (int R = 0; R < N; R++) {
					// 0 압축 // 위에 숫자가 있거나 갈 수 없을때까지 올린다
					i = N-1;
					j = N-2;
					while (i > j && i >= 0 && j >= 0) {
						if (map[R][i] == 0) {
							if (map[R][j] != 0) {
								// swap(i,j);
								map[R][i] = map[R][j];
								map[R][j] = 0;
							} else {
								j--;
							}
						} else {
							i--;
							j--;
						}
					}

					// printMap();

					// 같으면 더하고, 더해준 값은 뺀다
					for (int col = N-2; col >= 0; col--) {
						if (map[R][col] == map[R][col+1]) {
							map[R][col + 1] <<= 1;
							map[R][col] = 0;
						}
					}
					// 0 압축
					i = N-1;
					j = N-2;
					while (i > j && i >= 0 && j >= 0) {
						if (map[R][i] == 0) {
							if (map[R][j] != 0) {
								// swap(i,j);
								map[R][i] = map[R][j];
								map[R][j] = 0;
							} else {
								j--;
							}
						} else {
							i--;
							j--;
						}
					}
				}
	}

	private static void left() {
		// 행 또는 열 마다
				int i = 0;
				int j = 1;
				for (int R = 0; R < N; R++) {
					// 0 압축 // 위에 숫자가 있거나 갈 수 없을때까지 올린다
					i = 0;
					j = 1;
					while (i < j && i < N && j < N) {
						if (map[R][i] == 0) {
							if (map[R][j] != 0) {
								// swap(i,j);
								map[R][i] = map[R][j];
								map[R][j] = 0;
							} else {
								j++;
							}
						} else {
							i++;
							j++;
						}
					}

					// printMap();

					// 같으면 더하고, 더해준 값은 뺀다
					for (int C = 1; C < N; C++) {
						if (map[R][C] == map[R][C-1]) {
							map[R][C-1] <<= 1;
							map[R][C] = 0;
						}
					}
					// 0 압축
					i = 0;
					j = 1;
					while (i < j && i < N && j < N) {
						if (map[R][i] == 0) {
							if (map[R][j] != 0) {
								// swap(i,j);
								map[R][i] = map[R][j];
								map[R][j] = 0;
							} else {
								j++;
							}
						} else {
							i++;
							j++;
						}
					}
				}
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(" ");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static long nextLong() {
			return Long.parseLong(next());
		}
	}
}
