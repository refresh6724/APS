import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_557_자가진단3 { // 제출일 2021-01-15 23:20

	public static void main(String[] args) {

		// 10개의 문자를 입력받아서 첫 번째 네 번째 일곱 번째 입력받은 문자를 차례로 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		char[] a = new char[10];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = st.nextToken().charAt(0);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(a[0]).append(' ').append(a[3]).append(' ').append(a[6]);
		System.out.println(sb.toString());

	}

}