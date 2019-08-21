import java.util.Scanner;

public class Solution_D5_1247_최적경로_순열스왑 { // 제출일 2019-08-22 00:27 // 35,488 kb 1,171 ms
	static int N;
	static int[][] customers;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int ans = 2000;
			N = sc.nextInt(); // 고객의 수

			numbers = new int[N];
			for (int i = 0; i < N; i++) {
				numbers[i] = i;
			}

			// 회사의 좌표
			int cx = sc.nextInt();
			int cy = sc.nextInt();
			// 집의 좌표
			int hx = sc.nextInt();
			int hy = sc.nextInt();

			// 고객들의 좌표
			customers = new int[N][2];
			for (int i = 0; i < N; i++) {
				customers[i][0] = sc.nextInt();
				customers[i][1] = sc.nextInt();
			}

			do {
				int temp = 0;
				// 회사에서 -> 첫번째 고객 거리
				temp += Math.abs(cx - customers[numbers[0]][0]) + Math.abs(cy - customers[numbers[0]][1]);
				int sx = customers[numbers[0]][0];
				int sy = customers[numbers[0]][1];

				for (int i = 1; i < N; i++) {
					temp += Math.abs(sx - customers[numbers[i]][0]) + Math.abs(sy - customers[numbers[i]][1]);
					sx = customers[numbers[i]][0];
					sy = customers[numbers[i]][1];
				}

				// 마지막 고객에서 -> 집까지 거리
				temp += Math.abs(hx - customers[numbers[N - 1]][0]) + Math.abs(hy - customers[numbers[N - 1]][1]);

				if (temp < ans)
					ans = temp;
			} while (nextPermutation());

			System.out.println("#" + t + " " + ans);
		}

	}

	private static boolean nextPermutation() {
		// totalCount++;
		// 1. 뒷쪽부터 왼쪽으로 탐색하며 교환이 필요한 위치 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		// 찾은위치가 0이면 이미 내림차순된 순열이므로 다음순열은 없다.
		if (i == 0)
			return false;

		// 2. i-1위치 : 교환이 필요한 위치
		// i-1위치값과 교환할 뒷쪽에서 다음 큰 수 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;
		// 3. i-1위치값과 j위치값 교환
		swap(i - 1, j);
		// 4. i위치부터 끝까지의 순열을 오름차순으로 재조정
		j = N - 1;
		while (i < j) {
			swap(i++, j--);
		}
		return true;
	}

	private static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}