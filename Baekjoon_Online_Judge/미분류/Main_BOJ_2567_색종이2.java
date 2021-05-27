import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2567_색종이2 { // 제출일 2019-08-29 17:24
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int N = sc.nextInt(); // 색종이 수 최대 100
		// 100 100 정사각형
		boolean[][] map = new boolean[102][102];
		int a=0;
		int b=0;
		for (int i = 1; i <= N; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			for (int j = a; j < a+10; j++) {
				for (int j2 = b; j2 <b+10; j2++) {
					map[j][j2] = true;
				}
			}
		}
		
		for (int i = 1; i <= 100; i++) { // 행 기준
			int j = 0;
			while(j != 100) {// true false가 변하는 곳이 경계
				if(map[i][j++] !=map[i][j]) answer++;
			}
		}
		for (int i = 1; i <= 100; i++) { // 행 기준
			int j = 0;
			while(j != 100) {// true false가 변하는 곳이 경계
				if(map[j++][i] !=map[j][i]) answer++;
			}
		}
		
		
		bw.write(String.format("%d\n", answer));
		bw.flush();

	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() throws Exception {
			// System.setIn(new FileInputStream("input.txt"));// 테스트케이스 파일을 프로젝트 폴더에 삽입
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
