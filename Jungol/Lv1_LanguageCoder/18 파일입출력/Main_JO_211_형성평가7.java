import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_211_형성평가7 { // 제출일 2021-02-16 23:08

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 시작 년도와 끝 년도를 입력받아서 윤년이 몇 번 있는지를 구하여 출력하시오.

		// 윤년은 4의 배수, 100의 배수는 아님, 400의 배수는 윤년

		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		if (start % 4 != 0) {
			start -= start % 4;
			start += 4;
		}
		for (int i = start; i <= end; i += 4) {
			if (i % 400 == 0 || i % 100 != 0) {
				cnt++;
			}
		}
		sb.append(cnt);

		bw.write(sb.toString());
		bw.flush();
	}

}