import java.util.Scanner;

public class Main_JO_537_자가진단2 { // 제출일 2021-01-07 20:59

	public static void main(String[] args) {

		// 100 이하의 양의 정수만 입력된다.
		// while 문을 이용하여 1부터 입력받은 정수까지의 합을 구하여 출력
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int a = 1;
		int sum = 0;
		while (a <= num) {
			sum += a++;
		}
		System.out.println(sum);
	}
}