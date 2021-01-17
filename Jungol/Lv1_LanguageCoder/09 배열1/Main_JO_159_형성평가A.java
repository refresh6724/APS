import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_159_형성평가A { // 제출일 2021-01-17 19:14

	public static void main(String[] args) {

		// 20 이하의 정수 n을 입력받고 n명의 점수를 입력받아 높은 점수부터 차례로 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		StringBuilder sb = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			sb.append(num[i]).append('\n');
		}
		System.out.println(sb.toString());
	}

}