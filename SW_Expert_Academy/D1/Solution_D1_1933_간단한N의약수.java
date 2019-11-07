import java.util.Scanner;

public class Solution_D1_1933_간단한N의약수 { // 제출일 2019-11-07 16:49
	public static void main(String[] args) {
		// N의 약수를 오름차순으로
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			if (N % i == 0)
				System.out.printf("%d ", i);
		}
	}
}
