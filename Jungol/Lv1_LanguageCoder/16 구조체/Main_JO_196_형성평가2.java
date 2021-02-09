import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_JO_196_형성평가2 { // 제출일 2021-02-09 19:09

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

		// 이름과 전화번호, 주소를 멤버로하는 구조체를 정의하고
		// 3명의 자료를 입력받은 후
		// 사전순으로 이름이 가장 빠른 사람의 자료를 출력하는 프로그램을 작성하시오.
		// 이름, 전화번호, 주소는 모두 15자 이하이다.
		// ** 자기주도 C언어 7판 이전 교재는 출력예가 오류입니다.

		ArrayList<Human> li = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			li.add(new Human(st.nextToken(), st.nextToken(), st.nextToken()));
		}
		Collections.sort(li, new Comparator<Human>() {
			@Override
			public int compare(Human o1, Human o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		sb.append(li.get(0));

		bw.write(sb.toString());
		bw.flush();
	}

}