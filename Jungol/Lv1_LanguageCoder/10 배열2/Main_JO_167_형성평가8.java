import java.util.Scanner;

public class Main_JO_167_형성평가8 { // 제출일 2021-01-20 23:19

	public static void main(String[] args) {

		// 4행 2열의 배열을 입력받아
		// 가로평균과 세로평균 그리고
		// 전체평균을 출력하는 프로그램을 작성하시오.
		// (소수점 이하는 버림 한다.)

		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[4][2];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		StringBuilder sb1 = new StringBuilder();
		int sum = 0;
		// 가로평균
		for (int i = 0; i < 4; i++) {
			sum = 0;
			for (int j = 0; j < 2; j++) {
				sum += arr[i][j];
			}
			sb1.append(sum / 2).append(' ');
		}
		StringBuilder sb2 = new StringBuilder();
		// 세로평균
		for (int i = 0; i < 2; i++) {
			sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += arr[j][i];
			}
			sb2.append(sum / 4).append(' ');
		}
		// 전체평균
		sum = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sb1.toString().trim());
		System.out.println(sb2.toString().trim());
		System.out.println(sum / 8);
	}

}