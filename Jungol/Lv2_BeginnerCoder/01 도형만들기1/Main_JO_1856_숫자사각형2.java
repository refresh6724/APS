import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1856_숫자사각형2 { // 제출일 2021-02-17 23:34

	static int n, m, num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1129&sca=20

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = 1;
		int s = 0;
		int e = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				s = i * m + 1;
				e = i * m + m;
				sb.append(s);
				for (int j = s + 1; j <= e; j++) {
					sb.append(' ').append(j);
				}
			} else {
				s = i * m + m;
				e = i * m + 1;
				sb.append(s);
				for (int j = s - 1; j >= e; j--) {
					sb.append(' ').append(j);
				}
			}
			sb.append('\n');
		}

		bw.write(sb.toString().trim());
		bw.flush();
	}

}