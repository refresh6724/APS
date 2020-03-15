import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_9317_석찬이의받아쓰기 { // 제출일 2020-03-15 23:28

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int answer = 0;
			int n = Integer.parseInt(br.readLine());
			char[] first = br.readLine().toCharArray();
			char[] second = br.readLine().toCharArray();
			for (int i = 0; i < n; i++) {
				if(first[i] == second[i]) answer++;
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
