import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_558_자가진단4 { // 제출일 2021-01-15 23:24

	public static void main(String[] args) {

		// 100 개의 정수를 저장할 수 있는 배열을 선언하고 정수를 차례로 입력받다가 0 이 입력되면 0 을 제외하고 그 때까지 입력된 정수를 가장
		// 나중에 입력된 정수부터 차례대로 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int[] a = new int[100];
		int cnt = 0;
		int num = sc.nextInt();
		while (num != 0) {
			a[cnt] = num;
			cnt++;
			num = sc.nextInt();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = cnt - 1; i >= 0; i--) {
			sb.append(a[i]).append(' ');
		}
		System.out.println(sb.toString().trim());

	}

}