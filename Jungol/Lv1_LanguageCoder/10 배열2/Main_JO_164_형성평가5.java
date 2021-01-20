import java.util.Scanner;

public class Main_JO_164_형성평가5 { // 제출일 2021-01-20 22:46

	public static void main(String[] args) {

		// 호석이네 학교는 6학년이 네 반이 있는데
		// 각 반의 대표를 세 명씩 선발하여 제기차기 시합을 하였다.
		// 반별로 세 명이 제기를 찬 개수를 입력받아
		// 각 반별로 제기를 찬 개수의 합계를 출력하는 프로그램을 작성하시오.
		// (반드시 배열을 이용하고 입력후에 출력하는 방식으로 하세요.)

		Scanner sc = new Scanner(System.in);

		int[][] score = new int[4][4];
		for (int i = 1; i <= 4; i++) {
			System.out.print(i + "class? ");
			for (int j = 0; j < 3; j++) {
				score[i - 1][j] = sc.nextInt();
				score[i - 1][3] += score[i - 1][j];
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 4; i++) {
			sb.append(String.format("%dclass : %d\n", i, score[i - 1][3]));
		}
		System.out.println(sb.toString().trim());
	}

}