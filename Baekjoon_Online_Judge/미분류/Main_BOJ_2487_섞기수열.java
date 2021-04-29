import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_BOJ_2487_섞기수열 { // 제출일 2021-04-29 18:17

	static int n, max, ans;
	static boolean[] visited;	
	static int[] order, ret;
	static Set<Integer> set;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		FastReader fr = new FastReader();

		n = fr.nextInt(); // 1 이상 2만 이하
		order = new int[n];
		for (int i = 0; i < n; i++) {
			order[i] = fr.nextInt() - 1; // 1에서 n까지 한번씩
		}
		ret = new int[n];
		set = new HashSet<Integer>();
		max = 1;
		ans = 1;
		visited = new boolean[n];
		list = new ArrayList<>();
	}

	private static void go() {
		// 각 자리가 제자리로 돌아오는 횟수의 공배수
		int cnt, next;
		for (int i = 0; i < order.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				next = order[i];
				cnt = 1;
				while (next != i) {
					visited[next] = true;
					next = order[next];
					cnt++;
				}				
//				ret[i] = cnt;
//				set.add(cnt);
//				max = Math.max(max, cnt);
				list.add(cnt);
			}			
		}

//		getAns_no1(); // 배열을 사용
//		getAns_no2(); // 세트를 사용
//		getAns_no3(); // 최댓값의 배수를 사용
		getAns_no4(); // visited를 사용

	}

	private static void getAns_no4() {
		// *같은 점을 밟는 경로는 모두 같은 cnt를 갖는다* 
		// 따라서 ret 배열이나 set으로 중복을 제거할 필요가 없다
		// JO 100점
		// d14.in : mem=13104k time=217ms
		// d15.in : mem=13104k time=140ms
		// BOJ 14652 kb	136 ms
		
		ans = 1;
		for(int a : list) {
			ans = lcm(ans, a);
		}
	}

	private static void getAns_no3() {
		// max의 배수 중 하나가 다른 모든 수에 대해 공통의 배수가 된다면 그 값이 LCM이다
		// JO 87점
		// d14.in : mem=22848k time=1930ms
		// d15.in : mem=22848k time=1038ms
		// BOJ 메모리 초과
		ans = max;
		while (!ansIsCommonMultiple()) {
			ans += max;
		}

	}

	private static void getAns_no2() {
		// 일반적인 N개의 수의 LCM 구하는 방법
		// 93점
		// d14.in : mem=16608k time=1944ms
		// d15.in : mem=16608k time=999ms
		// BOJ 16496 kb	1336 ms
		ans = 1;
		for (int a : set) {
			ans = lcm(ans, a);
		}
	}

	private static void getAns_no1() {
		// ret 배열을 만들어 정렬 후 중복을 제외하는 방법
		// 87점
		// d14.in : mem=17344k time=1934ms
		// d15.in : mem=21636k time=1223ms
		// BOJ 17576 kb	1368 ms
		Arrays.parallelSort(ret);
		ans = ret[0];
		for (int i = 1; i < ret.length; i++) {
			if (ret[i - 1] != ret[i]) {
				ans = lcm(ans, ret[i]);
			}
		}
	}

	private static boolean ansIsCommonMultiple() {
		for (int a : set) {
			if (ans % a != 0) {
				return false;
			}
		}
		return true;
	}

	private static int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}

	private static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, (a % b));
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

	// https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
	// 4.Using Reader Class:

	static class FastReader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public FastReader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public FastReader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n') {
					if (cnt != 0) {
						break;
					} else {
						continue;
					}
				}
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

}