import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_209_형성평가5 { // 제출일 2021-02-14 21:53

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 0 이 입력될 때까지 정수를 입력받아
		// 3의 배수이면서 5의 배수인 정수를 모두 출력하고 다음 줄에 그 개수를 출력하시오.
		// 단, 한개도 없을 경우에는 "0" 만 출력한다. 최대 1,000개의 정수가 입력된다.

		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		while (n != 0) {
			if (n % 3 == 0 && n % 5 == 0) {
				cnt++;
				sb.append(' ').append(n);
			}
			n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				sb.append('\n');
			}
		}
		sb.append(cnt);

		bw.write(sb.toString().trim());
		bw.flush();
	}

}