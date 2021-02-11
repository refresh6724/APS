import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_200_형성평가1 { // 제출일 2021-02-11 23:05

	static int c;
	static double d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 문자와 실수를 각각 선언 하고 그 주소를 출력하는 프로그램을 작성하시오.
		// 초기화 하지 않은 local 변수에 대해 주소를 찾을 수 없다
		int a;
		double b;

//		sb.append(Integer.toHexString(System.identityHashCode(a)));
//		sb.append(Integer.toHexString(System.identityHashCode(b)));
		sb.append(Integer.toHexString(System.identityHashCode(c)));
		sb.append(' ');
		sb.append(Integer.toHexString(System.identityHashCode(d)));

		bw.write(sb.toString());
		bw.flush();
	}

}