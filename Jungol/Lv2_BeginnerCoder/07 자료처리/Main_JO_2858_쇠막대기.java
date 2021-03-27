import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2858_쇠막대기 { // 제출일 2021-03-27 23:35

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//
		int op = 1; // open Parentheses
		char before = ' ';
		int sum = 0;
		char[] line = br.readLine().toCharArray();
		// 첫번째는 무조건 (이다
		for (int i = 1; i < line.length; i++) {
			if (line[i] == '(') {
				op += 1;
			} else {
				op -= 1;
				if (line[i - 1] == ')') {
					sum += 1;
				} else {
					sum += op;
				}
			}
		}
		sb.append(sum);

		bw.write(sb.toString());
		bw.flush();
	}

}