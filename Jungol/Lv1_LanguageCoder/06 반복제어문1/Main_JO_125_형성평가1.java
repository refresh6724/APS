import java.util.Scanner;

public class Main_JO_125_형성평가1 { // 제출일 2021-01-08 23:05

	public static void main(String[] args) {

		// 정수를 입력받아 1부터 입력받은 정수까지를 차례대로 출력하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= a; i++) {
			sb.append(i).append(' ');
		}
		System.out.println(sb.toString().trim());
	}
}