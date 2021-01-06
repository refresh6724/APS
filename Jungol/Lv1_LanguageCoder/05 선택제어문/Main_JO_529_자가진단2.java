import java.util.Scanner;

public class Main_JO_529_자가진단2 { // 제출일 2021-01-06 23:08

	public static void main(String[] args) {

		// “몸무게+100-키”를 비만수치 공식이라고 하자.
		// 키와 몸무게를 자연수로 입력받아 첫 번째 줄에 비만수치를 출력하고,
		// 비만수치가 0보다 크면 다음줄에 비만("Obesity")이라는 메시지를 출력
		
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int w = scan.nextInt();
		int bmi = w + 100 - h;
		System.out.println(bmi);
		if (bmi > 0) {
			System.out.println("Obesity");
		}
	}
}