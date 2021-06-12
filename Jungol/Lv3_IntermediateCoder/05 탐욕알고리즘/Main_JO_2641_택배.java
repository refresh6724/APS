import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_JO_2641_택배 { // 제출일 2021-06-12 23:20

	static int n, c, m, from, to, weight, ans;
	static int[][] info;
	static Truck truck;
	static int[][] map;
	static int[] cost;

	static class Truck {

		int now;
		ArrayList<Box> trunk;

		public Truck() {
			// TODO Auto-generated constructor stub
		}

		public Truck(int now) {
			super();
			this.now = now;
			this.trunk = new ArrayList<>();
		}

		public void load(Box box) {
			this.trunk.add(box);
		}

	}

	static class Box implements Comparable<Box> {
		int dest;
		int weight;

		public Box() {
			// TODO Auto-generated constructor stub
		}

		public Box(int dest, int weight) {
			super();
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Box o) {
			return this.dest - o.dest;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
//		sol_1();
		sol_2();
		System.out.println(ans);
//		output(); // 공백 출력 에러 발생
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 마을의 수 2 이상 2천 이하
		c = Integer.parseInt(st.nextToken()); // 트력용량 1 이상 1만 이하
		m = Integer.parseInt(br.readLine().trim()); // 박스 정보 1 이상 1만 이하
//		info = new int[m][];
		map = new int[n + 1][n + 1];
		cost = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken()); // 1 이상 1만 이하
//			info[i] = new int[] { from, to, weight };
			map[from][to] = weight;
		}
//		Arrays.sort(info, (o1, o2) -> (o1[0] == o2[0]) ? o1[1] - o2[1] : o1[0] - o2[0]);
//		truck = new Truck(1);

		ans = 0;
	}

	// 뒤에서부터 메모이제이션 사용
	// 
	private static void sol_2() {

		for (int start = n; start >= 1; start--) {
			for (int end = start; end <= n; end++) {
				int box = map[start - 1][end];
				for (int via = start; via <= end; via++) {
					box = Math.min(c - cost[via], box);
					if (box == 0) {
						break;
					}
				}
				if (box == 0) {
					continue;
				}
				for (int via = start; via <= end; via++) {
					cost[via] += box;
				}
				ans += box;
			}
		}
	}

	// 앞에서부터 차근차근 한칸씩 전진
	// Time Limit Exceed(97)
	// 테스트케이스 하나가 1900 ms
	private static void sol_1() {
		// 현재 위치에서 짐을 꽉 싣는다
		// 실어야하는 짐의 목적지가 이미 실려있는 짐보다 가깝다면 실려있던 짐을 버리고 바꿔 싣는다

		int idx = 0;
		int weight = 0;
		PriorityQueue<Box> land;
		while (truck.now <= n) {
			// 트럭에서 짐을 내린다
			land = new PriorityQueue<>();
			// 도착 위치라면 정답에 더해준다
			// 아직 도착하지 않았다면 대기한다
			for (Box b : truck.trunk) {
				if (b.dest == truck.now) {
					ans += b.weight;
				} else {
					land.add(b);
				}
			}
			truck.trunk.clear();
			// 추가로 실을 짐을 체크한다
			for (int i = idx; idx < m && info[idx][0] == truck.now; idx++) {
				land.add(new Box(info[idx][1], info[idx][2]));
			}
			// 대기 중인 짐을 트럭 용량에 맞춰 싣고 다음 마을로 간다
			weight = 0;
			while (!land.isEmpty()) {
				Box check = land.poll();
				if (weight + check.weight >= c) {
					truck.load(new Box(check.dest, c - weight));
					break;
				} else {
					truck.load(check);
					weight += check.weight;
				}
			}
			truck.now++;
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