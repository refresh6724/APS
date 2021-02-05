import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_189_형성평가1 { // 제출일 2021-02-05 21:40

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 공백을 포함한 문자열을 입력받아
		// 각 단어로 분리하여 문자열 배열에 저장한 후 입력순서의 반대 순서로 출력하는 프로그램을 작성하시오.
		// 문자열의 길이는 100자 이하이다.

		String[] arr = br.readLine().split(" ");
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

}