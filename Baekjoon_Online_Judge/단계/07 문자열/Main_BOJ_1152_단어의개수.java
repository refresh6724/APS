import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1152
 */
public class Main_BOJ_1152_단어의개수 { // 제출일 2020-10-23 23:09

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		if(input.length()== 1 && input.charAt(0) == ' ') { // 공백 한글자 조건 빠짐
			System.out.println(0);
		} else {			
			System.out.println(input.trim().split(" ").length);
		}
	}
}
