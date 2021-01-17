import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_156_형성평가7 { // 제출일 2021-01-17 18:49

	public static void main(String[] args) {

		// 세 자리 이하의 정수를 차례로 입력 받다가
		// 999가 입력되면 프로그램을 종료하고
		// 그 때까지 입력된 최대값과 최소값을 출력하는 프로그램을 작성하시오.입력받는 정수는 100개 이하이다.

		Scanner sc = new Scanner(System.in);

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int input = sc.nextInt();
		while (input != 999) {

			min = Math.min(min, input);
			max = Math.max(max, input);
			input = sc.nextInt();
		}
		System.out.println(String.format("max : %d", max));
		System.out.println(String.format("min : %d", min));

	}

}