import java.util.Scanner;

// _D0_4014_활주로건설
public class Solution_D0_4014_활주로건설 { // 제출일 2019-11-08 13:03
	static int N;
	static int X;
	static int[][] map;
	static int answer;
	static boolean find;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			X = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			answer = 0;
			// 각 행 열 별로 테스트
			for (int row = 0; row < N; row++) {
				testRow(row);
			}
			for (int col = 0; col < N; col++) {
				testCol(col);
			}
			System.out.printf("#%d %d\n", t, answer);

		}
	}

	private static void testRow(int row) {
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = map[row][i];
		}
		int[] install = new int[N];
		find = false;
		dfs(arr, 0, install);
	}

	private static void testCol(int col) {
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = map[i][col];
		}
		int[] install = new int[N];
		find = false;
		dfs(arr, 0, install);
	}

	private static void dfs(int[] arr, int idx, int[] install) {
		if(find) return;
		if (idx == N) { // 종료 조건			
			answer++;
			find = true;
			
//			System.out.println(answer);
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(install));
//			System.out.println();
			return;
		}

		// 가지치기 조건
		if (idx > 0 && Math.abs(arr[idx - 1] - arr[idx]) > 1) {
			return; // 바로 옆이 두칸 이상 차이난다면 리턴
		}
		if (idx > 0 && arr[idx - 1] - arr[idx] == 1) {
			// 한칸 내려왔는데 경사로 설치가 불가능하다면 리턴
			if (idx + X - 1 > N - 1)
				return;
			if (X == 2) { // 그런게 아니라면 무조건 내리막 설치
				if (arr[idx] == arr[idx + 1]) {
					install[idx] = 1;
					install[idx + 1] = 1;
				} else {
					return;
				}
			} else if (X == 3) {
				if (arr[idx] == arr[idx + 1] && arr[idx + 1] == arr[idx + 2]) {
					install[idx] = 1;
					install[idx + 1] = 1;
					install[idx + 2] = 1;
				} else {
					return;
				}
			} else if (X == 4) {
				if (arr[idx] == arr[idx + 1] && arr[idx + 1] == arr[idx + 2] && arr[idx + 2] == arr[idx + 3]) {
					install[idx] = 1;
					install[idx + 1] = 1;
					install[idx + 2] = 1;
					install[idx + 3] = 1;
				} else {
					return;
				}
			}
		}
		if (idx > 0 && arr[idx - 1] - arr[idx] == -1) {
			// 한칸 올라왔는데 경사로가 오르막으로 설치되어있지 않았다면 리턴
			if (install[idx] != 0 || install[idx - 1] != 2) 
				return;
		}
		

		// 설치하지 않고 다음 진행
		dfs(arr, idx + 1, install);

		// 올라가는 경사로 
		
		// 경사로를 설치할 수 있다면 NONO 
		// 경사로를 설치해야 한다면 설치하고 다음 진행
		if (idx - X + 1 >= 0) { // 거리가 되고
			// idx-X+1 ~ idx까지 모두 같은 높이라면
			if (X == 2) {
				if (arr[idx - 1] == arr[idx]) {
					// 설치할 수 있을때만 다음 진행
					if (install[idx - 1] == 0
							&& install[idx] == 0) {
						install[idx - 1] = 2;
						install[idx] = 2;
						dfs(arr, idx + 1, install);
					}
				}
			} else if (X == 3) {
				if (arr[idx - 2] == arr[idx - 1] && arr[idx - 1] == arr[idx]) {
					if (install[idx - 2] == 0 && install[idx - 1]== 0 
							&& install[idx]== 0) {
						install[idx - 2] = 2;
						install[idx - 1] = 2;
						install[idx] = 2;
						dfs(arr, idx + 1, install);
					}
				}
			} else if (X == 4) {
				if (arr[idx - 3] == arr[idx - 2] && arr[idx - 2] == arr[idx - 1] && arr[idx - 1] == arr[idx]) {
					if (install[idx - 3]== 0 && install[idx - 2] == 0
							&& install[idx - 1]== 0 && install[idx]== 0) {
						install[idx - 3] = 2;
						install[idx - 2] = 2;
						install[idx - 1] = 2;
						install[idx] = 2;
						dfs(arr, idx + 1, install);
					}
				}
			}
		}
	}
}
