import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_2562_최댓값 { // 제출일 2020-09-20 23:14

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] num = new int[9];
		for (int i = 0; i < 9; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		int max = 0;
		int ret = 0;
		for (int i = 0; i < 9; i++) {
			if(max < num[i]) {
				max = num[i];
				ret = i;
			}
		}
		System.out.println(max);
		System.out.println(ret+1);
//		bw.write(sb.toString());
//		bw.flush();
	}

}