import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_525_자가진단8 { // 제출일 2021-01-02 23:24

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// 첫번째 수가 가장 크면 1 아니면 0
		// 세 개의 수가 모두 같으면 1 아니면 0

		System.out.println(String.format("%d %d", (a > b && a > c) ? 1 : 0, (a == b && b == c) ? 1 : 0));

	}

}