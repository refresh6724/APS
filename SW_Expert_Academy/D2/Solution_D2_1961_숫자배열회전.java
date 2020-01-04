import java.util.Scanner;

class Solution_D2_1961_숫자배열회전 { // 제출일 2020-01-04 02:23
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			// N X N 행렬 회전
			/*
			 * 
			 * 3 
			 * 1 2 3 
			 * 4 5 6 
			 * 7 8 9
			 * 
			 * #1 
			 * 741 987 369 
			 * 852 654 258 
			 * 963 321 147
			 * 
			 */
			int n = sc.nextInt();

			int[][] a0 = new int[n][n];
			int[][] a1 = new int[n][n];
			int[][] a2 = new int[n][n];
			int[][] a3 = new int[n][n];
			int[] aa = new int[n * n];

			// 입력
			int k = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a0[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					aa[k++] = a0[i][j];
				}
			}

			// 90도 회전
			k = 0;
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					a1[j][i] = aa[k++];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					aa[i * n + j] = a1[i][j];
				}
			}

			// 180도 회전
			k = 0;
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					a2[j][i] = aa[k++];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					aa[i * n + j] = a2[i][j];
				}
			}

			// 270도 회전
			k = 0;
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					a3[j][i] = aa[k++];
				}
			}
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					aa[i * n + j] = a3[i][j];
//				}
//			}
			
			System.out.println("#"+test_case);
			
			for (int row = 0; row < n; row++) {
				for (int i = 0; i < n; i++) {
					System.out.printf("%d",a1[row][i]);
				}
				System.out.printf(" ");
				for (int i = 0; i < n; i++) {
					System.out.printf("%d",a2[row][i]);
				}
				System.out.printf(" ");
				for (int i = 0; i < n; i++) {
					System.out.printf("%d",a3[row][i]);
				}
				System.out.printf("\n");
			}
			
			
		}
	}
}
