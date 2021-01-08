import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_126_형성평가2 { // 제출일 2021-01-08 23:08

	public static void main(String[] args) {

		// 0 이상의 정수들이 공백으로 구분되어 반복적으로 주어진다.
		// 0이 입력되면 반복문을 멈추고 그 전까지 입력받은 수들에 대하여
		// 홀수의 개수와 짝수의 개수를 출력하는 프로그램을 작성하시오.
		int odd = 0;
		int even = 0;
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int num = Integer.parseInt(st.nextToken());
		while (num != 0) {
			if (num % 2 == 0) {
				even++;
			} else {
				odd++;
			}
			num = Integer.parseInt(st.nextToken());
		}
		System.out.println(String.format("odd : %d", odd));
		System.out.println(String.format("even : %d", even));
	}
}