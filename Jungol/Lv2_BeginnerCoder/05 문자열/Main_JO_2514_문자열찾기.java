import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2514_문자열찾기 { // 제출일 2021-03-11 23:13

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//
		char[] str = br.readLine().toCharArray();
		int KOI = 0;
		int IOI = 0;
		for (int i = 1; i < str.length - 1; i++) {
			if (str[i] == 'O') {
				if (str[i + 1] == 'I') {
					if (str[i - 1] == 'K') {
						KOI++;
					} else if (str[i - 1] == 'I') {
						IOI++;
					}
				}
			}
		}
		sb.append(KOI).append('\n').append(IOI);

		bw.write(sb.toString());
		bw.flush();
	}

}