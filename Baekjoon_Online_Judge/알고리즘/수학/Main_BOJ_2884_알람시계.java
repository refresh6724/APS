import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2884_알람시계 { // 제출일 2020-09-08 21:12

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int time = H * 60 + M;
		time -= 45;
		if (time < 0) {
			time += 24 * 60;
		}
		H = time / 60;
		M = time % 60;
		System.out.println(String.format("%d %d", H, M));
	}
}