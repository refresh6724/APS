import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_201_형성평가2 { // 제출일 2021-02-11 23:06

	static int a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 정수형 변수를 선언하고 포인터 변수를 사용하여
		// 100 이하의 수를 입력받은 후 입력받은 수만큼 ‘*’을 출력하는 프로그램을 작성하시오.

		a = Integer.parseInt(br.readLine());
		for (int i = 0; i < a; i++) {
			sb.append('*');
		}

		bw.write(sb.toString());
		bw.flush();
	}

}