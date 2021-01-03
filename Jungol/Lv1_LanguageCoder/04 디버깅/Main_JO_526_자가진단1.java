import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_526_자가진단1 { // 제출일 2021-01-03 23:03

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());

		// 두 수의 곱을 정수로 변환한 결과
		// 두 수를 정수로 변환하여 곱을 구한 결과
		// 각 프로그램 내용에 과한 설명을 주석으로 표시

		System.out.println(String.format("%d %d", (int) (a * b), (int) a * (int) b));

	}

}