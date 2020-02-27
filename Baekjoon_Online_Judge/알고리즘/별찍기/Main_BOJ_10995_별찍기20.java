import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10995_별찍기20 { // 제출일 2020-02-27 21:27
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine().trim());
		// n번 n줄 출력 단, 짝수번째에는 공백을 한칸 넣는다
					
		StringBuilder sb = new StringBuilder();
		
		sb.append('*');
		for (int i = 1; i < n; i++) {
			sb.append(' ').append('*');
		} 
		sb.append("\n");
		String a = sb.toString();

		for (int i = 1; i < n; i++, sb.append(a)) {
			if(i%2!=0) sb.append(' ');		
		}
		System.out.println(sb.toString());
	}
}