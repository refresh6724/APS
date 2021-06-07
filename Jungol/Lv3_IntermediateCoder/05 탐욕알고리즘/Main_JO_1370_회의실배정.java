import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1370_회의실배정 { // 제출일 2021-06-07 23:31

	static int n, ans;
	static int[][] time;
	static ArrayList<Integer> order;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine()); // 회의 수
		time = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken()); // num
			time[i][1] = Integer.parseInt(st.nextToken()); // start
			time[i][2] = Integer.parseInt(st.nextToken()); // end
		}

		ans = 0;
		order = new ArrayList<>();
	}

	private static void go() {
		// 끝나는 시간을 오름차순으로 정렬하고
		// 끝나는 시간이 같을 때 더 빨리 시작되는 것을 선택한다
		Arrays.sort(time, (o1, o2) -> o1[2] == o2[2] ? o1[1] - o2[1] : o1[2] - o2[2]);

		int end = time[0][2];
		ans += 1;
		order.add(time[0][0]);
		for (int i = 1; i < time.length; i++) {
			if (time[i][1] < end) {
				continue;
			}
			end = time[i][2];
			ans += 1;
			order.add(time[i][0]);
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append('\n');
		sb.append(order.get(0));
		for (int i = 1; i < order.size(); i++) {
			sb.append(' ').append(order.get(i));
		}
		bw.write(sb.toString());
		bw.flush();
	}

}