import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_9480_민정이와광직이의알파벳공부 { // 제출일 2020-03-06 22:32

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int answer;
	static char[][] input;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			answer = 0;
			input = new char[N][];
			for (int i = 0; i < N; i++) {
				input[i] = br.readLine().toCharArray();
			}
			int[] alphabet = new int[123]; // 'z'+1
			dfs(0, alphabet);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void dfs(int i, int[] alphabet) {
		if (i == N) {
			for (int j = 97; j < 123; j++) {
				if (alphabet[j]==0)
					return;
			}
			answer++;
			return;
		}

		
		dfs(i + 1, alphabet);
		for (int j = 0; j < input[i].length; j++) {
			alphabet[input[i][j]]++;
		}
		dfs(i + 1, alphabet);
		for (int j = 0; j < input[i].length; j++) {
			alphabet[input[i][j]]--;
		}
	}

}
