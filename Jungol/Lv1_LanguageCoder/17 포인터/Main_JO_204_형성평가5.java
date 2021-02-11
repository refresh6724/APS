import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_204_형성평가5 { // 제출일 2021-02-11 23:13

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 정수 n을 입력받아
		// n개의 정수형 동적배열을 생성하고
		// n개의 정수를 입력받아 최대값과 최소값을 출력하는 프로그램을 작성하시오.

		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		sb.append(String.format("max : %d\n", max));
		sb.append(String.format("min : %d\n", min));

		bw.write(sb.toString());
		bw.flush();
	}

}