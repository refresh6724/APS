import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2869
 */
public class Main_BOJ_2869_달팽이는올라가고싶다 { // 제출일 2020-11-01 23:22

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// a, b, v
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		// v 올라가야하고
		// 낮에 +a 밤에 -b
		// v 이상에 도착했을때 a 횟수가 정답이고 b 횟수보다 무조건 1 많다
		// ax - b(x-1) >= v
		// x >= (v-b)/(a-b)
		int vb = v - b;
		int ab = a - b;
		int x = vb / ab;
		if (vb % ab == 0) {
			System.out.println(x);
		} else {
			System.out.println(x + 1);
		}
	}
}
