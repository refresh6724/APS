import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_540_자가진단5 { // 제출일 2021-01-07 22:26

	public static void main(String[] args) throws IOException {

		// 정수를 입력받아서 3의 배수가 아닌 경우에는 아무 작업도 하지 않고
		// 3의 배수인 경우에는 3으로 나눈몫을 출력하는 작업을 반복하다가
		// -1이 입력되면 종료하는 프로그램을 작성하시오.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		while (num != -1) {
			if (num % 3 == 0) {
				System.out.println(num / 3);
			}
			num = Integer.parseInt(br.readLine());
		}
	}
}