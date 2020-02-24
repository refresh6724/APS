import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_10990_별찍기15 { // 제출일 2020-02-24 23:07
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		StringBuilder sb1 = new StringBuilder();

		for (int j = 0; j < n-1; j++) {
			sb1.append(" ");
		}
		sb1.append("*").append("\n");	
		
		for (int i = 1; i < n; i++) {						
			for (int j = 0; j < (n << 1); j++) {
				if (j == n - 1 - i) {
					sb1.append("*");					
				} else if (j == n - 1 + i) {
					sb1.append("*");
					break;
				} else {
					sb1.append(" ");
				}
			}
			sb1.append("\n");
		}

		System.out.println(sb1.toString());

	}

}