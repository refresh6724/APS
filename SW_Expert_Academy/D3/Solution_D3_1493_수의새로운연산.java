import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_1493_수의새로운연산 { // 제출일 2020-06-18 21:03 21,328 kb 102 ms

	static int[] sigma;

	static int x, y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		sigma = new int[40001];
		// p와 q가 각각 10000,10000 이라 가정했을때 최대 크기는 x+y=40000 라인까지이다.
		sigma[0] = 1;
		for (int i = 1; i <= 40000; i++) {
			sigma[i] = sigma[i - 1] + i;
		}

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(' ');

			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			// p ★ q = #(&(p)+&(q))
			// #(x,y) === n = x+y-1; n(n-1)/2 + x = (x+y-1)(x+y-2)/2 + x = z
			// &(z) = sigma[i] 보다 클 때 i 값이
			x = 0;
			y = 0;
			sb.append(star(p, q)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	private static int star(int p, int q) {
		ampersand(p);
		ampersand(q);
		return sharp(x, y);
	}

	private static int sharp(int x, int y) {
		return ((x + y - 1) * (x + y - 2)) / 2 + x;
	}

	private static void ampersand(int z) {
		int i = 0;
		for (; i < sigma.length; i++) {
			if (z < sigma[i]) {
				break;
			}
		}

		// x+y = i+1 라인의 숫자
		// z - (i+1)*i/2 = x

		int tmp = z - ((i - 1) * i) / 2;

		x += tmp;
		y += i + 1 - tmp;

	}

}