import java.util.Scanner;

public class Solution_D2_1940_가랏RC카 { // 제출일 2019-11-08 16:13
	
	static int answer;
	static int N;
	static int s;
	static int v;
	static int a;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			answer = 0;
			N = sc.nextInt();
			s = 0;
			v = 0;
			a = 0;

			for (int i = 0; i < N; i++) {
				switch (sc.nextInt()) {
				case 0:
					s += v;
					break;
				case 1:
					a = sc.nextInt();
					v += a;
					s += v;
					break;
				case 2:
					a = sc.nextInt();
					v -= a;
					if (v < 0)
						v = 0;
					s += v;
					break;
				}
			}
			System.out.printf("#%d %d\n", t, s);
		}
	}
}
