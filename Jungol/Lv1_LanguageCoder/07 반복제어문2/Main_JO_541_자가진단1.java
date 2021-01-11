import java.util.Scanner;

public class Main_JO_541_자가진단1 { // 제출일 2021-01-11 22:01

	public static void main(String[] args) throws Exception {

		// 문자를 입력받아서 입력받은 문자를 20번 반복하여 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			sb.append(a);
		}
		System.out.println(sb.toString());

	}
}