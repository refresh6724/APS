import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_BOJ_9663_N_Queen { // 제출일 2020-12-11 23:54 15880 kb 8456 ms

	static int n, ans;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//
		n = Integer.parseInt(br.readLine());
		ans = 0;
		map = new boolean[n][n];
		// 각 라인에 놓을 때 윗방향 좌,상,우 셋만 확인하면 된다
		for (int c = 0; c < n; c++) {
			map[0][c] = true;
			go(1);
			map[0][c] = false;
		}

		bw.write(Integer.toString(ans));
		bw.flush();
	}

	private static void go(int r) {
		if (r == n) {
			ans++;
			return;
		}
		for (int next = 0; next < n; next++) {
			if (check(r, next)) {
				map[r][next] = true;
				go(r + 1);
				map[r][next] = false;
			}
		}
	}

	private static boolean check(int r, int next) {
		// r, next 위치에 둘 때 대각선이나 위에 있다면 false 리턴
		int a, b, c;
		a = next - 1;
		b = next;
		c = next + 1;
		r--;
		while (r != -1) {
			if (a >= 0 && map[r][a]) {
				return false;
			}
			if (map[r][b]) {
				return false;
			}
			if (c < n && map[r][c]) {
				return false;
			}
			r--;
			a--;
			c++;
		}
		return true;
	}

}
