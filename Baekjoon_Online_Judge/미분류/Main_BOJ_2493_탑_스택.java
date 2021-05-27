import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 2493 탑
public class Main { // 제출일 2019-08-12 17:15
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = null;
	static StringTokenizer st = null; 		

	public static void main(String[] args) throws Exception {
		
		int n = Integer.parseInt(br.readLine());
		sb = new StringBuilder(n<<1); // 공백이 있기 때문에 2배
		st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		for (int i = 1; i <= n; i++) {
			int k = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek()[1] > k) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) sb.append("0 ");
			stack.add(new int[] {i,k});
		}
		System.out.println(sb);
	}

}
