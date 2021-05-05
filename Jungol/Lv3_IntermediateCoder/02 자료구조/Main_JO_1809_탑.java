import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_JO_1809_탑 { // 제출일 2021-05-05 23:17

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// JO 1328 빌딩 문제에서 좌우를 바꾼 문제
		// 좌측에서부터 max 값을 갱신하여 자신보다 큰 값이 없다면 0을 출력
		Stack<int[]> stk = new Stack<>(); // idx, height
		for (int i = 0; i < arr.length; i++) {
			while (!stk.isEmpty() && stk.peek()[1] < arr[i]) {
				stk.pop();
			}
			if (stk.isEmpty()) {
				sb.append("0 ");
			} else {
				sb.append(stk.peek()[0]).append(' ');
			}
			stk.add(new int[] { i + 1, arr[i] });
		}

		bw.write(sb.toString().trim());
		bw.flush();
	}

}