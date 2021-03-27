import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1221_후위표기법1 { // 제출일 2021-03-27 23:08

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//

		int[] stack = new int[10];
		int sidx = 0;

		int n = Integer.parseInt(br.readLine());
		String[] m = br.readLine().split(" ");
		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			switch (m[i].charAt(0)) {
			case '+':
				b = stack[--sidx];
				a = stack[--sidx];
				stack[sidx++] = a + b;
				break;
			case '-':
				b = stack[--sidx];
				a = stack[--sidx];
				stack[sidx++] = a - b;
				break;
			case '*':
				b = stack[--sidx];
				a = stack[--sidx];
				stack[sidx++] = a * b;
				break;
			case '/':
				b = stack[--sidx];
				a = stack[--sidx];
				stack[sidx++] = a / b;
				break;
			default:
				stack[sidx++] = Integer.parseInt(m[i]);
				break;
			}
		}

		sb.append(stack[0]);
		bw.write(sb.toString());
		bw.flush();
	}

}