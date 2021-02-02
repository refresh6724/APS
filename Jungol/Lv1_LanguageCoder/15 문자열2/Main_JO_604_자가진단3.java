import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_604_자가진단3 { // 제출일 2021-02-02 23:05

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 20개 이하의 문자로 이루어진 10개의 단어와
		// 한 개의 문자를 입력받아서 마지막으로 입력받은 문자로 끝나는 단어를 모두 출력하는 프로그램을 작성하시오.

		String[] arr = new String[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}
		String end = br.readLine();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].endsWith(end)) {
				sb.append(arr[i]).append('\n');
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}