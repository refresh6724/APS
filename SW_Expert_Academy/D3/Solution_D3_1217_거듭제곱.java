import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_1217_거듭제곱 { // 제출일 2020-06-04 23:57 18,360 kb 113 ms
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 10개의 테케가 주어진다고 문제에 명시
			sb.append('#').append(tc).append(' ');

			// 조건 : 재귀를 이용하여 풀기
			st = new StringTokenizer(br.readLine());
			int base = Integer.parseInt(st.nextToken());
			int exponents = Integer.parseInt(st.nextToken());

			recursion(base, exponents, 1);
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void recursion(int base, int exponents, int num) {
		if (exponents == 0) {
			sb.append(num).append('\n');
			return;
		}
		recursion(base, exponents - 1, num * base);
	}

}
