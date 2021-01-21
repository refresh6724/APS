import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_170_형성평가1 { // 제출일 2021-01-21 22:09

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// ‘@’문자를 10개 출력하는 함수를 작성 한 후 함수를 세 번 호출하여 아래와 같이 출력하는 프로그램을 작성하시오.

//		for (int i = 0; i < 3; i++) {
//			print_ten_at();
//		}
		System.out.println("first");
		print_ten_at();
		System.out.println("second");
		print_ten_at();
		System.out.println("third");
		print_ten_at();
	}

	private static void print_ten_at() {
		System.out.println("@@@@@@@@@@");
	}

}