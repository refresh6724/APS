import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1018
 */
public class Main_BOJ_1018_체스판다시칠하기 { // 제출일 2020-11-22 23:24
	
	static char[][] board;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 8이상 50이하
		int M = Integer.parseInt(st.nextToken()); // 8이상 50이하
		
		// (N-8)*(M-8)*2*64 번 확인
		// 최대 225,792번
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		ans = 64;
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				check(i,j);
			}
		}
		System.out.println(ans);	
	}

	private static void check(int i, int j) {
		int wStart = 0;	
		int bStart = 0;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if((row+col)%2==0) {
					if(board[i+row][j+col] != 'W') {
						wStart++;
					} else {
						bStart++;
					}					
				} else {
					if(board[i+row][j+col] != 'B') {
						wStart++;
					} else {
						bStart++;
					}
				}
			}
		}		
		ans = Math.min(ans, Math.min(wStart, bStart));
	}

}
