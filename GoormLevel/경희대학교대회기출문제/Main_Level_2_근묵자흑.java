import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Level_2_근묵자흑 { // 제출일 2020-09-05 23:28
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1부터 N까지 모든 정수가 한번씩 나오는 길이 N의 수열
		// 연속 K개를 골라 가장 작은 정수로 바꿀 때 바꿔야 하는 최소 횟수는?
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 결과적으로 모두 1이 되어야 한다
		int idx = 0;
		int ans = 0;
		while(idx < N) {
			if(idx == 0) {
				idx += K;
			} else {
				idx += K-1;
			}
			ans++;
		}
		System.out.println(ans);
	}
}