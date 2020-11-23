import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1436
 */
public class Main_BOJ_1436_영화감독숌 { // 제출일 2020-11-23 23:18

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 6이 적어도 3개 이상 연속으로 들어가는 N번쨰 숫자를 출력
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = 666;
		while (cnt != N) {
			if (Integer.toString(num).contains("666")) {
				cnt++;
			}
			num++;
		}
		System.out.println(num - 1);
	}

}
