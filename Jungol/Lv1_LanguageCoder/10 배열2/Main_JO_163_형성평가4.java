public class Main_JO_163_형성평가4 { // 제출일 2021-01-19 23:35

	public static void main(String[] args) {

		// 4행 3열의 배열을 선언하고 아래의 값으로 초기화 한 후 차례대로 출력한 후 배열의 모든 값을 더한 결과를 출력하는 프로그램을 작성하시오.
		// {{3, 5, 9}, {2, 11, 5}, {8, 30, 10}, {22, 5, 1}}

		// Scanner sc = new Scanner(System.in);
		int[][] arr = { { 3, 5, 9 }, { 2, 11, 5 }, { 8, 30, 10 }, { 22, 5, 1 } };

		StringBuilder sb = new StringBuilder();

		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sb.append(arr[i][0]);
			sum += arr[i][0];
			for (int j = 1; j < 3; j++) {
				sb.append(' ').append(arr[i][j]);
				sum += arr[i][j];
			}
			sb.append('\n');
		}
		sb.append(sum);
		System.out.println(sb.toString().trim());
	}

}