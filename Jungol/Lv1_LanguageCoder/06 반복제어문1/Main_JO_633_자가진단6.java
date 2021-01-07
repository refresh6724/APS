import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_JO_633_자가진단6 { // 제출일 2021-01-07 22:31

	public static void main(String[] args) throws IOException {

		// 국가 이름을 출력 후 입력을 받아 번호에 해당하는 수도를 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 1;
		while (num == 1 || num == 2 || num == 3 || num == 4) {
			System.out.println("1. Korea");
			System.out.println("2. USA");
			System.out.println("3. Japan");
			System.out.println("4. China");
			System.out.print("number? ");
			num = Integer.parseInt(br.readLine());
			System.out.println();
			switch (num) {
			case 1:
				System.out.println("Seoul");
				System.out.println();
				break;
			case 2:
				System.out.println("Washington");
				System.out.println();
				break;
			case 3:
				System.out.println("Tokyo");
				System.out.println();
				break;
			case 4:
				System.out.println("Beijing");
				System.out.println();
				break;
			default:
				System.out.println("none");
				break;
			}
		}
	}
}