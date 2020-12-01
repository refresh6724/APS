import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_3036_링 { // 제출일 2020-12-01 23:09

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 첫 수에 대해 두번째 수 이후로 분수를 약분하여 서로소로, a/b 식으로 출력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int standard = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n - 1; i++) {
			int compare = Integer.parseInt(st.nextToken());
			int gcd = GCD(standard, compare);
			sb.append(standard / gcd).append('/').append(compare / gcd).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static int GCD(int standard, int compare) {
		int tmp = 0;
		if (standard > compare) {
			tmp = standard;
			standard = compare;
			compare = tmp;
		}
		while (standard > 0) {
			tmp = compare % standard;
			compare = standard;
			standard = tmp;
		}
		return compare;
	}

}
