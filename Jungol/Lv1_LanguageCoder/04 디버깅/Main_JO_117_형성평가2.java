import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_117_형성평가2 { // 제출일 2021-01-04 23:06

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 실수로 된 3과목의 점수를 입력받아 총점은 정수부분의 합계를 출력하고
		// 평균은 실수의 평균을 구한 뒤 정수부분만 출력하는 프로그램을 작성하시오.
		//

		StringTokenizer st = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());

		System.out.println(String.format("sum %d", (((int) a + (int) b + (int) c))));
		System.out.println(String.format("avg %d", (int) ((a + b + c) / 3)));

	}

}