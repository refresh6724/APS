package keeping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_8673_코딩토너먼트1 { // 제출일 2020-04-02 01:55
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	static int ans;
	static int[] input;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			
			int k = Integer.parseInt(br.readLine());
			input = new int[1<<k];		
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < input.length; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			} 
			int start = 0;
			int size = 1<<k;
			ans = 0;
			dfs(start, size);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

	private static int dfs(int start, int size) {
		if(size == 1) {
			return input[start];		
		}
		// 사이즈가 2일때까지 내려갔다가 올라오면서 merge한다
		
		size >>= 1;
		int left = dfs(start, size);
		int right = dfs(start+size, size);
		if(left>right) {
			ans += left-right;
			return left;
		} else {
			ans += right-left;
			return right;
		}		
		
	}

}
