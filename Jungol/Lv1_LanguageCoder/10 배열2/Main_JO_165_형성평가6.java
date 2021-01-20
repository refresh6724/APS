import java.util.Scanner;

public class Main_JO_165_형성평가6 { // 제출일 2021-01-20 23:07

	public static void main(String[] args) {

		// 예제를 보고 적당한 배열을 선언한 후
		// 1행의 1열과 3열 5열을 각각 1로 초기화하고
		// 나머지는 모두 0으로 초기화 한 후
		// 2행부터는 바로 위행의 왼쪽과 오른쪽의 값을 더하여 채운 후
		// 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[5][5];
		arr[0][0] = arr[0][2] = arr[0][4] = 1;
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] += arr[i - 1][j + 1];
			}
			for (int j = 1; j < 5; j++) {
				arr[i][j] += arr[i - 1][j - 1];
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
		System.out.println(sb.toString().trim());
	}

}