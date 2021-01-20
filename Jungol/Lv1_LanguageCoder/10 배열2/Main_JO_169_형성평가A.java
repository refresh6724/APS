import java.util.Scanner;

public class Main_JO_169_형성평가A { // 제출일 2021-01-20 23:53

	public static void main(String[] args) {

		// 3행 5열의 2차원 문자배열 형태의 대문자들을
		// 입력 받은 후 소문자로 바꾸어서 공백으로 구분하여
		// 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);

		char[][] arr = new char[3][5];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = (char) (sc.next().charAt(0) - 'A' + 'a');
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append(arr[i][0]);
			for (int j = 1; j < 5; j++) {
				sb.append(' ').append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}