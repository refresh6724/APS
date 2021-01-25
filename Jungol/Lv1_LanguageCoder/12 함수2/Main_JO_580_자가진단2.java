import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_580_자가진단2 { // 제출일 2021-01-25 23:14

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 2016년의 날짜를 두 개의 정수 월 일로 입력받아서
		// 입력된 날짜가 존재하면 "OK!"
		// 그렇지 않으면 "BAD!"라고 출력하는 프로그램을 작성하시오.

		st = new StringTokenizer(br.readLine());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());

		sb.append((isExist(month, day)) ? "OK!" : "BAD!");
		bw.write(sb.toString());
		bw.flush();
	}

	private static boolean isExist(int month, int day) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day >= 1 && day <= 31) {
				return true;
			}
		} else if (month == 2) { // 2016년은 윤년
			if (day >= 1 && day <= 29) {
				return true;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day >= 1 && day <= 30) {
				return true;
			}
		}
		return false;
	}
}