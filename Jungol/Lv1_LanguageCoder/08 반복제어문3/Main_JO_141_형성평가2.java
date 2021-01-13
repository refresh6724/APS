import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_141_형성평가2 { // 제출일 2021-01-13 23:14

	public static void main(String[] args) throws Exception {

		// 1부터 100까지의 정수 중 한 개를 입력받아
		// 100 보다 작은 배수들을 차례로 출력하다가
		// 10 의 배수가 출력되면 프로그램을 종료하도록 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		for (int i = n * 2; i < 100; i += n) {
			sb.append(' ').append(i);
			if (i % 10 == 0) {
				break;
			}
		}
		System.out.println(sb.toString());
	}
}