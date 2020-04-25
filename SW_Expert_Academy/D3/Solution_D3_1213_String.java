import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1213_String { // 제출일 2020-04-25 22:59
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

//		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= 10; tc++) {

			int t = Integer.parseInt(br.readLine());
			
			String search = br.readLine();
			int l1 = search.length();
			String text = br.readLine();
			int l2 = text.length();
			
			int ans = 0;
			// l2-l1 위치까지 검색
			// 예를 들어 2글자 5글자일 경우 0위치, 1위치, 2위치, 3위치까지 보고 4위치는 ㄴㄴ
			for (int i = 0; i <= l2-l1; i++) {
				if(text.substring(i).startsWith(search)) {
					ans++;
				}
			}
			
			// 

			sb.append("#").append(tc).append(" ").append(ans).append(" ").append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

}
