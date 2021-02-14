import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_206_형성평가2 { // 제출일 2021-02-14 20:43

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 3개의 정수를 입력 받아
		// 합계와 평균을 구하여 출력하되
		// 평균은 정수부분만 출력하고 나머지를 예와 같이 출력하시오.

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		sb.append(String.format("%d %d...%d", (a + b + c), (a + b + c) / 3, (a + b + c) % 3));

		bw.write(sb.toString());
		bw.flush();
	}

}