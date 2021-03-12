import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1880_암호풀기MessageDecoding { // 제출일 2021-03-12 23:24

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		char[] key= br.readLine().toCharArray();
		char[] code = br.readLine().toCharArray();
		for (int i = 0; i < code.length; i++) {
			if(Character.isLowerCase(code[i])) {
				code[i] = key[code[i] - 'a'];
			} else if (Character.isUpperCase(code[i])) {
				code[i] = (char) (key[code[i] - 'A'] - 'a' + 'A');
			}
		}		
		sb.append(String.copyValueOf(code));
		bw.write(sb.toString());
		bw.flush();
	}

}