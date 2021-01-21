import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_171_형성평가2 { // 제출일 2021-01-21 22:12

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 1부터 전달받은 수까지의 합을 출력하는 함수를 작성하고
		// 1000 이하의 자연수를 입력받아 작성한 함수로 전달하여 출력하는 프로그램을 작성하시오.

		int n = Integer.parseInt(br.readLine());
		print_sigma(n);

	}

	private static void print_sigma(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);

	}

}