import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_9280_진용이네주차타워 { // 제출일 2020-03-21 23:35

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int n, m; // n 100이하 자연수, m 2000 이하 자연수
	static int[] weight, fee, car;
	static boolean[] parking;
	static int inPark, ac;
	static Queue<Integer> wait;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 주차장 크기
			m = Integer.parseInt(st.nextToken()); // 차량 대수
			fee = new int[n + 1]; // 단위 비용
			weight = new int[m + 1]; // 차량 무게
			parking = new boolean[n + 1]; // 주차장 공간
			car = new int[m + 1]; // 차량이 주차한 장소

			for (int i = 1; i <= n; i++) {
				fee[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 1; i <= m; i++) {
				weight[i] = Integer.parseInt(br.readLine());
			}

			ac = 0;
			ans = 0;
			inPark = 0;
			wait = new LinkedList<Integer>();
			for (int i = 0; i < m << 1; i++) {
				inout(Integer.parseInt(br.readLine()));
			}

			sb.append("#" + tc + " " + ans + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void inout(int num) {
		if (ac == m)
			return;
		if (num > 0) { // 입차
			if (inPark != n) {
				for (int i = 1; i <= n; i++) {
					if (!parking[i]) {
						parking[i] = true;
						car[num] = i;
						ans += weight[num] * fee[i];
						ac++;
						break;
					}
				}
				inPark++;
			} else {
				wait.add(num);
			}
		} else { // 출차
			if (!wait.isEmpty()) {
				int w = wait.poll();
				car[w] = car[-num];
				ans += weight[w] * fee[car[w]];
				ac++;
			} else {
				parking[car[-num]] = false;
				inPark--;
			}
		}
	}
}
