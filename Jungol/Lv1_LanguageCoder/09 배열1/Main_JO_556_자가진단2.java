import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_556_자가진단2 { // 제출일 2021-01-15 23:18

	public static void main(String[] args) {

		// 정수 10 개를 저장할 수 있는 배열을 만들어서 1 부터 10 까지를 대입하고 차례대로 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(a[0]);
		for (int i = 1; i < a.length; i++) {
			sb.append(' ').append(a[i]);
		}
		System.out.println(sb.toString());

	}

}