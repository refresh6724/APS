import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_1110_더하기사이클 { // 제출일 2020-09-15 23:54

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int input = Integer.parseInt(br.readLine());

		int a = input;
		int b = 0;
		int cnt = 0;

		do {
			cnt++;
			b = (a / 10) + (a % 10);
			a = (a % 10) * 10 + (b % 10);
//			System.out.println(b);
//			System.out.println(a);
		} while (a != input);
		
		System.out.println(cnt);
//
//		bw.write(sb.toString());
//		bw.flush();
	}

}