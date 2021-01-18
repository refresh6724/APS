import java.util.Scanner;

public class Main_JO_570_자가진단7 { // 제출일 2021-01-18 23:51

	public static void main(String[] args) {

		// 배열을 만들어서 아래와 같이 저장한 후 출력하는 프로그램을 작성하시오.
		// 규칙은 첫 번째 행은 모두 1로 초기화 하고
		// 다음 행부터는 바로 위의 값과 바로 왼쪽의 값을 더한 것이다.

		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[5][5];
		for (int i = 0; i < 5; i++) {
			arr[0][i] = 1;
			arr[i][0] = 1;
		}
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(arr[i][0]);
			for (int j = 1; j < 5; j++) {
				sb.append(' ').append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());

	}

}