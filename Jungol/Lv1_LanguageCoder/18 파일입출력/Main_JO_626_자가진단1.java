import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_626_자가진단1 { // 제출일 2021-02-12 23:32

	public static void main(String[] args) throws IOException {

		// 두 개의 정수를 입력받아 작은 수부터 큰 수까지 모든 정수의 합을 구하여 출력하는 프로그램을 작성하시오.
		// * 표준입출력방식으로 작성하세요.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// https://coding-factory.tistory.com/282
//		String filename = "testcase.txt";
//		FileInputStream fis = new FileInputStream(filename);
//		FileOutputStream fos = new FileOutputStream(filename);
//		
//		byte[] readBuffer = new byte[fis.available()];
//		while(fis.read(readBuffer) != -1) {} // 끝까지 읽기
//		while(fis.read(readBuffer) != 13) {} // cr(carriage return) 파일 종류에 따라 crlf 일 수도 있다

//		StringTokenizer st = new StringTokenizer(new String(readBuffer));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int less = a;
		int more = a;
		if (a > b) {
			less = b;
		} else {
			more = b;
		}
		int sum = 0;
		for (int i = less; i <= more; i++) {
			sum += i;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(sum);

		bw.write(sb.toString());
		bw.flush();
	}

}