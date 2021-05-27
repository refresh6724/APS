import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main { // 제출일 2019-09-05 19:23

	static long answer;
	static int M; // 10만이하
	static int N; // 10만이하
	static int L; // 10억이하
	static int[] pos;
	static int x;
	static int y;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		M = sc.nextInt();
		N = sc.nextInt();
		L = sc.nextInt();
		pos = new int[M];
		for (int i = 0; i < M; i++) {
			pos[i] = sc.nextInt();
		}

		Arrays.sort(pos);

		for (int j = 0; j < N; j++) { // 동물 수만큼
			// 동물 위치를 받으면 사대에서 사정거리가 닿는지 확인한다
			// 닿으면 다음 동물
			// 모든 동물을 확인한 후 answer를 출력한다
			x = sc.nextInt();
			y = sc.nextInt();
			bs(0, M - 1);

		}

		System.out.println(answer);
	}

	static void bs(int s, int e) {
		if (s > e) {
			if ((s >= 0 && s<M && y - L <= x - pos[s] && y <= -x + pos[s] + L)
					|| (e >= 0 && e<M && y - L <= x - pos[e] && y <= -x + pos[e] + L)) {
				answer++;
				return;
			}
		} else {
			int m = (s + e) / 2;
			if (x == pos[m]) {
				if (y <= L)
					answer++;
			} else if (x > pos[m]) {
				bs(m + 1, e);
			} else if (x < pos[m]) {
				bs(s, m - 1);
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
