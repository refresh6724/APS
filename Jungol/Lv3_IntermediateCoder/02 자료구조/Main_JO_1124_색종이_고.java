import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1124_색종이_고 { // 제출일 2021-05-24 00:13

	static int n, sum;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine().trim());
		sum = 0;
		board = new int[100][100];
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for (int xx = x; xx < x + 10; xx++) {
				for (int yy = y; yy < y + 10; yy++) {
					board[yy][xx] = 1;
				}
			}
		}
	}

	private static void go() {
		// 좌측 하단이 0,0 우측 상단이 100, 100 좌표라 가정하고 풀면
		// board는 좌측 상단이 0,0 우측 하단이 100, 100이 되어 그림이 상하반전이라는 점을 감안해야 한다
		// 우선 바닥(y좌표가 0)부터 한 줄씩 우측으로 가면서 누적 길이를 board에 저장한다
		// 예를 들어 1 1 1 1 0 1 1 인 경우 1 2 3 4 0 1 2가 되도록 누적해준다
		for (int y = 0; y < 100; y++) {
			for (int x = 1; x < 100; x++) {
				if (board[y][x] != 0) {
					board[y][x] += board[y][x - 1];
				}
			}
		}

//		debug();

		// 누적이 끝났다면 다시 왼쪽(x좌표 0)부터 바닥에서 위로 올라가면서 높이를 카운팅한다
		// 같은 수라면 높이를 이어서 위 칸(y++)으로
		// 작아진다면 답을 갱신하고(종료하고) 새롭게 작은 수로 교환하여 위 칸으로 간다 이 때 높이는 이어받는다
		// 커진다면 답을 갱신하지 않고 현재 수를 그대로 가지는 노드와 새롭게 큰 수를 가지는 높이 1의 노드 둘로 나누어 진행한다

		for (int x = 0; x < 100; x++) {
			up(0 + 1, x, board[0][x], 1);
		}

	}

	private static void debug() {
		StringBuilder sb = new StringBuilder();
		sb.append("     x : ");
		for (int j = 0; j < 100; j++) {
			sb.append(String.format("%2d", j));
		}
		sb.append('\n');

		for (int i = 99; i >= 0; i--) {
			sb.append(String.format("y : %d  ", i));
			for (int j = 0; j < 100; j++) {
				sb.append(String.format("%2d", board[i][j]));
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	private static void up(int y, int x, int before, int height) {
		if (y == 100) {
			sum = Math.max(sum, height * before);
			return;
		}

//		테스트케이스 10번
//		if(x == 70 && board[y][x] == 31) {
//			System.out.println("debug");
//		}

		if (board[y][x] == before) {
			up(y + 1, x, before, height + 1);
		} else if (board[y][x] < before) {
			sum = Math.max(sum, height * before);
			up(y + 1, x, board[y][x], height + 1);
		} else if (board[y][x] > before) {
			// 매번 두 가지로 분화하여 진행하면 계속 2배로 증가하므로 작아지는 지점을 찾아 바로 계산
			int start = y - 1;
			while (start >= 0) {
				if (board[start][x] < before) {
					break;
				}
				start--;
			}
			int end = y + 1;
			while (end < 100) {
				if (board[end][x] < before) {
					break;
				}
				end++;
			}
			sum = Math.max(sum, (end - start - 1) * before);
			up(y + 1, x, board[y][x], 1);
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(sum);
		bw.write(sb.toString());
		bw.flush();
	}

}