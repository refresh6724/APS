import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1291_구구단 { // 제출일 2021-02-17 23:10

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=574&sca=20

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		while (s <= 1 || e <= 1 || s > 9 || e > 9) {
			sb.append("INPUT ERROR!\n");
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= 9; i++) {
			sb.append(String.format("%d * %d = %2d", s, i, s * i));
			if (s > e) {
				for (int j = s - 1; j >= e; j--) {
					sb.append(String.format("   %d * %d = %2d", j, i, j * i));
				}
			} else {
				for (int j = s + 1; j <= e; j++) {
					sb.append(String.format("   %d * %d = %2d", j, i, j * i));
				}
			}
			sb.append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}