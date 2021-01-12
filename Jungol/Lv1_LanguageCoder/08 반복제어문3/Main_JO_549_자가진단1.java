import java.util.Scanner;

public class Main_JO_549_자가진단1 { // 제출일 2021-01-12 22:43

	public static void main(String[] args) throws Exception {

		// 자연수 n을 입력받고 1부터 홀수를 차례대로 더해나가면서
		// 합이 n 이상이면 그 때까지 더해진 홀수의 개수와 그 합을 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int sum = 0;
		for (int i = 1;; i += 2) {
			cnt++;
			sum += i;
			if (sum >= n) {
				break;
			}
		}
		System.out.print(String.format("%d %d", cnt, sum));

	}
}
