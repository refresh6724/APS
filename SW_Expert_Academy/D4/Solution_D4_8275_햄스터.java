import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_8275_햄스터 { // 제출일 2020-03-04 16:18

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();

	static int N, X, M;
	static int[] n;
	static int[][] cond;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			n = new int[N];
			cond = new int[M][3];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				cond[i][0] = Integer.parseInt(st.nextToken());
				cond[i][1] = Integer.parseInt(st.nextToken());
				cond[i][2] = Integer.parseInt(st.nextToken());
			}

			max = -1;
			dfs(0, 0);
			
			sb.append("#").append(t);
			if (max > -1) {
				sb.append(sb2);
			} else {
				sb.append(" ").append("-1");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void dfs(int idx, int sum) {
		
		if(idx == N) {
			// M 개의 조건 체크
			if(check()) {
				if(max < sum) {
					max = sum;
					sb2 = new StringBuilder();
					for (int i = 0; i < N; i++) {
						sb2.append(" ").append(n[i]);
					}
				}
			}			
			return;
		}
		
		for (int i = 0; i <= X; i++) {
			n[idx] = i;
			dfs(idx+1, sum+i);
		}
		
	}

	private static boolean check() {
		for (int i = 0; i < M; i++) {
			int tmp = 0;
			
			int l = cond[i][0]-1;
			int r = cond[i][1]-1;
			int s = cond[i][2];
			
			for (int j = l; j <= r; j++) {
				tmp += n[j];
			}
			
			if(tmp != s) {
				return false;
			}
		}
		return true;		
	}


}
