import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_128_형성평가4 { // 제출일 2021-01-08 23:16

	public static void main(String[] args) {

		// 0 이 입력될 때까지 정수를 계속 입력받아
		// 3의 배수와 5의 배수를 제외한 수들의 개수를 출력

		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int num = Integer.parseInt(st.nextToken());
		while (num != 0) {
			if (num % 3 != 0 && num % 5 != 0) {
				cnt++;
			}
			num = Integer.parseInt(st.nextToken());
		}
		System.out.println(String.format("%d", cnt));
	}
}