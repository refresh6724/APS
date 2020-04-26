import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// 기존 제출일 2019-07-19 18:48 20,012 kb 139 ms
// 신규 제출일 2020-04-26 23:16 16,088 kb 98 ms
public class Solution_D3_1215_회문1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static char[][] input;
	static int ans;

	public static void main(String[] args) throws Exception {

//		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= 10; tc++) {

			int len = Integer.parseInt(br.readLine());

			input = new char[8][8];
			for (int i = 0; i < 8; i++) {
				input[i] = br.readLine().toCharArray();
			}
			ans = 0;
			// 8 * 8 에서 가로 세로
			// 8-len 위치까지 검색
			// 예를 들어 2글자 5글자일 경우 0위치, 1위치, 2위치, 3위치까지 보고 4위치는 ㄴㄴ
			for (int i = 0; i < 8; i++) {
				for (int start = 0; start <= 8 - len; start++) {
					isRowPalindrome(i, start, start + len - 1);
					isColPalindrome(i, start, start + len - 1);
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append(" ").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static void isRowPalindrome(int i, int left, int right) {
		while (left < right) {
			if (input[i][left++] != input[i][right--]) {
				return;
			}
		}
		ans++;
	}

	private static void isColPalindrome(int i, int left, int right) {
		while (left < right) {
			if (input[left++][i] != input[right--][i]) {
				return;
			}
		}
		ans++;
	}

}
