import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1141_불쾌한날BadHairDay { // 제출일 2021-04-05 21:57

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine()); // 1 이상 8만 이하
		// LIFO stack
		long sum = 0;
		// 놓친점 sigma n, n=1 to 80000 == 3,200,040,000 
		int[] stack = new int[n];
		int sidx = 0;
		stack[sidx++] = Integer.MAX_VALUE;
		int h = 0;
		for (int i = 0; i < n; i++) {
			h = Integer.parseInt(br.readLine());
			while (h >= stack[sidx - 1]) {
				stack[sidx--] = 0;
			}
			sum += sidx - 1;
			stack[sidx++] = h;
		}

		sb.append(sum);
		bw.write(sb.toString());
		bw.flush();
	}

}