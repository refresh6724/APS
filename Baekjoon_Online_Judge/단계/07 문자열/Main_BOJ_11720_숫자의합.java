import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11720
 */
public class Main_BOJ_11720_숫자의합 { // 제출일 2020-10-18 22:32

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력으로 주어진 숫자 N개의 합을 출력
		// 한자릿수 숫자 N개는 공백없이 주어진다
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		char[] num = br.readLine().toCharArray();
		for (int i = 0; i < n; i++) {
			sum += num[i] - '0';
		}
		System.out.println(sum);
	}

}
