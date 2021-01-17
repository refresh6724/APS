import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_154_형성평가5 { // 제출일 2021-01-17 18:44

	public static void main(String[] args) {

		// 6명의 몸무게를 입력받아 몸무게의 평균을 출력하는 프로그램을 작성하시오.
		// 출력은 반올림하여 소수 첫째자리까지로 한다.

		Scanner sc = new Scanner(System.in);
		double sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += sc.nextDouble();
		}
		System.out.println(String.format("%.1f", sum / 6));
	}

}