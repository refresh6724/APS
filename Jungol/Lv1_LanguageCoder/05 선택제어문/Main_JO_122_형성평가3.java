import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_122_형성평가3 { // 제출일 2021-01-05 23:21

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int year = Integer.parseInt(st.nextToken());

		// 400 으로 나누어떨어지면 윤년
		System.out.println((year % 400 == 0) ? "leap year" : (year % 4 != 0) ? "common year" : (year % 100 == 0) ? "common year" : "leap year");

	}

}