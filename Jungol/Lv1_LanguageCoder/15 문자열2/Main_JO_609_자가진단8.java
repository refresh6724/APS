import java.io.*;
import java.util.*;

public class Main_JO_609_자가진단8 { // 제출일 2021-02-03 22:59

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 세 개의 단어를 입력받아 아스키코드(사전) 순으로
		// 가장 먼저 나오는 단어를 출력하는 프로그램을 작성하시오.
		// 각 단어의 길이는 1이상 10 이하이다.
		// cat dog cow
		// cat

		st = new StringTokenizer(br.readLine());
		ArrayList<String> li = new ArrayList<>();
		while (st.hasMoreTokens()) {
			li.add(st.nextToken());
		}
		Collections.sort(li);
		sb.append(li.get(0));
		bw.write(sb.toString());
		bw.flush();
	}

}