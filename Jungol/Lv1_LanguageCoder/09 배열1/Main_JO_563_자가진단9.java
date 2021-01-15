import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_JO_563_자가진단9 { // 제출일 2021-01-15 23:50

	public static void main(String[] args) {

		// 10개의 정수를 입력받아 배열에 저장한 후 내림차순으로 정렬하여 출력하시오.

		Integer[] num = new Integer[10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(num[i]).append(' ');
		}
		System.out.println(sb.toString().trim());
	}

}