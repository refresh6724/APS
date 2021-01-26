import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_231_형성평가1 { // 제출일 2021-01-26 17:33

	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 자연수 N을 입력받아 1부터 N까지 출력을 하되 n-1번째 값은 n번째 값을 2로 나눈 몫이 되도록 하는 프로그램을 작성하시오.

		// 100
		// 1 3 6 12 25 50 100

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		int cnt = 0;
		int num = n;
		while (num != 0) {
			arr[cnt] = num;
			cnt++;
			num /= 2;
		}
		for (int i = cnt - 1; i >= 0; i--) {
			sb.append(arr[i]).append(' ');
		}
		bw.write(sb.toString().trim());
		bw.flush();
	}

}