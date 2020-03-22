import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_9229_한빈이와SpotMart { // 제출일 2020-03-22 23:18

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int n,m;
	static int[] weight;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			weight = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(weight);
//			System.out.println(Arrays.toString(weight));
			
			ans = -1;
			
			for (int first = 0; first < n; first++) {
				if(weight[first] < m) {
					selectNext(first, weight[first]);	
					if(ans==m) break;
				}else {
					break;
				}
			}
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void selectNext(int first, int sum) {
		for (int second = first+1; second < n; second++) {
			int tmp = sum;
			tmp += weight[second];
			if(tmp > m) {
				return;
			} else if(tmp > ans) {
				ans = tmp;
			}
		}
		
	}

}
