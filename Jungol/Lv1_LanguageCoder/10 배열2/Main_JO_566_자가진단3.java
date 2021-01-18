import java.util.Scanner;

public class Main_JO_566_자가진단3 { // 제출일 2021-01-18 23:33

	public static void main(String[] args) {

		// 100 이하의 자연수를 입력받아
		// 첫 번째 항은 100으로 두 번째 항은 입력받은 수로 초기화하고
		// 다음 항부터는 전전항에서 전항을 뺀 수로 채워나가는 수열을 작성하여
		// 그 수가 음수가 나올 때까지 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int a = 100;
		int b = sc.nextInt();
		int c = 100 - b;
		StringBuilder sb = new StringBuilder();
		sb.append(a).append(' ');
		while (a >= 0) {
			a = b;
			b = c;
			c = a - b;
			sb.append(a).append(' ');
		}
		System.out.println(sb.toString().trim());

	}

}