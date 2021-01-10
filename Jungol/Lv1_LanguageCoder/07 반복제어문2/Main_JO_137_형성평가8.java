import java.util.Scanner;

public class Main_JO_137_형성평가8 { // 제출일 2021-01-10 23:13

	public static void main(String[] args) throws Exception {

		// 행과 열의 수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= row; i++) {
			sb.append(i);
			for (int j = 2; j <= col; j++) {
				sb.append(' ').append(i * j);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}