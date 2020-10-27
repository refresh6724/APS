import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2941
 */
public class Main_BOJ_2941_크로아티아알파벳 { // 제출일 2020-10-27 23:10

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 최대 100자 입력
		String[] cAlp = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		String input = br.readLine();
		for (int i = 0; i < cAlp.length; i++) {
			while (input.contains(cAlp[i])) {
				input = input.replace(cAlp[i], "a");
			}
		}
		System.out.println(input.length());
	}
}
