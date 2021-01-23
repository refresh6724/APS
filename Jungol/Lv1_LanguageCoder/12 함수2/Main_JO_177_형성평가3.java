import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_177_형성평가3 { // 제출일 2021-01-23 22:02

	static int[] arr;
	static int ans;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		// 5개의 정수를 입력받아 각 정수의 절대값의 합을 출력하는 프로그램을 작성하시오.

		input();
		calc();
		print();
	}

	private static void print() throws Exception {
		sb.append(ans);
		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static void calc() {
		ans = 0;
		for (int i = 0; i < 5; i++) {
			if (arr[i] < 0) {
				ans -= arr[i];
			} else {
				ans += arr[i];
			}
		}
	}

	private static void input() throws Exception {
		arr = new int[5];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

}