import java.util.Scanner;

public class Main_JO_131_형성평가2 { // 제출일 2021-01-09 23:04

	public static void main(String[] args) throws Exception {

		// 10 이하의 자연수 n을 입력받아 "JUNGOL​"을 n번 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (n > m) {
			int tmp = n;
			n = m;
			m = tmp;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = n; i < m; i++) {
			sb.append(i).append(' ');
		}
		sb.append(m);
		System.out.println(sb.toString());

	}
}