package keeping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_8821_적고지우기 { // 제출일 2020-04-01 23:14
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			char[] input = br.readLine().toCharArray();			
			int[] num = new int[10];
			for (int i = 0; i < input.length; i++) {
				num[input[i]-'0']++;
			}			
			int ans = 0;
			for (int i = 0; i < num.length; i++) {
				if (num[i] % 2 != 0)
					ans++;
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

}
