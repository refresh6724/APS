import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 약 600 ms
 * 자바에서 좌표압축 방식으로 풀 경우 약 4초 걸리는듯, c++는 잘 모르겠다
 * @author refresh6724
 */
public class Solution_Level_4_캠핑 { // 제출일 2020-10-17 01:04
	
	public static void main(String[] args) {
		userTest();
//		autoTest();
	}

	public static void userTest() {
		System.out.println(solution(4, new int[][] { { 0, 0 }, { 1, 1 }, { 0, 2 }, { 2, 0 } })); // 3
		System.out.println(solution(4, new int[][] { { 0, 0 }, { Integer.MAX_VALUE, 0 }, { 0, Integer.MAX_VALUE }, { Integer.MAX_VALUE, Integer.MAX_VALUE } })); // 2
		System.out.println(solution(5, new int[][] { { 0, 0 }, { 1, 1 }, { Integer.MAX_VALUE, 0 }, { 0, Integer.MAX_VALUE }, { Integer.MAX_VALUE, Integer.MAX_VALUE } })); // 4
		System.out.println(solution(6, new int[][] { { 0, 0 }, { 1, 1 }, { 2, 2 }, { Integer.MAX_VALUE, 0 }, { 0, Integer.MAX_VALUE }, { Integer.MAX_VALUE, Integer.MAX_VALUE } })); // 7
		System.out.println(solution(8, new int[][] { { 0, 0 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 }, { 2, 0 }, { 3, 2 }, { 4, 1 } })); // 16
		System.out.println(solution(10, new int[][] { { 1, 56 }, { 4, 118 }, { 11, 114 }, { 38, 66 }, { 122, 31 }, { 123, 120 }, { 123, 57 }, { 140, 195 }, { 142, 129 }, { 156, 171 } })); // 21
		System.out.println(solution(10, new int[][] { { 1, 2 }, { 2, 6 }, { 3, 5 }, { 4, 4 }, { 5, 1 }, { 6, 7 }, { 6, 3 }, { 7, 10 }, { 8, 8 }, { 9, 9 } })); // 21
	}

	public static void autoTest() {
		int n = 10; // 최대 5000
		int[][] arr = makingRandomArray(n);
		int sol1 = solution(n, arr);
		System.out.println(sol1);
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	private static int[][] makingRandomArray(int n) {
		Random rand = new Random();
		int[][] ret = new int[n][2];
		for (int i = 0; i < n; i++) {
			ret[i][0] = 10 + rand.nextInt() % 10;
			ret[i][1] = 10 + rand.nextInt() % 10;
		}
		return ret;
	}

	public static int solution(int n, int[][] data) {
		// n개에서 2점을 골라 대각선으로 하는 직사각형을 만들때 다른 점이 내부에 들어가지 않도록 하는 경우의 수

		// 1. 완전탐색 5000 * 5000 = 2500만
		int answer = 0;
		// 1-1. 정렬
		Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});

		// 1-2. x=0 열에서 y=0 부터 하나씩 이동하며 각 점에서 좌상단, 우상단의 점을 확인
		for (int i = 0; i < n; i++) {
			// 현재 점 i번째 좌표 x=data[i][0], y=data[i][1]
			int min = Integer.MAX_VALUE;
			// 1-3. 좌측
			for (int j = i - 1; j >= 0; j--) {
				// j 점 좌표가 i 점 좌측에서 가장 가까운 열의 최상단(좌상단)이므로 min 값을 갱신
				if (data[i][1] < data[j][1] && data[j][1] <= min) {
					// 정답에 더해질 수 있는 y 값은 현재 i점 보다 크면서 min 이하값이어야 한다
					min = data[j][1];
					answer++;
				}
			}

			// 1-4. 우측
			int prevMin = Integer.MAX_VALUE;
			int nextMin = Integer.MAX_VALUE;
			int col = -1;
			for (int j = i + 1; j < n; j++) {
				// 좌측과 진행 순서가 달라 y가 낮은 값부터 나오므로 x값이 바뀔 때 마다 min 값을 갱신해줘야 한다
				// 첫번째로 나온 x값에 대해서는 min 제한이 적용되지 않는다는 점에 주의해야 한다

				if (data[i][0] < data[j][0] && data[i][1] < data[j][1]) {
					// 우상단 점이어야 한다
					if (data[j][0] != col && data[j][1] <= nextMin) {
						// x 값이 바뀌었다면 min을 갱신해준다
						col = data[j][0];
						prevMin = nextMin;
						nextMin = data[j][1];
						answer++;
					} else if (data[j][0] == col && data[j][1] <= prevMin) {
						answer++;
					}
				}
			}
		}

		return answer;
	}
}