import java.util.Scanner;

public class Main_JO_554_자가진단7 { // 제출일 2021-01-12 22:58

	public static void main(String[] args) throws Exception {

		// 3
		// 1 2 3 A
		// 4 5 B C
		// 6 D E F

		int a = 1;
		char start = 'A';
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = n, j = 1; i >= 1; i--, j++) {
			sb.append(a++);
			for (int num = 1; num < i; num++) {
				sb.append(' ').append(a++);
			}
			for (int eng = 0; eng < j; eng++) {
				sb.append(' ').append(start++);
			}
			sb.append('\n');
		}

		System.out.print(sb.toString());

	}
}