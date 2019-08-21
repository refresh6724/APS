import java.util.Scanner;

public class Solution_D5_1247_최적경로_dfs { // 제출일 2019-08-22 00:27 // 27,196 kb 314 ms
	static int MIN;
	static int N;
	static int[][] arr;
	static boolean[] visit;
	static int[][] inner;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int test = 1; test <= T; test++) {
			N = sc.nextInt();
			sc.nextLine();
			String[] arr_ = sc.nextLine().split(" ");
			arr = new int[N + 2][2];
			for (int n = 0; n < N + 2; n++)
				arr[n] = new int[] { Integer.parseInt(arr_[2 * n]), Integer.parseInt(arr_[2 * n + 1]) };
			visit = new boolean[N + 2];
			inner = new int[N + 2][N + 2];
			MIN = Integer.MAX_VALUE;

			for (int i = 0; i < N + 2; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					inner[j][i] = inner[i][j] = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]);
//					inner[j][i] = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]);
				}
			}
			dfs(0, 0, 0);
			System.out.println("#" + test + " " + MIN);
		}
	}

	static void dfs(int now, int count, int total){
        if (count == N) {
            total += inner[now][1];
            MIN = Math.min(MIN, total);
            return;
        }
 
        if(MIN < total)
            return;
 
        for(int i = 2; i<N+2; i++) {
            if(visit[i])
                continue;
            visit[i] =true;
            dfs(i, count + 1, total + inner[now][i]);
            visit[i] = false;
        }
    }
}