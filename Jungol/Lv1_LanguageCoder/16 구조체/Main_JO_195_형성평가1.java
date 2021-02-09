import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_JO_195_형성평가1 { // 제출일 2021-02-09 19:03

	static class Human {
		String name;
		String tel;
		String addr;

		public Human() {
			// TODO Auto-generated constructor stub
		}

		public Human(String name, String tel, String addr) {
			super();
			this.name = name;
			this.tel = tel;
			this.addr = addr;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("name : ").append(name).append("\ntel : ").append(tel).append("\naddr : ").append(addr).append("\n");
			return builder.toString();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 이름과 전화번호, 주소를 멤버로하는 구조체를 정의하여
		// 1개의 자료를 입력받고 출력하는 프로그램을 작성하시오.
		// 각각의 길이는 100자 이하다.

		st = new StringTokenizer(br.readLine());
		Human human = new Human(st.nextToken(), st.nextToken(), st.nextToken());
		sb.append(human);

		bw.write(sb.toString());
		bw.flush();
	}

}