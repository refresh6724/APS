import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D0_1952_수영장_Buffered { // 제출일 2020-03-01 16:25 // 26,816 kb 103 ms

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int[] months = new int[12];
	static int d1, m1, m3, y1;
	static int min;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			d1 = Integer.parseInt(st.nextToken());
			m1 = Integer.parseInt(st.nextToken());
			m3 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				months[i] = Integer.parseInt(st.nextToken());
			}

			min = y1; // 1년통으로 끊는걸 기준으로

			// 1일권을 1, 1달권을 2, 3달권을 3 선택으로 하는 dfs
			dfs(0, 0);
			// 이용계획이 없다면 다음달 혹은 3달 뒤로 점프
			// 12월을 넘으면 그냥 리턴

			sb.append("#").append(t).append(" ").append(min).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();

	}

	static void dfs(int month, int price) {
		if (month >= 12) {
			if (price < min)
				min = price;
			return;
		}

		// 1일권 선택시
		dfs(month + 1, price + months[month] * d1);
		// 1달권 선택시
		dfs(month + 1, price + m1);
		// 3달권 선택시
		dfs(month + 3, price + m3);

	}
}
