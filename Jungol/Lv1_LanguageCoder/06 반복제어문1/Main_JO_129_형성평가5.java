import java.util.Scanner;

public class Main_JO_129_형성평가5 { // 제출일 2021-01-08 23:23

	public static void main(String[] args) throws Exception {

		// 삼각형의 밑변의 길이와 높이를 입력받아 넓이를 출력
		// "Continue? "에서 하나의 문자를 입력받아 그 문자가 'Y' 나 'y' 이면 작업을 반복
		// (넓이는 반올림하여 소수 첫째자리까지 출력한다.)

		Scanner sc = new Scanner(System.in);

		char yes = 'y';
		while (yes == 'y' || yes == 'Y') {
			System.out.print("Base = ");
			int base = sc.nextInt();
			System.out.print("Height = ");
			int height = sc.nextInt();
			System.out.println(String.format("Triangle width = %.1f", (double) base * height / 2));
			System.out.print("Continue? ");
			yes = sc.next().charAt(0);
		}

	}
}