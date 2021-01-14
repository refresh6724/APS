import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_JO_145_형성평가6 { // 제출일 2021-01-14 22:01

	public static void main(String[] args) throws Exception {

		// 자연수 n을 입력받아 "출력 예"와 같이 출력되는 프로그램을 작성하시오.
		//
		// 3
		//     1
		//   1 2
		// 1 2 3

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < (n - i) * 2; j++) {
				sb.append(' ');
			}
			for (int j = 1; j <= (i * 2) - 1; j++) { 
				if(j%2==0) {
					sb.append(' ');
				} else {
					sb.append(j/2 + 1);				
				}				
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}