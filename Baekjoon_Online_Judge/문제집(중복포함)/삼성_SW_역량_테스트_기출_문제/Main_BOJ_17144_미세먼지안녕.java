import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-09-04 15:25
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static int R, C, T;
	static int[][] input;
	static int[][] plus;
	static int airX;
	public static void main(String[] args) throws Exception {
		sc.init();
		R = sc.nextInt(); // 6이상 50이하
		C = sc.nextInt(); // 6이상 50이하
		T = sc.nextInt(); // 1이상 1000이하
		
		//입력
		input = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				input[i][j] = sc.nextInt();				
			}
		}
		
		// 공기청정기는 가장 왼쪽 열에 설치되어있고, 위로부터 2칸 아래로부터 2칸 이상 떨어져 있다
		for (int i = 0; i < R; i++) {
			if(input[i][0] == -1) {
				airX = i; // 공청기 윗부분 -> 아랫부분으로 갱신
				input[i][0] = 0;
			}
		}
		while(T-- != 0) {
			plus = new int[R][C];
			// 확산
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(input[i][j] != 0) { // 먼지가 있다면
						int dir = 0;
						// 상
						if(i-1>=0) {
							if(j!=0 || i-1 != airX) {
								dir++;
								plus[i-1][j] += input[i][j]/5;
							}
						}
						// 하
						if(i+1<R) {
							if(j!= 0 || i+1 != airX-1) {
								dir++;
								plus[i+1][j] += input[i][j]/5;
							}
						}
						// 좌
						if(j-1>=0) {
							if(j-1 != 0) {
								dir++;
								plus[i][j-1] += input[i][j]/5;
							} else {
								if(i != airX && i!= airX-1) {
									dir++;
									plus[i][j-1] += input[i][j]/5;
								}
								
							}
						}
						// 우
						if(j+1<C) {
							dir++;
							plus[i][j+1] += input[i][j]/5;
						}
						plus[i][j] += input[i][j] - (input[i][j]/5 *dir);
						
					}
				}
			}
			input = plus;			
			
			// 이동
			move();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				answer += input[i][j];
			}
		}
		
		
		bw.write(String.format("%d", answer));
		bw.flush();

	}

	private static void move() {
		// 시작지점은 airX-1, 0 
		for (int row = airX-2; row > 0; row--) {
			input[row][0] = input[row-1][0];
		}
		for (int col = 1; col < C; col++) {
			input[0][col-1] = input[0][col];
		}
		for (int row = 0; row < airX-1; row++) {
			input[row][C-1] = input[row+1][C-1];
		}
		for (int col = C-1; col > 0; col--) {
			input[airX-1][col] = input[airX-1][col-1];
		}
		// 시작지점 airX, 0		
		for (int row = airX+1; row < R-1; row++) {
			input[row][0] = input[row+1][0];
		}
		for (int col = 1; col < C; col++) {
			input[R-1][col-1] = input[R-1][col];
		}
		for (int row = R-1; row > airX; row--) {
			input[row][C-1] = input[row-1][C-1];
		}		
		for (int col = C-1; col > 0; col--) {
			input[airX][col] = input[airX][col-1];
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