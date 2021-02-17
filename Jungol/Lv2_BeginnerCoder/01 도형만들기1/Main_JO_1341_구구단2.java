import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1341_구구단2 { // 제출일 2021-02-17 23:19

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2076&sca=20
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		if (s > e) {
			for (int i = s; i >= e; i--) {
				sb.append(func(i));
			}
		} else {
			for (int i = s; i <= e; i++) {
				sb.append(func(i));
			}
		}

		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static String func(int i) {
		StringBuilder sb = new StringBuilder();
		sb.append('\n');
		for (int row = 0; row < 3; row++) {
			int col = row * 3 + 1;
			sb.append(String.format("%d * %d = %2d   ", i, col, i * col));
			col++;
			sb.append(String.format("%d * %d = %2d   ", i, col, i * col));
			col++;
			sb.append(String.format("%d * %d = %2d\n", i, col, i * col));
		}
		return sb.toString();
	}

}