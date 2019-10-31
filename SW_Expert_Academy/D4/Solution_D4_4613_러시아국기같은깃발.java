import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// 제출일 2019-10-31 10:16 (풀이시간 9:30 ~ 10:16, 약 30분)
public class Solution_D4_4613_러시아국기같은깃발 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;

	static int N;
	static int M;
	static int[][] map;
	static int[][] paint;
	static final int WHITE = 0;
	static final int BLUE = 1;
	static final int RED = 2;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {			
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			paint = new int[N][3];
			char[] arr;
			for (int i = 0; i < N; i++) {
				arr = sc.next().toCharArray();
				for (int j = 0; j < M; j++) {					
					switch(arr[j]) {
					case 'W':
						map[i][j] = 0;
						paint[i][BLUE]++;
						paint[i][RED]++;
						break;
					case 'B':
						map[i][j] = 1;
						paint[i][WHITE]++;
						paint[i][RED]++;
						break;
					case 'R':
						map[i][j] = 2;
						paint[i][WHITE]++;
						paint[i][BLUE]++;
						break;
					}
				}
			}
			// 입력 종료
			
			
			// 0번 행은 W 고정
			// N-1번 행은 R 고정이므로 미리 더해준다.
			answer = 0;
			for (int i = 0; i < M; i++) {
				if(map[0][i] != WHITE) answer++;
			}
			for (int i = 0; i < M; i++) {
				if(map[N-1][i] != RED) answer++;
			}
			
			
			// 1번 ~ N-2번행까지 선택지를 가질 수 있다
			// 분기 처리하기 이전에 모두 블루인 경우를 최저값으로 잡고 시작
			int sum = answer;
			for (int i = 1; i <= N-2 ; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] != BLUE) answer++;
				}
			}
			int line = 1;
			int state = WHITE;
			
			go(line, state, sum);		
			
			
			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
		}
		
	}

	private static void go(int line, int state, int sum) {
		if(sum > answer) return;
		if(line == N-1) {
			if(state == WHITE) return;
			if(answer>sum) answer = sum;
			return;
		}
		
		if(state==WHITE) { // white or blue
			go(line+1, state, sum+paint[line][WHITE]);
			go(line+1, BLUE, sum+paint[line][BLUE]);			
		} else if(state == BLUE) { // blue or red
			go(line+1, state, sum+paint[line][BLUE]);
			go(line+1, RED, sum+paint[line][RED]);			
		} else { // red only
			go(line+1, state, sum+paint[line][RED]);
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
