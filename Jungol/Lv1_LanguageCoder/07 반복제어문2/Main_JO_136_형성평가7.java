import java.util.Scanner;

public class Main_JO_136_형성평가7 { // 제출일 2021-01-10 23:10

	public static void main(String[] args) throws Exception {

		// 한 개의 자연수를 입력받아 그 수의 배수를 차례로 10개 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		for (int i = 0, j = a + a; i < 9; i++, j += a) {
			sb.append(' ').append(j);
		}
		System.out.println(sb.toString());
	}
}