import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_2523_별찍기13 { // 제출일 2020-02-24 22:57
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		StringBuilder sb1 = new StringBuilder();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=i; j++) {
				sb1.append("*");
			}
			sb1.append("\n");
		}
		
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j < i; j++) {
				sb1.append("*");
			}
			sb1.append("\n");
		}
		
		System.out.println(sb1.toString());
		
	}

}