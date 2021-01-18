import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_568_자가진단5 { // 제출일 2021-01-18 23:43

	public static void main(String[] args) {

		// 2행 4열의 배열 두 개를 만들어서 입력을 받고 두 배열의 곱을 구하여 출력하는 프로그램을 작성하시오.
		// 입력 출력 예가 잘못되어있다

		Scanner sc = new Scanner(System.in);
		int[][] first = new int[2][4];
		int[][] second = new int[2][4];

		//String a = sc.nextLine();
		System.out.println("first array");
		StringTokenizer st = null;
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < 4; j++) {
				first[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		//a = sc.nextLine();
		System.out.println("second array");
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < 4; j++) {
				second[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2; i++) {
			sb.append(first[i][0] * second[i][0]);
			for (int j = 1; j < 4; j++) {
				sb.append(' ').append(first[i][j] * second[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}