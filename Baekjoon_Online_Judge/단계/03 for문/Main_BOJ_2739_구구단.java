import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_2739_구구단 { // 제출일 2020-09-12 23:04

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i < 10; i++) {
			sb.append(String.format("%d * %d = %d\n", N, i, N*i));
		}
		bw.write(sb.toString());
		bw.flush();
	}

}