import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2300_용액 { // 제출일 2021-05-02 23:03

	static int n, ans;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());// 2 이상 10만 이하
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // -10억 ~ 10억
		}
		ans = Integer.MAX_VALUE;

		// 그리디한 경우 n^2 / 2 = 50억, 시간 초과

		// 2개의 합이 0에 더 가까운 것을 출력
		int left = 0;
		int right = n - 1;
		int p1 = 0;
		int p2 = 0;
		int sum = 0;
		while (left < right) {

			sum = arr[left] + arr[right];
			if (Math.abs(sum) < ans) {
				ans = Math.abs(sum);
				p1 = left;
				p2 = right;
			}

			if (sum < 0) {
				left++; // 더 작은 마이너스로 테스트
			} else {
				right--; // 더 작은 플러스로 테스트
			}

		}

		sb.append(arr[p1]).append(' ').append(arr[p2]);
		bw.write(sb.toString());
		bw.flush();
	}

}