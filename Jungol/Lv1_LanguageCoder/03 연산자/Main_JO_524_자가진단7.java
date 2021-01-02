import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_524_자가진단7 { // 제출일 2021-01-02 23:22

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		// 논리곱과 논리합의 결과를 출력
		// 0 이 아니면 true 0 이면 false
		// 예) 2 0 => false true

		System.out.println(String.format("%s %s", ((a & b) == 0) ? "false" : "true", ((a | b) == 0) ? "false" : "true"));

	}

}