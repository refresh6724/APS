import java.util.Scanner;

public class Main_JO_132_형성평가3 { // 제출일 2021-01-09 23:07

	public static void main(String[] args) throws Exception {

		// 정수를 입력받아서 1부터 입력받은 정수까지의 5의 배수의 합을 구하여 출력
		// 1에서 n까지 5의 배수만을 더한 값
		// 반복제어문이므로 for문으로 풀어도 되고
		// n을 5로 나눈 값 m에 대해 m(m+1)/2 * 5 로 구해도 된다
		// 20/5 = 4 => 4*5/2*5 = 50
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n /= 5;
		n = n * (n + 1) / 2 * 5;
		System.out.println(n);
	}
}