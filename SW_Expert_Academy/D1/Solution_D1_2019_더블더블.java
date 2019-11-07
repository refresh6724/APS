import java.util.Scanner;

public class Solution_D1_2019_더블더블 { // 제출일 2019-11-07 15:54 
	public static void main(String[] args) {
		// 1부터 주어진 횟수까지 2를 곱한 값들을 출력하시오.
		// 주어질 숫자는 30을 넘지 않는다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i <= N; i++) {
			System.out.printf("%d ", 1<<i);
		}
	}
}
