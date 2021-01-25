import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_584_자가진단6 { // 제출일 2021-01-25 23:54

	static final int ONE = 1;
	static final int TWO = 2;
	static final int THREE = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// main() 함수 내에는 숫자를 사용하지 말고
		// 즉, #define 을 이용하여 1, 2, 3 세 개의 숫자를 조합하여
		// 가능한 한 모든 합을 출력하는 프로그램을 작성하시오.
		// 출력예와 같이 출력하시오.
		// 1 + 1 = 2
		// 1 + 2 = 3
		// 1 + 3 = 4
		// 2 + 1 = 3
		// 2 + 2 = 4
		// 2 + 3 = 5
		// 3 + 1 = 4
		// 3 + 2 = 5
		// 3 + 3 = 6

		sb.append(String.format("%d + %d = %d\n", ONE, ONE, ONE + ONE));
		sb.append(String.format("%d + %d = %d\n", ONE, TWO, ONE + TWO));
		sb.append(String.format("%d + %d = %d\n", ONE, THREE, ONE + THREE));
		sb.append(String.format("%d + %d = %d\n", TWO, ONE, TWO + ONE));
		sb.append(String.format("%d + %d = %d\n", TWO, TWO, TWO + TWO));
		sb.append(String.format("%d + %d = %d\n", TWO, THREE, TWO + THREE));
		sb.append(String.format("%d + %d = %d\n", THREE, ONE, THREE + ONE));
		sb.append(String.format("%d + %d = %d\n", THREE, TWO, THREE + TWO));
		sb.append(String.format("%d + %d = %d\n", THREE, THREE, THREE + THREE));

		bw.write(sb.toString().trim());
		bw.flush();
	}

	private static double radius(double area) {
		return Math.sqrt(area / 3.14);
	}
}