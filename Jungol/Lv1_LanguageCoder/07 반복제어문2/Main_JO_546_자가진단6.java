import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_546_자가진단6 { // 제출일 2021-01-11 22:06

	public static void main(String[] args) throws Exception {

//		10 이하의 과목수 n이 주어진다.
//		정수로 주어진 n개 과목의 점수를 입력받아서 실수 평균을 구하여 출력하고 
//		평균이 80점이상이면 "pass", 80점 미만이면 "fail"이라고 출력하는 프로그램을 작성하시오.
//		평균은 반올림하여 소수 첫째자리까지 출력한다.​

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num;
		}
		double avg = (double) sum / n;
		System.out.println(String.format("avg : %.1f", avg));

		if (avg >= 80) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

	}
}