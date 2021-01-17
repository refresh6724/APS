import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_155_형성평가6 { // 제출일 2021-01-17 18:47

	public static void main(String[] args) {

		// 6개의 문자배열을 만들고 {'J' 'U' 'N' 'G' 'O' 'L'} 으로 초기화 한 후 문자 한 개를 입력받아 배열에서의 위치를
		// 출력하는 프로그램을 작성하시오.
		// 첫 번째 위치는 0번이며 배열에 없는 문자가 입력되면 "none" 라는 메시지를 출력하고 끝내는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		char[] text = { 'J', 'U', 'N', 'G', 'O', 'L' };
		char input = sc.next().charAt(0);
		boolean find = false;
		for (int i = 0; i < 6; i++) {
			if (text[i] == input) {
				System.out.println(i);
				find = true;
				break;
			}
		}
		if (!find) {
			System.out.println("none");
		}
	}

}