import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_127_형성평가3 { // 제출일 2021-01-08 23:11

	public static void main(String[] args) {

		// 0 부터 100 까지의 점수를 계속 입력받다가 범위를 벗어나는 수가 입력되면
		// 그 이전까지 입력된 자료의 합계와 평균을 출력하는 프로그램을 작성하시오.
		// (평균은 반올림하여 소수 첫째자리까지 출력한다.)

		int cnt = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int num = Integer.parseInt(st.nextToken());
		while (num >= 0 && num <= 100) {
			cnt++;
			sum += num;
			num = Integer.parseInt(st.nextToken());
		}
		System.out.println(String.format("sum : %d", sum));
		System.out.println(String.format("avg : %.1f", (double) sum / cnt));
	}
}