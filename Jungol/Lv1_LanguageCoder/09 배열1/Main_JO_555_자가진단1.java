import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_555_자가진단1 { // 제출일 2021-01-15 23:17

	public static void main(String[] args) {

		// 문자 10개를 저장할 수 있는 배열을 만들고 10개의 문자를 입력받아 입력받은 문자를 이어서 출력하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		char[] a = new char[10];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = st.nextToken().charAt(0);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i]);
		}
		System.out.println(sb.toString());

	}

}