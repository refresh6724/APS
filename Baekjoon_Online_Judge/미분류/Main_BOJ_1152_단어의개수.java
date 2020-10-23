import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1152
 */
public class Main_BOJ_1152_단어의개수 { // 제출일 2020-10-23 23:03

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br.readLine().trim().split(" ").length);
	}
}
