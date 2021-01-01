import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_111_형성평가1 { // 제출일 2021-01-01 23:27

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += Integer.parseInt(st.nextToken());
		}
		System.out.println(String.format("sum %d\navg %d", sum, sum / 4));
	}
}