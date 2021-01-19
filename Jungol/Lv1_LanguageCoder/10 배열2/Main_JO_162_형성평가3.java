import java.util.Scanner;

public class Main_JO_162_형성평가3 { // 제출일 2021-01-19 23:32

	public static void main(String[] args) {

		// 10 미만의 자연수 두 개를 입력받아서
		// 첫 번째 항과 두 번째 항을 입력받은 수로 초기화 시킨 후
		// 세 번째 항부터는 전전항과 전항의 합을 구하여
		// 그 합의 1의 자리로 채워서 차례로 10개를 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = (a + b) % 10;
		StringBuilder sb = new StringBuilder();
		sb.append(a).append(' ');
		int cnt = 1;
		while (cnt != 10) {
			a = b;
			b = c;
			c = (a + b) % 10;
			sb.append(a).append(' ');
			cnt++;
		}
		System.out.println(sb.toString().trim());

	}

}