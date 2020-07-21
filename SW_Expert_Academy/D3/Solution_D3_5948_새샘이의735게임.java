import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_D3_5948_새샘이의735게임 { // 제출일 2020-07-21 23:24 48,612 kb 192 ms
	
	static int[] num = new int[7];
	static HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');	

			// 7C3 이므로 35가지 경우의 수
			// 그냥 무식하게 해도 좋지만 
			// 5번쨰로 큰 수이므로 heap을 쓰는게 좋다고 생각했지만
			// 중복된 수를 빼야한다고 해서 set으로 변경
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 7; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}			
			set.clear();
			dfs(0,0,0);	
			// set을 array로 바꾸고 
			int n = set.size();
			int[] arr = new int[n];			
			for (int i : set) {
				arr[--n] = i;
			}
			Arrays.sort(arr);
			sb.append(arr[set.size()-5]).append('\n');

		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void dfs(int idx, int in, int sum) {
		if(in == 3) {
			set.add(sum);
			return;
		}
		if(idx==7) {
			return;
		}
		
		dfs(idx+1, in, sum);
		dfs(idx+1, in+1, sum+num[idx]);
		
	}

}