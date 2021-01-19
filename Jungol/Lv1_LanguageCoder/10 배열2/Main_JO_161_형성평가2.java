import java.util.Scanner;

public class Main_JO_161_형성평가2 { // 제출일 2021-01-19 23:29

	public static void main(String[] args) {

		// 학생들의 점수를 입력을 받다가 0이 입력되면
		// 그 때까지 입력받은 점수를 10점 단위로 구분하여
		// 점수대별 학생 수를 출력하는 프로그램을 작성하시오.
		// (1명도 없는 점수는 출력하지 않는다.)
		// 학생은 최대 100명이하이다.

		Scanner sc = new Scanner(System.in);
		int[] count = new int[11];
		int score = sc.nextInt();
		while (score != 0) {
			count[score / 10]++;
			score = sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 10; i >= 0; i--) {
			if (count[i] > 0)
				sb.append(String.format("%d : %d person\n", i * 10, count[i]));
		}
		System.out.println(sb.toString());

	}

}