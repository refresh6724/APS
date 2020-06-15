import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1005_ACMCraft { // 제출일 2020-06-15 03:50 265544 kb 636 ms
	
	static int n, k;
	static int[] memo, time;
	static boolean[][] condition;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			time = new int[n+1];					
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				time[j] = Integer.parseInt(st.nextToken());
			}
		
			memo = new int[n+1];
			Arrays.fill(memo, -1);	
			
			// 1000 * 1000 방문 배열 작성?
			// 아니면 1000개의 연결리스트 작성?
			condition = new boolean[1001][1001];
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int bf = Integer.parseInt(st.nextToken());
				int af = Integer.parseInt(st.nextToken());
				condition[bf][af] = true;				
			}
			
			int win = Integer.parseInt(br.readLine());
			// win 건물을 짓기 위해 필요한 건물을 모두 돌면서 가장 긴 시간을 더해준다
			answer = countTime(win);
			
			sb.append(answer).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static int countTime(int win) {
		if(memo[win]!=-1) {
			return memo[win];
		}
		
		int ret = 0;
		for (int i = 1; i <= n; i++) {
			if(condition[i][win]) { // win을 짓기위해 i가 필요하다면
				ret = Math.max(ret, countTime(i)); 
				// 바로 이전까지 만들 수 있는 건물 중 가장 오래 걸리는 시간
			}			
		}
		return memo[win] = ret + time[win]; 
		// 바로 전 건물까지 가장 오래걸리는 시간 + 지금 지어야 하는 건물 시간
	}

}