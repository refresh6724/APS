import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.io.IOException;

public class Main {	// 제출일 2019-07-26 08:28
	public static int as = 0;	
	public static StringBuilder sb = new StringBuilder();
	public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));	
	public static void main(String[] args) throws IOException {		
		int n = Integer.parseInt(br.readLine());
		hanoi(n, 1, 2, 3);			
		sb.insert(0, as + "\n");		
		System.out.println(sb);
	}
	public static void hanoi(int n, int a, int b, int c) {
		++as;
		if(n == 1) {
			sb.append(a+" "+c+"\n");
		} else {
			hanoi(n-1, a, c, b);
			sb.append(a+" "+c+"\n");
			hanoi(n-1, b, a, c);
		}
	}
}
