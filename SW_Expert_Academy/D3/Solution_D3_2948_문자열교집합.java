import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_D3_2948_문자열교집합 { // 제출일 2020-06-21

	// main 내부 HashSet<String> set = new HashSet<String>(); 	// 134,740 kb 762 ms
	// static HashSet<String> set = new HashSet<String>(); 		// 127,496 kb 796 ms
	// static HashSet<String> set[] = new HashSet[26]; 			// 149,036 kb 763 ms
	// main 내부 HashMap<String, Integer> map = new HashMap<>(); 	// 127,196 kb 738 ms
	// static HashMap<String, Integer> map = new HashMap<>(); 	// 137,664 kb 768 ms
	// static HashMap<String, Integer> map[] = new HashMap[26]; // 123,228 kb 737 ms

	static HashMap<String, Integer> map[] = new HashMap[26];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 10만 개
			int m = Integer.parseInt(st.nextToken()); // 10만 개

			int answer = 0;

			for (int j = 0; j < 26; j++) {
				map[j] = new HashMap<String, Integer>();
			}

			// 알파벳 26자 길이 50 => 26^50 을 해싱하라?
			// 정수 범위의 해시 리스트 => 개별 값에 대해 링크드리스트 생성?
			// a-z로 시작하는 단어로 나눈다?

			String tmp;
			// n 개의 문자열
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				tmp = st.nextToken();
				map[tmp.charAt(0) - 'a'].put(tmp, 0);
			}

			// m 개의 문자열
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tmp = st.nextToken();
				if (map[tmp.charAt(0) - 'a'].containsKey(tmp)) {
					answer++;
				}
			}
			sb.append('#').append(i).append(' ').append(answer).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
