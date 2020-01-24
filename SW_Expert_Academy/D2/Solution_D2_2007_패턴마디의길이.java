import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2007_패턴마디의길이 { // 제출일 2020-01-24 23:27

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			//

//			st = new StringTokenizer(br.readLine(), " ");

			char[] line = br.readLine().toCharArray();
			int answer = 0;
			// 아이디어 0번과 그로부터 거리 i번째가 같다면 2i번째도 같을 것이다
			// 만약 같다면 1번과 i+1번쨰와 2i+1번째도 같을 것이므로
			// 이를 i-1번 반복해서 통과하면 정답이다

			// 시작지점은 무조건 0
			// 마디의 최대 길이가 10이므로 길이 최대는 10이다

			for (int len = 1; len <= 10; len++) {
				if (line[0] == line[0 + len] && line[0 + len] == line[0 + (len << 1)]) {
					for (int start = 1; start < len; start++) {
						if (line[0 + start] == line[0 + len + start]
								&& line[len + start] == line[0 + (len << 1) + start]) {
							continue;
						} else {
							break;
						}
					}
					answer = len;
					break;
				} // 아니면 길이를 늘린다
			}

			System.out.println("#" + test_case + " " + answer);
		}
	}

}