import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_8741_두문자어 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder answer;
	static StringTokenizer st;	
	public static void main(String[] args) throws Exception {
	
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			answer = new StringBuilder();
			st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens()) {
				Character c = st.nextToken().charAt(0);
				answer.append((char)(c-32));				
			}
			
			bw.write(String.format("#%d %s\n", tc, answer.toString()));
			bw.flush();
		}
		
	}

}
