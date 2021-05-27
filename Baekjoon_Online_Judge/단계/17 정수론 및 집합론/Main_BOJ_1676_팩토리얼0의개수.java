import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_BOJ_1676_팩토리얼0의개수 { // 제출일 2020-12-04 23:56

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// n!에서 뒤에서 0의 개수

		int n = Integer.parseInt(br.readLine());
		// 1에서 n까지 2와 5의 개수
		// 2는 무조건 5보다 많으므로
		// 5의 개수만 확인

		int five = 0;
		five += n / 5;
		five += n / 25;
		five += n / 125;

		bw.write(Integer.toString(five));
		bw.flush();
	}

}
