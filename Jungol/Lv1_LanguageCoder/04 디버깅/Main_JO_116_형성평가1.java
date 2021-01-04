import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_116_형성평가1 { // 제출일 2021-01-04 23:03

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정수로 된 3과목의 점수를 입력받아 평균을 구한 후 반올림하여 소수 첫째자리까지 출력하는 프로그램을 작성하시오

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(String.format("%.1f", ((float) (a + b + c) / 3)));

	}

}