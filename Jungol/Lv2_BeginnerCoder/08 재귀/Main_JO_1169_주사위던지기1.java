import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1169_주사위던지기1 { // 제출일 2021-03-29 23:21

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
	static Dice dice;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		dice = new Dice(N);

		switch (M) {
		case 1:
			rollAll(0);
			break;
		case 2:
			rollCombination(0, 1);
			break;
		case 3:
			rollPermutation(0, 0);
			break;
		}

		bw.write(sb.toString());
		bw.flush();
	}

	static void rollAll(int index) {

		// 주사위를 N번 던져 나올 수 있는 모든 경우
		// 111 부터 666까지

		if (index == N) {
			sb.append(dice.toString());
			return;
		}
		for (int i = 1; i <= 6; i++) {
			dice.pips[index] = i;
			rollAll(index + 1);
		}
	}

	static void rollCombination(int index, int pip) {

		// 1번에서 중복을 제외하고
		// 111 에서 666까지 즉 566 다음 611이 아니라 666 인 경우
		// 1 다음에는 1에서 6까지 나올 수 있지만 6 다음에는 6밖에 못온다

		if (index == N) {
			sb.append(dice.toString());
			return;
		}

		if (pip == 7) {
			return;
		}

		dice.pips[index] = pip;
		rollCombination(index + 1, pip);
		rollCombination(index, pip + 1); // 이대로 넘겨서 덮어쓰기

	}

	static void rollPermutation(int index, int bit) {

		// 서로 다른 조합(원소 중복 허용)
		// 123 부터 321 ... 654 까지

		if (index == N) {
			sb.append(dice.toString());
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if ((bit & (1 << i)) != (1 << i)) { // 미방문시에만
				dice.pips[index] = i;
				bit |= (1 << i);
				rollPermutation(index + 1, bit);
				bit ^= (1 << i);
			}
		}
	}

}