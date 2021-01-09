import java.util.Scanner;

public class Main_JO_130_형성평가1 { // 제출일 2021-01-09 23:02

	public static void main(String[] args) throws Exception {

		// 10 이하의 자연수 n을 입력받아 "JUNGOL​"을 n번 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("JUNGOL").append('\n');
		}
		System.out.println(sb.toString());

	}
}