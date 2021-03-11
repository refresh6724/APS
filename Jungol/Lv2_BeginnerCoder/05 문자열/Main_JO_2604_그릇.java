import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_2604_그릇 { // 제출일 2021-03-11 23:10

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		//
		char[] dishes = br.readLine().toCharArray();
		int sum = 10;
		for (int i = 1; i < dishes.length; i++) {
			if (dishes[i - 1] == dishes[i]) {
				sum += 5;
			} else {
				sum += 10;
			}
		}
		sb.append(sum);
		bw.write(sb.toString());
		bw.flush();
	}

}