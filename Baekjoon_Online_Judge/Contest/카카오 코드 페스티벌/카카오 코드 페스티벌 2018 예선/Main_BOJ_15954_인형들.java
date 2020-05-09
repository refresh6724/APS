import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15954_인형들 { // 제출일 2020-05-09 12:46

	static int n, k;
	static int[] arr, sum;
	static double[] m, d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 500이하
		k = Integer.parseInt(st.nextToken()); // n이하
		double min = Double.MAX_VALUE;

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));

//		int nk = k;
		for (int nk = k; nk <= n; nk++) {

			// 먼저 평균을 구하기 위해 부분합을 구해야 한다
			sum = new int[n - nk + 1];
			for (int i = 0; i < nk; i++) {
				sum[0] += arr[i];
			}
			for (int i = 1; i < n - nk + 1; i++) {
				sum[i] = sum[i - 1] + arr[i - 1 + nk] - arr[i - 1];
			}
//			System.out.println(Arrays.toString(sum));

			m = new double[n - nk + 1];
			for (int i = 0; i < n - nk + 1; i++) {
				m[i] = (double) sum[i] / nk;
			}
//			System.out.println(Arrays.toString(m));

			d = new double[n - nk + 1];
			for (int start = 0; start < n - nk + 1; start++) {
				d[start] = calc(start, nk); // end = start+k-1
			}
//			System.out.println(Arrays.toString(d));

			for (int i = 0; i < n - nk + 1; i++) {
				if (min > d[i]) {
					min = d[i];
				}
			}
		}
		System.out.println(min);
	}

	private static double calc(int start, int nk) {
		double sum = 0;
		for (int i = start; i < start + nk; i++) {
			sum += (arr[i] - m[start]) * (arr[i] - m[start]);
		}
		sum /= nk;
		return Math.sqrt(sum);
	}

}
