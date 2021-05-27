import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/3053
 */
public class Main_BOJ_3053_택시기하학 { // 제출일 2020-11-06 23:04

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int r = Integer.parseInt(br.readLine());
		System.out.println(Math.PI * r * r);
		System.out.println(2 * r * r);
	}
}
