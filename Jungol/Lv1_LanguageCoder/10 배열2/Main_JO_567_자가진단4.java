import java.util.Scanner;

public class Main_JO_567_자가진단4 { // 제출일 2021-01-18 23:37

	public static void main(String[] args) {

		// 3행 5열의 배열을 아래 출력 예와 같이 초기화 한 후 출력하는 프로그램을 작성하시오.
		// 숫자사이의 공백은 3칸으로하고 각 숫자는 2칸으로 오른쪽에 맞추어 출력한다. 예, "%2d "

		Scanner sc = new Scanner(System.in);
		int[][] arr = { { 5, 8, 10, 6, 4 }, { 11, 20, 1, 13, 2 }, { 7, 9, 14, 22, 3 } };

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append(String.format("%2d", arr[i][0]));
			for (int j = 1; j < 5; j++) {
				sb.append(String.format("   %2d", arr[i][j]));
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}