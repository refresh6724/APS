import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

// _JO_1108_페이지전환
public class Main { // 제출일 2019-10-16 15:34

	static int answer;
	static int N;
	static int[][] map;
	static int inf = 1000;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		map = new int[501][501];
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], inf);
		}
		int s = 0;
		int e = 0;
		int max = 0;
		HashMap<Integer, Integer> list = new HashMap<Integer,Integer>();
		for (int i = 0; i < N; i++) {
			s = sc.nextInt();
			e = sc.nextInt();
			map[s][e] = 1;
			list.put(s, 1);
			list.put(e, 1);
		}
		for (Integer i : list.keySet()) {
			if(i > max) max = i;
		}
		int size = list.size();
		int denominator = size * (size-1);		
		
		for (int k = 1; k <= max; k++) {
			for (int i = 1; i <= max; i++) {
				for (int j = 1; j <= max; j++) {
					if (map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		double numerator= 0;
		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= max; j++) {
				if(i!=j) numerator += map[i][j]; 
				//System.out.printf("%d ",map[i][j]);
			}
			//System.out.println();
		}
	
		System.out.printf("%.3f", numerator/denominator);
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
