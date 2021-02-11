import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_202_형성평가3 { // 제출일 2021-02-11 23:08

	static int a, b, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 세 개의 포인터 변수를 선언하고 메모리 공간을 확보하여
		// 두 수를 입력받아 두 수의 차의 절대값을 저장한 후 출력하는 프로그램을 작성하시오.

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Math.abs(a - b);
		sb.append(c);

		bw.write(sb.toString());
		bw.flush();
	}

}