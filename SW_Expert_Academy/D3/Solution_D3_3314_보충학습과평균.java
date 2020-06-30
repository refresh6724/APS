import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_3314_보충학습과평균 { // 제출일 2020-06-30 22:39 31,660 kb 143 ms

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());
		int sum, score;
		for (int tc = 1; tc <= TC; tc++) {

			// 점수는 모두 5의 배수
			// 40미만은 모두 40으로 처리
			st = new StringTokenizer(br.readLine());

			sum = 0;
			for (int i = 0; i < 5; i++) {
				score = Integer.parseInt(st.nextToken());
				sum += (score > 40) ? score : 40;
			}

			answer.append('#').append(tc).append(' ').append(sum / 5).append("\n");
		}
		bw.write(answer.toString());
		bw.flush();
	}

}
