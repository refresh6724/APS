import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_JO_3249_색종이만들기3_압축해제 { // 제출일 2021-07-09 23:46

	static int n, idx;
	static int[][] map;
	static char[] code;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine().trim());
		idx = 0;
		map = new int[n][n];
		code = br.readLine().toCharArray();

		go(0, 0, n);

		sb.append(n).append('\n');
		for (int i = 0; i < n; i++) {
			sb.append(map[i][0]);
			for (int j = 1; j < n; j++) {
				sb.append(' ').append(map[i][j]);
			}
			sb.append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

	private static void go(int sr, int sc, int len) {
		int half = len / 2;
		switch (code[idx++]) {
		case 'X': // 넷으로 나누어 진행된다
			go(sr, sc, half);
			go(sr, sc + half, half);
			go(sr + half, sc, half);
			go(sr + half, sc + half, half);
			break;
		case '1':
			for (int i = sr; i < sr + len; i++) {
				for (int j = sc; j < sc + len; j++) {
					map[i][j] = 1;
				}
			}
			break;
		case '0':
			for (int i = sr; i < sr + len; i++) {
				for (int j = sc; j < sc + len; j++) {
					map[i][j] = 0;
				}
			}
			break;
		}
	}

}