import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1912_연속합 {// 제출일 2020-01-27 22:44
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine(), " ");
		int answer = 0x80000000 +1;
		int prevmax = 0;
		int now = 0;
		for (int i = 0; i < n; i++) {
			now = Integer.parseInt(st.nextToken());
			prevmax = (now > (prevmax + now)) ? now : prevmax + now;
			if (answer < prevmax)
				answer = prevmax;
		}

		System.out.println(answer);
	}

}