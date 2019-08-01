import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_1223_계산기2 { // 제출일 2019-08-01 17:32

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static String str;
	static Stack<String> stack;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// step1 중위 표기식의 후위 표기식 변환방법
		// 1. 수식의 각 연산자에 대해 우선순위에 따라 괄호를 사용
		// 2. 각 연산자를 오른쪽 괄호 뒤로 이동
		// 3. 괄호 제거
		// =>		
		/*
		 * 1. 입력 받은 중위 표기식에서 토큰을 읽는다
		 * 2. 토큰이 피연산자이면 토큰을 출력한다
		 * 3. 토큰이 연산자(괄호 포함)일 때,
		 * 이 토큰이 스택의 top에 저장되어 있는
		 * 연산자보다 우선순위가 높으면 스택에 푸시하고 
		 * 그렇지 않다면 스택 top연산자의 우선순위가
		 * 토큰의 우선순위보다 작을때까지 스택에서 pop한 후 
		 * 토큰의 연산자를 push한다.
		 * 만약, top에 연산자가 없으면 push한다
		 * 4. 토큰이 오른쪽 괄호이면 스택 top에 왼쪽 괄호가 올때까지
		 * 스택에 pop연산을 수행하고 pop한 연산자를 출력한다
		 * 왼쪽 괄호를 만나면 pop만 하고 출력하지는 않는다
		 * 5. 중위 표기식에 더 읽을 것이 없다면 중지하고, 
		 * 더 읽을 것이 있다면 1부터 다시 반복한다
		 * 6. 스택에 남아있는 연산자를 모두 pop하여 출력한다.
		 * - 스택 밖의 왼쪽 괄호는 우선 순위가 가장 높으며
		 * 스택 안의 왼쪽 괄호는 우선 순위가 가장 낮다.
		 * 
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
		
		// step2 후위 표기법의 수식을 스택을 이용하여 계산
		/*
		 * 1. 피연산자를 만나면 스택에 push한다
		 * 2. 연산자를 만나면 필요한 만큼의 피연산자를 스택에서 pop하여 
		 * 연산하고, 연산 결과를 다시 스택에 push한다.
		 * 3. 수식이 끝나면 마지막으로 스택을 pop하여 출력한다.
		 */
		
		// String 으로 * + 기호 인식 불가
		
		for(int t = 1; t<= 10; t++) {
			int answer = 0;			
			int len = Integer.parseInt(br.readLine());
			stack = new Stack<String>();
			sb = new StringBuilder();
			//str = br.readLine();			
			String[] arr = br.readLine().split("");
			//step1 후위식으로 변경
			String token;
			for (int i = 0; i < len; i++) {
				token = arr[i];
				// 토큰이 곱하기면 푸시
				if(token.equals("*")) {
					stack.push(token);
				} else if (!token.equals("+")) { // 숫자면 바로 출력
					sb.append(token);
				} else { // 더하기면 지금까지 모든 스택을 출력하고 +를 푸시
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					stack.push(token);
				}				
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			//System.out.println(sb);
			
			//step2 후위식 계산
			int a;			
			int b;
			arr = sb.toString().split("");
			for (int i = 0; i < arr.length; i++) {
				token = arr[i];
				// 피연산자를 만나면 push
				if(!token.equals("*") && !token.equals("+")) {
					stack.push(token);
				} else {// 연산자를 만나면 필요한만큼 pop해 계산					
					a = Integer.parseInt(stack.pop().toString());					
					b = Integer.parseInt(stack.pop().toString());					
					if(token.equals("*")) {					
						stack.push(Integer.toString(a*b));
					} else {
						stack.push(Integer.toString(a+b));
					}
				}				
			}
			answer = Integer.parseInt(stack.pop().toString());
			System.out.printf("#%d %d\n",t, answer);
		}// test case end
		
		
	}

}
