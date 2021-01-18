import java.util.Scanner;

public class Main_JO_564_자가진단1 { // 제출일 2021-01-18 23:06

	public static void main(String[] args) {

		// 영문 대문자를 입력받다가 대문자 이외의 문자가 입력되면 입력을 중단하고
		// 영문 대문자들에 대하여 1번 이상 입력된 각 문자와 그 문자의 개수를 사전 순으로 출력하는 프로그램을 작성하시오.
		// 입력되는 문자의 개수는 2개 이상 100개 이하이다.

		Scanner sc = new Scanner(System.in);
		int[] abc = new int[26];

		char a = sc.next().charAt(0);
		while (Character.isUpperCase(a)) {
			abc[a - 'A']++;
			a = sc.next().charAt(0);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (abc[i] > 0) {
				sb.append((char) ('A' + i)).append(" : ").append(abc[i]).append('\n');
			}
		}
		System.out.println(sb.toString());

	}

}