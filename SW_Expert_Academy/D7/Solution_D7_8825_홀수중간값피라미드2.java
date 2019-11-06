import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D7_8825_홀수중간값피라미드2 { // 제출일 2019-11-06 14:50
	// https://atcoder.jp/contests/agc006/tasks/agc006_d
	// https://atcoder.jp/contests/agc006/submissions/8056643
	static int N;
	static int N2;
	static int[] firstFloor;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(sc.nextLine());
			N2 = N<<1;
			firstFloor = new int[N2]; // 1 ~ 2N-1번 사용
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			for (int i = 1; i < N2; i++) {
				firstFloor[i] = Integer.parseInt(st.nextToken());
			}
			// 입력 종료			
			int left = 1;
			int right = N2-1;
			int mid = 0;
			while(left<right) {
				mid = (left+right+1)/2;
				if(balance(mid)) {
					left = mid;
				} else {
					right = mid-1;
				}
			}			
			System.out.printf("#%d %d\n", tc, left);
		}
		
	}
	
	/** 
	 * GreaterThanOrEqualToMid
	 */
	static boolean[] gem;

	private static boolean balance(int mid) {		
		gem = new boolean[N2];
		for (int i = 1; i < N2; i++) {
			gem[i] = firstFloor[i]>=mid ? true : false;
		}
		System.out.println(Arrays.toString(gem));
		int left = N;
		while(left > 1 && gem[left] != gem[left-1]) {
			left--;
		}
		
		int right = N;
		while(right < N2-1 && gem[right] != gem[right+1]) {
			right++;
		}
		
		if(gem[left] == gem[right]) {
			return gem[left]; // true or false
		}
		// else
		
		// 마지막에 출력되는 자리 N으로부터의 거리
		int distL = N - left;
		int distR = right - N;
		if(distL < distR) {
			return gem[left];
		} else {
			return gem[right];
		}		
	}
}
