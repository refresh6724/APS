import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_619_자가진단1 { // 제출일 2021-02-10 23:26

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 정수형 변수와 포인터 변수를 선언하고 정수를 입력받아
		// 포인터 변수를 이용하여 정수형 변수의 메모리 주소와 값을 출력하는 프로그램을 작성하시오.
		// 주소 출력은 "%#p"를 이용하시오. 아래는 메모리 주소가 "0X11110000"이라고 가정했을 때이다.

		// 정수형 변수
		int a = Integer.parseInt(br.readLine());
		// 자바에는 포인터 변수가 없으며 16진수 주소값이 10진수로 나온다
		int p = System.identityHashCode(a);
		// 다시 16진수로 바꾸어 표시하기 위해 Integer.toHexString을 사용한다
		sb.append(Integer.toHexString(p)).append(' ').append(a);

		bw.write(sb.toString());
		bw.flush();
	}

}