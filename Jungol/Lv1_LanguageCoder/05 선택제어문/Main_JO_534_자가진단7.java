import java.util.Scanner;

public class Main_JO_534_자가진단7 { // 제출일 2021-01-06 23:23

	public static void main(String[] args) {

		//

		Scanner scan = new Scanner(System.in);
		char a = scan.next().charAt(0);

		switch (a) {
		case 'A':
			System.out.println("Excellent");
			break;
		case 'B':
			System.out.println("Good");
			break;
		case 'C':
			System.out.println("Usually");
			break;
		case 'D':
			System.out.println("Effort");
			break;
		case 'F':
			System.out.println("Failure");
			break;
		default:
			System.out.println("error");
			break;
		}

	}
}