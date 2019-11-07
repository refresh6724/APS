import java.util.Scanner;

public class Solution_D2_1284_수도요금경쟁 { // 제출일 2019-11-07 18:05 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int answer = 0;
		for (int t = 1; t <= T; t++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			if(W <= R) {
				answer = Math.min(P*W, Q);
			} else {
				answer = Math.min(P*W, Q+(W-R)*S);
			}
			System.out.printf("#%d %d\n",t, answer);
		}
	}
}
