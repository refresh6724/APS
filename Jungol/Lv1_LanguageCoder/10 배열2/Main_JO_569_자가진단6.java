import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_569_자가진단6 { // 제출일 2021-01-18 23:48

	public static void main(String[] args) {

		// 5명 학생의 국어 영어 수학 과학 4과목의 점수를 입력 받아서
		// 각 개인별로 평균이 80 이상이면“합격”
		// 그렇지 않으면“불합격”을 출력하고
		// 합격한 사람의 수를 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(sc.nextLine());
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			if (((double) sum / 4) >= 80.0) {
				sb.append("pass");
				cnt++;
			} else {
				sb.append("fail");
			}
			sb.append('\n');
		}
		sb.append("Successful : ").append(cnt);
		System.out.println(sb.toString());

	}

}