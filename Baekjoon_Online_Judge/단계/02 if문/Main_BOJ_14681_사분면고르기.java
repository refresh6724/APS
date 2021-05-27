import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_14681_사분면고르기 { // 제출일 2020-09-08 20:59

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		if (x > 0) {
			if (y > 0) {
				System.out.println(1);
			} else {
				System.out.println(4);
			}
		} else {
			if (y > 0) {
				System.out.println(2);
			} else {
				System.out.println(3);
			}
		}
	}
}