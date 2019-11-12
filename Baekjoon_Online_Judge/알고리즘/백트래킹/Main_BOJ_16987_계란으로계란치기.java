import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_16987_계란으로계란치기 { // 제출일 2019-11-12 10:40

	static class Egg {
		int attack; //
		int defence; //

		public Egg() {
			// TODO Auto-generated constructor stub
		}

		public Egg(int defence, int attack) {
			this.defence = defence;
			this.attack = attack;
		}

		@Override
		public String toString() {
			return String.format("공 : %d 방 : %d\n", this.attack, this.defence);
		}
	}

	static ArrayList<Egg> list;
	static int N;
	static int answer;
	static boolean[] destroyed;
	static int[][] hit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			list.add(new Egg(sc.nextInt(), sc.nextInt()));
		}
		answer = 0;
		for (int target = 1; target < N; target++) {
			int hand = 0;
			int destroy = 0;
			destroyed = new boolean[N];
			dfs(hand, target, destroy);
		}
		System.out.println(answer);

	}

	private static void dfs(int hand, int thisTarget, int destroy) {
		if (hand == N) { // 다음 집을 계란이 없으면 끝
			if (answer < destroy) {
				answer = destroy;
				//System.out.println(Arrays.toString(destroyed));
			}
			return;
		}

		if (destroyed[thisTarget]) {
			dfs(N, thisTarget, destroy);
			return;
		}
		// 손에 든 계란이 깨졌다면 치지 않고 넘어간다
		if (destroyed[hand]) {
			dfs(hand + 1, thisTarget, destroy);
			return;
		}
		// 손에 든 것과 타겟이 같으면 넘어간다
		if (hand == thisTarget) {
			dfs(hand + 1, thisTarget, destroy);
			return;
		}

		Egg inhand = list.get(hand);
		Egg target = list.get(thisTarget);

		inhand.defence -= target.attack;
		target.defence -= inhand.attack;

		//

		if (inhand.defence <= 0 && target.defence <= 0) { // 둘 다 부서진 경우
			destroyed[hand] = true;
			destroyed[thisTarget] = true;
			// 3번과정으로 넘어간다
			for (int nextTarget = 0; nextTarget < N; nextTarget++) {
				dfs(hand + 1, nextTarget, destroy + 2);
			}
			destroyed[hand] = false;
			destroyed[thisTarget] = false;

		} else if (inhand.defence <= 0) { // 손에 든 것만 부서진 경우
			destroyed[hand] = true;
			// 3번과정으로 넘어간다
			for (int nextTarget = 0; nextTarget < N; nextTarget++) {
				dfs(hand + 1, nextTarget, destroy + 1);
			}
			destroyed[hand] = false;
		} else if (target.defence <= 0) { // 타겟만 부서진 경우
			destroyed[thisTarget] = true;
			// 3번과정으로 넘어간다
			for (int nextTarget = 0; nextTarget < N; nextTarget++) {
				dfs(hand + 1, nextTarget, destroy + 1);
			}
			destroyed[thisTarget] = false;
		} else { // 둘 다 부서지지 않았을 경우
			// 3번과정으로 넘어간다
			for (int nextTarget = 0; nextTarget < N; nextTarget++) {
				dfs(hand + 1, nextTarget, destroy);
			}
		}

		//

		inhand.defence += target.attack;
		target.defence += inhand.attack;

	}

}
