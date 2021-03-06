import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 기존 제출일 2019-08-08 18:44 19,412 kb 98 ms
// 개선 제출일 2020-06-10 23:43 18,660 kb 100 ms

public class Solution_D3_1228_암호문1 {
	/*
	 * 0이상 1000000 백만 미만 수를 나열하여 만든 암호문 기능 1 삽입 명령어I x y s 앞에서부터 x의 위치 바로 다음에 y개의
	 * 숫자를 삽입한다.
	 * 
	 * [입력] 첫 번째 줄 : 원본 암호문의 길이 N ( 10 ≤ N ≤ 20 의 정수) 두 번째 줄 : 원본 암호문 세 번째 줄 : 명령어의
	 * 개수 ( 5 ≤ N ≤ 10 의 정수) 네 번째 줄 : 명령어
	 * 
	 * [출력] 앞 10개만
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t);

			int L1 = Integer.parseInt(br.readLine());
			List<Integer> lst = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L1; i++) {
				lst.add(Integer.parseInt(st.nextToken()));
			}
			// 명령어 개수
			int L3 = Integer.parseInt(br.readLine());
			// 입력 I, D, A 위치 개수N 숫자1 숫자2 ... 숫자N
			int len = 0;
			int pos = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L3; i++) {
				st.nextToken();
				// 포지션
				pos = Integer.parseInt(st.nextToken());
				// 개수 N
				len = Integer.parseInt(st.nextToken());
				for (int j = 0; j < len; j++) {
					lst.add(pos + j, Integer.parseInt(st.nextToken()));
				}
			}

			for (int k = 0; k < 10; k++) {
				sb.append(" ").append(lst.get(k));
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
