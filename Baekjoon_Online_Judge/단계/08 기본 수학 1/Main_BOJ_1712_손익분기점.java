import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_1712_손익분기점 { // 제출일 2020-10-12 23:59
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken()); // 고정 비용
		int b = Integer.parseInt(st.nextToken()); // 가변 비용
		int c = Integer.parseInt(st.nextToken()); // 판매 비용
		
		if(c <= b) {
			System.out.println(-1);
		} else {
			System.out.println((a/(c-b))+1);
		}
	}	
}
