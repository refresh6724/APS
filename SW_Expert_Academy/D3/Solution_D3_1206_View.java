import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1206_View { // 제출일 2020-03-26 23:44

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	static int ans, n, mid;
	static LinkedList<Integer> five;
	static Integer[] a;

	public static void main(String[] args) throws NumberFormatException, IOException {

//		int T = Integer.parseInt(br.readLine());
//		int T = 10;
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());			
			st = new StringTokenizer(br.readLine());
			ans = 0;
			five = new LinkedList<Integer>();			
			for (int i = 0; i < 4; i++) {
				five.add(Integer.parseInt(st.nextToken()));
			}
			// 5개의 숫자를 보고 가운데 숫자가 최고층이라면 정답에 최고층 - 두번째를 더한다
			mid = 0;
			a = new Integer[5];
//			int[] a = new int[5];
			for (int i = 4; i < n; i++) {
				five.add(Integer.parseInt(st.nextToken()));
				mid = five.get(2);
				a = five.toArray(new Integer[5]);
//				a =  five.stream().mapToInt(t -> t).toArray();
				Arrays.sort(a);
		
				if(mid == a[4]) {
					ans += a[4]-a[3];					
				}
				five.poll();
			}
						
			sb.append("#" + tc + " " + ans + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
