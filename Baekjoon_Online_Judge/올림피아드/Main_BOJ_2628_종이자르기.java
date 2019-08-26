import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Olympiad > 한국정보올림피아드 > KOI 2001 > 초등부 1번 
public class Main { // 제출일 2019-08-26 08:32

	static boolean[] garo;
	static boolean[] sero;
	static int answer;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		sc.init();
		int g = sc.nextInt();
		garo = new boolean[g];
		int s = sc.nextInt();
		sero = new boolean[s];
		
		
		int slice = sc.nextInt();		
		for (int i = 0; i < slice; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0) {
				sero[b] = true;
			} else {
				garo[b] = true;
			}
		}
		
		
		
		
		int vlen=1;
		int hlen=1;
		int size=0;
		for (int row = 1 ; row <= s; row++) {
			if(row == s) {
				for (int col = 1 ; col <= g; col++) {
					if(col == g) {
						size = vlen*hlen;
						if(size>answer) answer = size;
						hlen = 1;
					} else if(garo[col]) {
						size = vlen*hlen;
						if(size>answer) answer = size;						
						hlen = 1;
					} else {
						hlen++;
					}
				}
				vlen = 1;
			} else if(sero[row]) {
				for (int col = 1 ; col <= g; col++) {
					if(col == g) {
						size = vlen*hlen;
						if(size>answer) answer = size;
						hlen = 1;
					} else if(garo[col]) {
						size = vlen*hlen;
						if(size>answer) answer = size;						
						hlen = 1;
					} else {
						hlen++;
					}
				}				
				vlen = 1;
			} else {
				vlen++;
			}
		}
		

		bw.write(String.format("%d", answer));
		bw.flush();

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
			} catch (Exception e) {

			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
				}
			}
			return st.nextToken();
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
