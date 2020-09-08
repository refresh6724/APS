import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9498_시험성적 { // 제출일 2020-09-08 20:53

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(br.readLine());
		if(a>89) {
			System.out.println('A');
		} else if(a>79) {
			System.out.println('B');
		} else if(a>69) {
			System.out.println('C');
		} else if(a>59) {
			System.out.println('D');
		} else {
			System.out.println('F');
		}
	}

}