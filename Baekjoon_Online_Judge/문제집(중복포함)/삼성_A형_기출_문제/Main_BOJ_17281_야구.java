import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// 백준 17281 야구
// https://www.acmicpc.net/problem/17281

class Game { // 제출일 2019-10-16 18:41
	int score;
	boolean first;
	boolean second;
	boolean third;
	int out;
	int set;

	public Game() {
		this.score = 0;
		this.first = false;
		this.second = false;
		this.third = false;
		this.out = 0;
		this.set = 0;
	}

	public void do0() {
		if(++this.out == 3) doChange();
	}

	public void do1() {
		if (this.third)
			this.score++;
		this.third = this.second;
		this.second = this.first;
		this.first = true;
	}

	public void do2() {
		if (this.third)
			this.score++;
		this.third = this.first;
		if (this.second)
			this.score++;
		else this.second = true;
		this.first = false;
	}

	public void do3() {
		if (this.third)
			this.score++;
		else this.third = true;
		if (this.second) {
			this.score++;
			this.second = false;
		}
		if (this.first) {
			this.score++;
			this.first = false;
		}
	}

	public void do4() {
		this.score++;
		if (this.first) {
			this.first = false;
			this.score++;
		}
		if (this.second) {
			this.second = false;
			this.score++;
		}
		if (this.third) {
			this.third = false;
			this.score++;
		}
	}

	public void doChange() {
		this.first = false;
		this.second = false;
		this.third = false;
		this.out = 0;
		this.set++;
	}
}

public class Main_BOJ_17281_야구 {
	/**
	 * 얻을 수 있는 최대 점수
	 */
	static int answer;
	/**
	 * 이닝 수 2 이상 50 이하
	 */
	static int N;
	/**
	 * 선수 9명
	 */
	static int player = 9;
	/**
	 * n번 이닝에서 m번 선수의 기록 1번이 4번타자로 지정되어있다
	 */
	static int[][] get;
	/**
	 * 타순 0번 ~ 8번으로 사용
	 */
	// static int[] order;
	/**
	 * 순번을 저장할 map
	 */
	static HashMap<int[], Integer> map;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = 0;
		N = sc.nextInt();
		get = new int[N][player];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < player; j++) {
				get[i][j] = sc.nextInt();
			}
		}
		// 완전탐색
		// 각 타순에 각 타자를 돌려가며 게임을 진행하고 점수를 비교하여 가장 큰 점수를 출력
		int[] order = new int[player];
		for (int i = 0; i < player; i++) {
			order[i] = i;
		}
		// System.out.println(Arrays.toString(order));

		// step 1. 타순 정하기
		// 0번 제외 1번부터 8번을 타순 0번~2번, 4번~8번에 지정해야한다
		// 이 때 4번 타자가 1번 선수로 지정되어 있기 때문에 nextPermutation 함수 내부에
		// if(order[3] != 0) continue; 로 진행이 가능하다
		// 또 선수는 다르지만 그 값은 같은 경우가 다시 진행되는 경우를 제외하기 위해서
		// order 순서를 중복없이 저장할 해시맵을 만들어 저장한다.

		// map = new HashMap<int[], Integer>();
		while (nextPermutation(order)) {
		} // https://mygumi.tistory.com/60

		// 입력이 끝난 뒤 HashMap을 iterator를 사용하여 하나씩 출력하여 게임을 진행한다
		// System.out.println("keySet");
		// for (int[] key : map.keySet()) { // https://stove99.tistory.com/96
		// System.out.println(Arrays.toString(key));
		// }

		// step 2. 게임 진행하기

		System.out.println(answer);
	}

	// 1. Find largest index i such that array[i − 1] < array[i].
	// (If no such i exists, then this is already the last permutation.)
	// 2. Find largest index j such that j ≥ i and array[j] > array[i − 1].
	// 3. Swap array[j] and array[i − 1].
	// 4. Reverse the suffix starting at array[i].
	// 출처: https://mygumi.tistory.com/60 [마이구미의 HelloWorld]

	static boolean nextPermutation(int[] order) {
		// i는 증가하지 않는 가장 긴 접미사 인덱스
		int i = player - 1;
		while (i > 0 && order[i - 1] >= order[i])
			i--;

		// 마지막 변경이 되었을 때 4321일 경우
		// i는 위의 접미사 인덱스를 구하는 과정에서 -1이 됨.
		if (i <= 0)
			return false;

		// array[i-1] 요소를 피벗으로 정함.
		// 피벗 기준으로 스왑할 (가장 큰) 오른쪽 요소를 찾음
		int j = player - 1;
		while (order[j] <= order[i - 1])
			j--;

		// array[j] <= array[i - 1] 조건인 이유는.
		// array[j]는 array[i - 1]보다 항상 커야하기 때문이다.
		// => 사전 순으로 모든 경우의 수를 들려야하기 때문.
		// array[i - 1] 와 array[j]를 이용하여 새로운 피벗 구함.
		// array[j] 요소가 새로운 피벗이 된다.
		// Assertion: j >= i

		// 피벗 2개는 서로 스왑에 이용하기 위해 사용됨.
		// 새로운 피벗을 이용하여 스왑.
		int temp = order[i - 1];
		order[i - 1] = order[j];
		order[j] = temp;

		// 위의 과정이 일어나더라도 사전순으로 되지 않음.
		// 접미사 인덱스를 활용하여 반대로 만들어준다.
		j = player - 1;
		while (i < j) {
			temp = order[i];
			order[i] = order[j];
			order[j] = temp;
			i++;
			j--;
		}

		if (order[3] == 0) {
			//System.out.println(Arrays.toString(order));
			doGame(order);
		}

		return true;
	}

	private static void doGame(int[] order) {
		Game game = new Game();
		int thisgame = 0;
		int thisorder = -1;
		while (thisgame != N) {
			thisorder = (++thisorder) % 9;
			switch (get
					[thisgame]
							[order[thisorder]]) {
			case 0:
				game.do0();				
				thisgame = game.set;
				break;
			case 1:
				game.do1();
				break;
			case 2:
				game.do2();
				break;
			case 3:
				game.do3();
				break;
			case 4:
				game.do4();				
				break;
			}
		}
		if(answer < game.score) {
			answer = game.score;			
		}
		
		// 디버그
//		if(game.score != answer) {
//			System.out.println(Arrays.toString(order));
//			System.out.println(game.score);
//		}		
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
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
