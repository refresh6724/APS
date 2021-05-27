import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2450_모양정돈 { // 제출일 2020-02-23 23:41
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int n;
	static int[] arr;
	static int[] num;
	static int[][] orders = { {}, { 1, 2, 3 }, { 1, 3, 2 }, { 2, 1, 3 }, { 2, 3, 1 }, { 3, 1, 2 }, { 3, 2, 1 } };
	static int[] diff;
	static int[][] compare;
	static int ans;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[n];
		num = new int[4];
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			num[a]++;
			arr[i] = a;
		}
		// 1. 개수를 센다
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(num));

		// 2. 6가지 경우의 수에 대해 비교하여
		diff = new int[7];
		diff[0] = 100000;
		compare = new int[7][n];
		for (int order = 1; order <= 6; order++) {

			int a = orders[order][0];
			int b = orders[order][1];
			int c = orders[order][2];

			int la = num[a];
			int lb = num[a] + num[b];
//			int lc = num[a] + num[b] + num[c]; // == n

			for (int i = 0; i < la; i++) {
				compare[order][i] = a;
			}
			for (int i = la; i < lb; i++) {
				compare[order][i] = b;
			}
			for (int i = lb; i < n; i++) {
				compare[order][i] = c;
			}
			// 비교

			// 현재 1의 위치에 있는 2의 개수
			// 현재 1의 위치에 있는 3의 개수
			// 현재 2의 위치에 있는 1의 개수
			// 현재 2의 위치에 있는 3의 개수
			// 현재 3의 위치에 있는 1의 개수
			// 현재 3의 위치에 있는 2의 개수
			int d12 = 0, d13 = 0, d21 = 0, d23 = 0, d31 = 0, d32 = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] == 1) {
					if (compare[order][i] == 2) {
						d12++;
					} else if (compare[order][i] == 3) {
						d13++;
					}
				} else if (arr[i] == 2) {
					if (compare[order][i] == 1) {
						d21++;
					} else if (compare[order][i] == 3) {
						d23++;
					}
				} else if (arr[i] == 3) {
					if (compare[order][i] == 1) {
						d31++;
					} else if (compare[order][i] == 2) {
						d32++;
					}
				}
			}
			diff[order] = d12 + d13 + Math.max(d23, d32);

		}

//		if (1,2) - (2,1) >= 0 ? (1,2) + (1,3) + (1,2) - (2,1) + (3,2)
//		else  (1,2) + (1,3) + (1,3) - (3,1) + (2,3)
//		(1,2) + (1,3) + max( (2,3) , (3,2) )
		Arrays.sort(diff);
		System.out.println(diff[0]);

	}

}