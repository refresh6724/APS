import java.util.Scanner;

public class Main_JO_151_형성평가2 { // 제출일 2021-01-16 23:44

	public static void main(String[] args) {

		// 5개의 정수를 입력받은 후 첫 번째 세 번째 다섯 번째 입력받은 정수의 합을 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			if(i%2==0) {
				sum += sc.nextInt();
			} else {
				int pass = sc.nextInt();				
			}
		}
		System.out.println(sum);
	}

}