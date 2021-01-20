import java.util.Scanner;

public class Main_JO_168_형성평가9 { // 제출일 2021-01-20 23:50

	public static void main(String[] args) {

		// 행의 크기를 입력받아 파스칼 삼각형을 작성하여
		// 마지막 행부터 첫 번째 행까지 차례로 출력하는 프로그램을 작성하시오.
		// 행의 크기는 최대 10이다.

		// 6

		// 1 5 10 10 5 1
		// 1 4 6 4 1
		// 1 3 3 1
		// 1 2 1
		// 1 1
		// 1

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		arr[0][0] = 1;
		// 1
		// 1 1
		// 1 2 1
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j <= i; j++) {
				arr[i + 1][j] += arr[i][j];
				arr[i + 1][j + 1] += arr[i][j];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = n-1; i >= 0; i--) {
			sb.append(arr[i][0]);
			for (int j = 1; j <= i; j++) {
				sb.append(' ').append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}