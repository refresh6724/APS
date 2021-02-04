import java.io.*;
import java.util.*;

public class Main_JO_610_자가진단9 { // 제출일 2021-02-04 23:13

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 5개의 문자열을 입력받아 문자열 크기(아스키코드)
		// 역순으로 정렬하여 출력하는 프로그램을 작성하시오.
		// 주어지는 문자열의 길이는 20자 미만이다.

		ArrayList<String> li = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			li.add(br.readLine());
		}
		Collections.sort(li, Collections.reverseOrder());
		for (int i = 0; i < 5; i++) {
			sb.append(li.get(i)).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}

}