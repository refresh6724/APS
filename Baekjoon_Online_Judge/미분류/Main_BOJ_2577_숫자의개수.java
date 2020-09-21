import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_2577_숫자의개수 { // 제출일 2020-09-21 22:30

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int sum = 1;
		for (int i = 0; i < 3; i++) {
			sum *= Integer.parseInt(br.readLine());
		}
		int[] num = new int[10];
		while(sum != 0) {
			num[sum%10]++;
			sum /= 10;
		}
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
//		bw.write(sb.toString());
//		bw.flush();
	}

}