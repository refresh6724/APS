import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_560_자가진단6 { // 제출일 2021-01-15 23:29

	public static void main(String[] args) {

		// 10개의 정수를 입력받아 그 중 가장 작은 수를 출력하는 프로그램을 작성하시오.(입력받을 정수는 1000을 넘지 않는다.)

		int[] num = new int[10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			num[i] = sc.nextInt();
		}
		System.out.println(Arrays.stream(num).min().getAsInt());
	}

}