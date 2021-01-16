import java.util.Scanner;

public class Main_JO_150_형성평가1 { // 제출일 2021-01-16 23:43

	public static void main(String[] args) {

		// 10개의 문자를 입력받아 마지막으로 입력받은 문자부터
		// 첫 번째 입력받은 문자까지 차례로 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		String[] text = new String[10];
		for (int i = 0; i < 10; i++) {
			text[i] = sc.next();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			sb.append(text[i]).append(' ');
		}
		System.out.println(sb.toString().trim());

	}

}