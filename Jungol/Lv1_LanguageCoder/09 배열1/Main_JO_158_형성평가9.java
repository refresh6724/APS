import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_158_형성평가9 { // 제출일 2021-01-17 19:01

	public static void main(String[] args) {

		// 정수를 입력받다가 0 이 입력되면 0 을 제외하고 그 때까지 입력 받은 개수를 출력한 후
		// 입력받은 정수를 차례로 출력하되 그 수가 홀수이면 2배한 값을,
		// 짝수인 경우에는 2로 나눈 몫을 출력하는 프로그램을 작성하시오.
		// 입력되는 정수의 개수는 100개 이하이다.

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int cnt = 0;
		int input = sc.nextInt();
		while (input != 0) {
			cnt++;
			if (input % 2 == 0) {
				sb.append(input / 2);
			} else {
				sb.append(input * 2);
			}
			sb.append(' ');
			input = sc.nextInt();
		}
		sb.insert(0, String.format("%d\n", cnt));
		System.out.println(sb.toString().trim());
	}

}