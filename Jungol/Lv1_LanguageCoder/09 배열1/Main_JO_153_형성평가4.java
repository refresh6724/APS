import java.util.Scanner;

public class Main_JO_153_형성평가4 { // 제출일 2021-01-17 18:41

	public static void main(String[] args) {

		// 100개의 정수를 입력받을 수 있는 배열을 선언한 후
		// 정수를 차례로 입력 받다가 -1이 입력되면 입력을 중단하고
		// -1을 제외한 마지막 세 개의 정수를 출력하는 프로그램을 작성하시오.
		// (입력받은 정수가 -1을 제외하고 3개 미만일 경우에는 -1을 제외하고 입력받은 정수를 모두 출력한다.)

		Scanner sc = new Scanner(System.in);
		int[] num = new int[100];
		int input = sc.nextInt();
		int idx = 0;
		while (input != -1) {
			num[idx++] = input;
			input = sc.nextInt();
		}
		// 바로 -1이면 아무것도 출력하지 않는다?
		if (idx < 2) {
			System.out.println(num[0]);
		} else if (idx < 3) {
			System.out.println(num[0] + " " + num[1]);
		} else {
			System.out.println(String.format("%d %d %d", num[idx - 3], num[idx - 2], num[idx - 1]));
		}
	}

}