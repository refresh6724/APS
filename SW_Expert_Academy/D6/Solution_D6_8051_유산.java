import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D6_8051_유산 { // 제출일 2019-08-28 11:58

	static class Node {
		long space;
		long price;

		public long getSpace() {
			return space;
		}

		public long getPrice() {
			return price;
		}

		public Node(long space, long price) {
			this.space = space;
			this.price = price;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [space=").append(space).append(", price=").append(price).append("]");
			return builder.toString();
		}

	}

	static List<Node> info;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long answer;
	static int N = 0;
	static long D = 0;
	static long SL = 0; // space limit
	static long PL = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			answer = 0;
			N = sc.nextInt();
			D = sc.nextLong();
			long TS = 0; // Total space
			long TP = 0; // total price
			info = new ArrayList<Node>(N);
			for (int i = 0; i < N; i++) {
				info.add(new Node(sc.nextLong(), sc.nextLong()));
				TS += info.get(i).space;
				TP += info.get(i).price;
			}
			// 넓이 내림차순 가치 오름차순
			info.sort(Comparator.comparing(Node::getSpace).reversed().thenComparing(Node::getPrice));
			// 디버그
			// System.out.println(info.toString());

			long HoSpace = 0;
			long HoPrice = 0;
			long DaSpace = 0;
			long DaPrice = 0;

			dfs(0, HoSpace, HoPrice, DaSpace, DaPrice, TS, TP);

			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
		}

	}

	private static long abs(long a) {
		return a > 0 ? a : (-a);
	}

	private static void dfs(int idx, long hoSpace, long hoPrice, long daSpace, long daPrice, long tS, long tP) {
		if (idx == N) {
			if (abs(hoSpace - daSpace) > D || hoPrice < daPrice)
				return;
			answer = answer > (hoPrice - daPrice) ? answer : (hoPrice - daPrice);
			return;
		}
		if (hoPrice + tP < daPrice || abs(hoSpace - daSpace) > tS + D || answer > tP + hoPrice - daPrice)
			return;

		tS -= info.get(idx).space;
		tP -= info.get(idx).price;

		dfs(idx + 1, hoSpace + info.get(idx).space, hoPrice + info.get(idx).price, daSpace, daPrice, tS, tP);
		dfs(idx + 1, hoSpace, hoPrice, daSpace + info.get(idx).space, daPrice + info.get(idx).price, tS, tP);
		dfs(idx + 1, hoSpace, hoPrice, daSpace, daPrice, tS, tP);

	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() throws Exception {
			// System.setIn(new FileInputStream("input.txt"));// 테스트케이스 파일을 프로젝트 폴더에 삽입
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(" ");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();

		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static long nextLong() {
			return Long.parseLong(next());
		}
	}
}
