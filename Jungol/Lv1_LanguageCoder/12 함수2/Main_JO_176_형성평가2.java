import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_176_형성평가2 { // 제출일 2021-01-23 22:00

	static double a, b;
	static int ans;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		// 두 개의 실수를 입력받아 각각의 제곱근을 구하고 두 제곱근 사이에 존재하는 정수의 개수를 출력하는 프로그램을 작성하시오.
		// 단, 입력받는 두 실수는 양수이며 두 제곱근 사이라는 말은 두 제곱근을 포함한다.
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
		double aa = Math.sqrt(a);
		double bb = Math.sqrt(b);
		int aaa = (int) aa;
		int bbb = (int) bb;
		if (aaa <= bbb) {
			ans = bbb - aaa + 1;
			if ((double) aaa * aaa != a) {
				ans -= 1;
			}
		} else {
			ans = aaa - bbb + 1;
			if ((double) bbb * bbb != b) {
				ans -= 1;
			}
		}
	}

	private static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		a = Double.parseDouble(st.nextToken());
		b = Double.parseDouble(st.nextToken());

	}

}