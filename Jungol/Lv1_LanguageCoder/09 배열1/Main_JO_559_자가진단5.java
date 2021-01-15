import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_559_자가진단5 { // 제출일 2021-01-15 23:27

	public static void main(String[] args) {

		// 1반부터 6반까지의 평균점수를 저장한 후
		// 두 반의 반 번호를 입력받아 두 반 평균점수의 합을 출력하는 프로그램을 작성하시오.
		// 반별 평균점수는 초기값으로
		// 1반부터 차례로 85.6 79.5 83.1 80.0 78.2 75.0으로 초기화하고
		// 출력은 소수 두 번째 자리에서 반올림하여 소수 첫째자리까지 한다.

		double[] avg = { 0, 85.6, 79.5, 83.1, 80.0, 78.2, 75.0 };
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(String.format("%.1f", avg[a] + avg[b]));

	}

}