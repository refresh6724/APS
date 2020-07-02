import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_3750_DigitSum { // 제출일 2020-07-02 23:32 23,264 kb 200 ms

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			// 18자리
			// 수가 아무리 커도 9*17 = 153이다 
			int next = br.read();
			int sum = 0;
			while(next != 10 && next != -1) { // 윈도우에서 != 13
				sum += next - 48;
				next = br.read();
			}
			// br.read(); // 윈도우에서 10을 스킵하는 용도
			int ret = 0;
			while(sum >= 10) {
				ret = 0;
				while(sum != 0) {
					ret += sum%10;
					sum /= 10;
				}
				sum = ret;
			}		
			
			sb.append('#').append(tc).append(' ').append(sum).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

}