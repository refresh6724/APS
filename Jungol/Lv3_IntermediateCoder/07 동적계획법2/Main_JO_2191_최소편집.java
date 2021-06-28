import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2191_최소편집 { // 제출일 2021-06-28 23:25

	static int n, m;
	static char[] a, b;
	static int[][] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		a = st.nextToken().toCharArray();
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		b = st.nextToken().toCharArray();

		// a를 b로 만들기 위한 최소 연산 횟수 구하기
		// n과 m의 차이만큼 삽입하거나 삭제하는 것을 기본 연산으로 생각하면 같은 문자 체크가 우선일 수 있
		memo = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			memo[i][0] = i;
		}
		for (int i = 1; i <= m; i++) {
			memo[0][i] = i;
		}

		for (int left = 1; left <= n; left++) {
			for (int right = 1; right <= m; right++) {
				if (a[left - 1] == b[right - 1]) {
					memo[left][right] = memo[left - 1][right - 1];
				} else {
					memo[left][right] = Math.min(memo[left - 1][right - 1], Math.min(memo[left - 1][right], memo[left][right - 1])) + 1;
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(memo[n][m]);
		bw.write(sb.toString());
		bw.flush();
	}

}