import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_5356_의석이의세로로말해요 { // 제출일 2020-07-18 23:20 18,592 kb 112 ms

	static char[][] input = new char[5][15];
	static String line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			sb.append('#').append(tc).append(' ');

			// 15이하 문자열
			for (int i = 0; i < 5; i++) {
				Arrays.fill(input[i], '.');
				line = br.readLine();
				for (int j = 0; j < line.length(); j++) {
					input[i][j] = line.charAt(j);
				}
			}
			
			// 세로 읽기
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					if(input[j][i] != '.') {
						sb.append(input[j][i]);
					}
				}
			}

			sb.append('\n');

		}
		bw.write(sb.toString());
		bw.flush();
	}

}