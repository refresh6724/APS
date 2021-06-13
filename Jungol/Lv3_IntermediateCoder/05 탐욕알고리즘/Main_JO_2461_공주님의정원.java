import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_2461_공주님의정원 { // 제출일 2021-06-13 23:19

	static int n, sm, sd, em, ed, ans;
	static int[][] flower;
	static int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine().trim()); // 꽃의 총 개수 1 이상 10만 이하
		flower = new int[n][];
		// 5 8 6 13 은 5월 8일에 꽃이 피어 6월 12일까지 피어있고 6월 13일 이후에는 꽃이 진다는 뜻
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sm = Integer.parseInt(st.nextToken());
			sd = Integer.parseInt(st.nextToken());
			em = Integer.parseInt(st.nextToken());
			ed = Integer.parseInt(st.nextToken());
			flower[i] = new int[] { sm * 100 + sd, em * 100 + ed };
		}
		// 3월 1일부터 11월 30일까지 항상 피어있도록 하는 최소 꽃의 개수, 불가능하다면 0을 출력
		ans = 0;

	}

	// 틀린 답 : 정올 테스트케이스에 오류 있음
	// 3
	// 1 1 2 1
	// 3 1 4 1
	// 5 1 12 1
	// 답 : 0
	// 오답 : 2
	private static void go() {

		// 3월 1일이 필수로 포함되어야 한다
		// 3월 1일이 포함되면서 가장 늦게 끝나는 꽃으로 시작해야 한다
		Arrays.sort(flower, (o1, o2) -> (o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o1[0] - o2[0]));
		int start = 301;
		int end = 301;
		ans = 1;
		for (int i = 0; i < n && end <= 1130; i++) {
			if (flower[i][0] <= start) {
				end = Math.max(end, flower[i][1]);
			} else {
				if (start < end) {
					start = end;
					end = flower[i][1];
					ans++;
				} else {
					break;
				}
			}
		}
		if (end <= 1130) {
			ans = 0;
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}