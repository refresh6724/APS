import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_191_형성평가3 { // 제출일 2021-02-05 22:55

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 단어를 입력받다가 "0"을 입력받으면 입력을 종료하고
		// 그 때까지 입력받은 단어의 개수를 출력하고
		// 홀수 번째 입력받은 단어를 한 줄에 1개씩 출력하는 프로그램을 작성하시오.
		// 단어의 개수는 50개를 넘지 않고, 단어의 길이는 100자 이하이다.

		String input = br.readLine();
		int cnt = 0;
		while (!input.equals("0")) {
			if (cnt % 2 == 0) {
				sb.append(input).append('\n');
			}
			cnt += 1;
			input = br.readLine();
		}
		sb.insert(0, String.format("%d\n", cnt));
		bw.write(sb.toString());
		bw.flush();
	}

}