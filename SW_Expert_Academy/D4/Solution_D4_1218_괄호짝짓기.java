import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_1218_괄호짝짓기 { // 제출일 2019-07-31 18:59

	public static int T;
	public static int Answer;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static void main(String[] args) throws IOException{				
		for(int t=1; t<=10; t++) {
			st = new StringTokenizer(br.readLine());	
			T = Integer.parseInt(st.nextToken()); // 길이
			Answer = 0;	// 1유효 0무효
			st = new StringTokenizer(br.readLine(), "");
			char[] buf = st.nextToken().toCharArray();
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < buf.length; i++) {
				stack.push(buf[i]);
			}		
			
			int close1=0;
			int close2=0;
			int close3=0;
			int close4=0;
			
			while(!stack.isEmpty()) {
				char ch = stack.pop();	
				// '()', '[]', '{}', '<>'
				// 여는 문자가 닫는 문자보다 많으면 무효 break;
				if(ch == '>') {
					close4++;
					continue;
				}
				if(ch == '}') {
					close3++;
					continue;
				}
				if(ch == ']') {
					close2++;
					continue;
				}
				if(ch == ')') {
					close1++;
					continue;
				}
				if(ch == '<') {
					close4--;
					if (close4<0) break;
					continue;
				}
				if(ch == '{') {
					close3--;
					if (close3<0) break;
					continue;
				}
				if(ch == '[') {
					close2--;
					if (close2<0) break;
					continue;
				}
				if(ch == '(') {
					close1--;
					if (close1<0) break;
					continue;
				}				
			}
			if(stack.isEmpty() && close1 == 0 && close2 == 0 && close3 == 0 && close4 == 0) Answer = 1;
			System.out.println("#"+t+" "+Answer);		
		}
	}
}
