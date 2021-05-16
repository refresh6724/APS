import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_JO_1027_좋은수열 { // 제출일 2021-05-16 23:25

	static int n;
	static int[] arr;
	static String ans;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		ans = null;
	}

	private static void go() {
		// 첫번째 자리에 1이 결정되면 => 1
		// 두번째 자리는 첫번째 자리와 달라야 하므로 2가 되고 => 12
		// 세번째 자리는 앞의 두번째 자리와 달라야 하므로 1이 된다 => 121
		// 네번째 자리는 앞의 세번째 자리와 달라야 하므로 2가 되어야 하지만 
		// 1212가 되므로 두번째 자리를 고려하여 3이 되어야 한다 => 1213
		// 다섯번째 자리는 앞의 네번째 자리와 달라야 하므로 1이 되고
		// 이를 반복하면 여덟번째 자리에서 문제가 생기는데
		// 1213121 다음 자리가 1이 되어도 문제 2가 되어도 문제 3이 되어도 문제이므로
		// 앞으로 가서 일곱번째 자리를 1이 아닌 3으로 바꿔서 1213123 으로 바꾸고
		// 여덟번째 자리에 1을 넣어 12131231 이 된다

		dfs(0);
	}

	private static void dfs(int idx) {
		if (ans != null) {
			return;
		}

		if (idx == n) {
			print();
			return;
		}

		for (int next = 1; next <= 3; next++) {
			if (ans == null) {
				arr[idx] = next;
				if (prove(idx)) {
					dfs(idx + 1);
				}
			}
		}

	}

	/**
	 * idx까지 좋은 수열인지 검증한다
	 * 
	 * @param idx
	 * @return 좋은 수열이면 true
	 */
	private static boolean prove(int idx) {
		int left = idx - 1;
		int right = idx;
		boolean bad = false;

		while (left >= 0) {
			bad = true;
			for (int i = 0; i + right <= idx; i++) {
				// 끝까지 같다면 나쁜 수열
				if (arr[left + i] != arr[right + i]) {
					bad = false;
					break;
				}
			}
			if (bad) {
				return false;
			}

			left -= 2;
			right -= 1;
		}
		return true;
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		ans = sb.toString();
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}

}