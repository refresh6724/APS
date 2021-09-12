import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution_Level_1_6주차 { // 제출일 2021-09-12 21:32

	// test
	public static void main(String[] args) {
		int[] weights;
		String[] head2head;

		weights = new int[] { 50, 82, 75, 120 };
		head2head = new String[] { "NLWL", "WNLL", "LWNW", "WWLN" };
		System.out.println(Arrays.toString(solution(weights, head2head)));
		// 3, 4, 1, 2

		weights = new int[] { 145, 92, 86 };
		head2head = new String[] { "NLW", "WNL", "LWN" };
		System.out.println(Arrays.toString(solution(weights, head2head)));
		// 2,3,1

		weights = new int[] { 60, 70, 60 };
		head2head = new String[] { "NNN", "NNN", "NNN" };
		System.out.println(Arrays.toString(solution(weights, head2head)));
		// 2,1,3
	}

	static class Boxer implements Comparable<Boxer> {

		int idx;
		int weight;
		int win;
		int overwin;
		int lose;
		double per;

		public Boxer() {
			// TODO Auto-generated constructor stub
		}

		public Boxer(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
			this.win = 0;
			this.overwin = 0;
			this.lose = 0;
			this.per = 0;
		}

		public void win() {
			this.win++;
			this.calcPer();
		}

		public void lose() {
			this.lose++;
			this.calcPer();
		}

		private void calcPer() {
			this.per = (double) (win) / (win + lose);
		}

		@Override
		public int compareTo(Boxer o) {
			if (o.per == this.per) {
				if (o.overwin == this.overwin) {
					if (o.weight == this.weight) {
						return this.idx - o.idx;
					}
					return o.weight - this.weight;
				}
				return o.overwin - this.overwin;
			}
			return (o.per > this.per) ? 1 : -1;
		}

	}

	public static int[] solution(int[] weights, String[] head2head) {
		ArrayList<Boxer> players = new ArrayList<>();
		for (int i = 0; i < weights.length; i++) {
			players.add(new Boxer(i + 1, weights[i]));
		}

		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < weights.length; j++) {
				if (i < j) {
					if (head2head[i].charAt(j) == 'L') {
						players.get(i).lose();
						players.get(j).win();
						if (players.get(j).weight < players.get(i).weight) {
							players.get(j).overwin++;
						}
					} else if (head2head[i].charAt(j) == 'W') {
						players.get(j).lose();
						players.get(i).win();
						if (players.get(i).weight < players.get(j).weight) {
							players.get(i).overwin++;
						}
					}
				}
			}
		}

		Collections.sort(players);
		int[] ret = new int[weights.length];
		for (int i = 0; i < weights.length; i++) {
			ret[i] = players.get(i).idx;
		}
		return ret;
	}
}
