import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1175_주사위던지기2 { // 제출일 2021-03-29 23:26
	static class Dice {
		int[] pips;

		public Dice() {
			// TODO Auto-generated constructor stub
		}

		public Dice(int size) {
			this.pips = new int[size];
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < pips.length - 1; i++) {
				sb.append(pips[i]).append(' ');
			}
			sb.append(pips[pips.length - 1]).append('\n');
			return sb.toString();
		}
	}

	static int N;
	static int M;
	static Dice dice;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 주사위를 던짓 횟수 N(2이상 7이하)과 눈의 합 M(1이상 40이하)
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dice = new Dice(N);
		sb = new StringBuilder();

		roll(0, 0);

		bw.write(sb.toString());
		bw.flush();
	}

	static void roll(int index, int sum) {
		if (index == N) {
			if (sum == M) {
				sb.append(dice.toString());
			}
			return;
		}
		for (int i = 1; i <= 6; i++) {
			dice.pips[index] = i;
			roll(index + 1, sum + i);
		}
	}
}