import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_5432_쇠막대기자르기 { // 제출일 2019-07-31 18:35

	public static int T;
	public static int Answer;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static void main(String[] args) throws IOException{		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t=1; t<=T; t++) {
			Answer = 0;			
			st = new StringTokenizer(br.readLine(), "");
			char[] buf = st.nextToken().toCharArray();
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < buf.length; i++) {
				stack.push(buf[i]);
			}		
			int line=0;
			while(!stack.isEmpty()) {
				char ch = stack.pop();	
				if(stack.isEmpty()) break;
				if(ch == ')' && stack.peek() == ')') {  // )) 
					line++;
					continue;
				} 
				if(ch == ')' && stack.peek() == '(') { // () 닫음이므로 지금까지의 라인을 더함
					Answer += line;	 // 잘랐으므로 라인에는 변동이 없다
					continue;
				}
				if(ch == '(' && stack.peek() == '(') {  // (( 연속 닫음 
					Answer += 1; // 쇠막대 하나가 잘렸다 
					line--; // 다른 막대는 무시하고 그 하나에 대해서만 계산
					continue;
				} 
				if(ch == '(' && stack.peek() == ')') { // )( 닫음 후 다시 엶이므로
					//line++;		//라인을 시작했다고 판단할 수 없고
					//Answer+=line; //반대로 쇠막대가 잘렸다고 판단할 수도 없다
					continue;
				} 
			}					
			System.out.println("#"+t+" "+Answer);		
		}
	}
}
