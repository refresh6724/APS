import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_527_자가진단2 { // 제출일 2021-01-03 23:12

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 두 개의 정수를 입력 받아서
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		// 첫번째 수를 두번째 수로 나눈 몫을 출력
		// 첫번째 수를 실수로 변환 후 두번째 수로 나눈 값을 반올림 하여 소수 둘째 자리까지 출력
		System.out.println(String.format("%d %.2f", a / b, ((double) a / b)));

	}

}