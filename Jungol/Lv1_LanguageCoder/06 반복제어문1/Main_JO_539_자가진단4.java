import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_539_자가진단4 { // 제출일 2021-01-07 22:12

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = 0;
		int cnt = 0;
		int sum = 0;
		while (num < 100) {
			num = Integer.parseInt(st.nextToken());
			cnt += 1;
			sum += num;
		}
		System.out.println(sum);
		System.out.println(String.format("%.1f", (double) sum / cnt));
	}
}