import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_140_형성평가1 { // 제출일 2021-01-13 23:10

	public static void main(String[] args) throws Exception {

		// 정수 20 개를 입력받아서 그 합과 평균을 출력하되
		// 0 이 입력되면 20개 입력이 끝나지 않았더라도 그 때까지 입력된 합과 평균을 출력하는 프로그램을 작성하시오.
		// 평균은 소수부분은 버리고 정수만 출력한다.(0이 입력된 경우 0을 제외한 합과 평균을 구한다.)

		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int sum = 0;
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < 20; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) {
				break;
			}
			cnt++;
			sum += num;
		}
		System.out.println(String.format("%d %d", sum, sum / cnt));
	}
}