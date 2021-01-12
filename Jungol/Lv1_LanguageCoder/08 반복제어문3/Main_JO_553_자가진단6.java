import java.util.Scanner;

public class Main_JO_553_자가진단6 { // 제출일 2021-01-12 22:55

	public static void main(String[] args) throws Exception {

		// 자연수 n( 3 <= n <= 10) 을 입력받아 다음과 같이 영문자를 출력하는 프로그램을 작성하시오.
		// 설명이 부족하다 AZ 다음에 다시 A가 온다고 가정
		// 역시 틀렸다 Z 다음에는 [\]^가 온다

		char start = 'A';
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = n; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				sb.append(start++);
//				if (start > 'Z') {
//					start = 'A';
//				}
			}
			sb.append('\n');
		}

		System.out.print(sb.toString());

	}
}