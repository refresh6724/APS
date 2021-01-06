import java.util.Scanner;

public class Main_JO_533_자가진단6 { // 제출일 2021-01-06 23:18

	public static void main(String[] args) {

		// 남자는 'M' 여자는 'F'로 나타내기로 하고 18세 이상을 성인이라고 하자.
		// 성별('M', 'F')과 나이를 입력받아
		// "MAN"(성인남자), "WOMAN"(성인여자), "BOY"(미성년남자), "GIRL"(미성년여자)을 구분하여 출력

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		int b = scan.nextInt();

		if (a.charAt(0) == 'M') {
			if (b >= 18) {
				System.out.println("MAN");
			} else {
				System.out.println("BOY");
			}
		} else {
			if (b >= 18) {
				System.out.println("WOMAN");
			} else {
				System.out.println("GIRL");
			}
		}

	}
}