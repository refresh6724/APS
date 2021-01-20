import java.util.Scanner;

public class Main_JO_166_형성평가7 { // 제출일 2021-01-20 23:12

	public static void main(String[] args) {

		// 2행 3열 배열을 두 개 선언하여
		// 각각의 값을 입력 받은 후
		// 두 배열의 같은 위치끼리 곱하여
		// 새로운 배열에 저장한 후 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);

		int[][] first = new int[2][3];
		int[][] second = new int[2][3];

		System.out.println("first array");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				first[i][j] = sc.nextInt();
			}
		}
		System.out.println("second array");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				second[i][j] = sc.nextInt();
			}
		}

		int[][] arr = new int[2][3];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = first[i][j] * second[i][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2; i++) {
			sb.append(arr[i][0]);
			for (int j = 1; j < 3; j++) {
				sb.append(' ').append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString().trim());
	}

}