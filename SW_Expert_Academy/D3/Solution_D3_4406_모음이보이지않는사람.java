import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_4406_모음이보이지않는사람 { // 제출일 2020-06-02 23:43 18,864 kb 105 ms

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append('#').append(tc).append(' ');
			char[] input = br.readLine().toCharArray();
			for (int i = 0; i < input.length; i++) {
				if (input[i] != 'a' && input[i] != 'e' && input[i] != 'i' && input[i] != 'o' && input[i] != 'u') {
					sb.append(input[i]);
				}
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
