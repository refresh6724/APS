import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1224_계산기3 { // 제출일 2019-08-01 19:09
	
	static StringBuilder sb;
	static Stack<Object> stack;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		for(int t = 1; t<= 10; t++) {
			int n=sc.nextInt(); // 길이
			sc.nextLine(); // 개행 제거
			String str = sc.next(); // 한줄 받기
			sb = new StringBuilder(); // 정답 출력
			stack = new Stack<>();
			
			// 1. 변환
			for (int i = 0; i < n; i++) {
				char c = str.charAt(i); // 문자 받아오기
				if(c == '*' || c == '(') stack.push(c); // 해당 문자가 *이나 (이면 부담없이 넣는다
				else if (c == '+') { // +가 들어오면
					while(true) {
						if(stack.empty()) break; // 비어있으면 while문을 빠져나가 연산자를 push한다 
						char top = (char) stack.peek(); // 비어있지 않다면 
						if(top == '(') break; // 비거나 (가 나올때까지 pop한다
						sb.append((char)stack.pop());
						if(top == '+') break; // 이미 +가 들어있었으면 해당 +는 빼고 이번 +를 넣는다 
					} stack.push(c);
				} else if (c== ')') { // 닫기가 나오면 열기가 나올때까지 pop한다
					while(true) {
						if(stack.empty())break;
						char top = (char)stack.pop();
						if(top == '(') break; // 닫기와 열기는 넣지 않는다 
						sb.append(top);
					}
				} else { // 숫자는 바로 뺀다
					sb.append(c);
				}
			}
			// 나머지 연산자를 모두 뺀다
			while(!stack.empty()) {
				sb.append(stack.pop());
			}
			
			// 2. 계산
			str = sb.toString();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c == '*') {
					int b = (int)stack.pop();
					int a = (int)stack.pop();
					stack.push(a*b);
				}else if(c == '+') {
					int b = (int)stack.pop();
					int a = (int)stack.pop();
					stack.push(a+b);
				}else {
					stack.push(c-'0'); // char to int
				}
			}
			System.out.printf("#%d %d\n",t,(int)stack.pop());
			
		}// test case end
		
		
	}

	/*
	 * 토큰    isp    icp
	 * )        -      -
	 * *,/      2      2
	 * +,-      1      1
	 * (        0      3
	 * 
	 * icp(in-coming priority)
	 * isp(in-stack priority)
	 * if(icp > isp) push()
	 * else pop()
	 */
	static int isp(String s) {
		if(s.equals("*") && s.equals("/")) return 2;
		if(s.equals("+") && s.equals("-")) return 1;
		if(s.equals("(")) return 0;
		else return -1;
	}
	static int icp(String s) {
		if(s.equals("*") && s.equals("/")) return 2;
		if(s.equals("+") && s.equals("-")) return 1;
		if(s.equals("(")) return 3;
		else return -1;
	}
}
