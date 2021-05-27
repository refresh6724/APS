import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * https://www.acmicpc.net/problem/4673
 */
public class Main_BOJ_4673_셀프넘버 { // 제출일 2020-10-11 23:44

	static int[] c;

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		c = new int[10001];
		for (int i = 1; i < 10000; i++) {
			d(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 10001; i++) {
			if (c[i] == 0) {
				sb.append(i).append('\n');
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static void d(int i) {
		if(i > 10000) {
			return;
		}
		int sum = i;
		while(i != 0) {
			sum += i%10;
			i/=10;
		}
		if(sum < 10001) {
			c[sum]++;
		}
		d(sum);
	}
}
