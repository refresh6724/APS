import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2753_윤년 { // 제출일 2020-09-08 20:56

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(br.readLine());
		if (((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}