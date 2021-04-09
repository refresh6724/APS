import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_3522_Tutorial_동적계획법DynamicProgramming { // 제출일 2021-04-09 23:23

	static int[] memo;

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		memo = new int[n + 1];
		memo[1] = 1;
		memo[2] = 1;
	}

	private static void go() {
		for (int i = 3; i < memo.length; i++) {
			memo[i] = (memo[i - 1] + memo[i - 2]) % 1000000007;
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(memo[memo.length - 1]);
		bw.write(sb.toString());
		bw.flush();
	}

}