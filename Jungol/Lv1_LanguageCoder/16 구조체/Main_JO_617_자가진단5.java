import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_JO_617_자가진단5 { // 제출일 2021-02-08 23:27

	static class Human implements Comparable<Human> {
		String name;
		int height;

		public Human() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public int compareTo(Human o) {
			return this.height - o.height;
		}

		public Human(String name, int height) {
			super();
			this.name = name;
			this.height = height;
		}

		public String print() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.name).append(' ').append(this.height).append('\n');
			return sb.toString();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 5명의 이름과 키를 입력받아
		// 키가 가장 작은 사람의 이름과 키를 출력하는 프로그램을 작성하시오.
		// 이름은 20자 이하이다.

		ArrayList<Human> li = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			li.add(new Human(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(li);
		sb.append(li.get(0).print());
		bw.write(sb.toString());
		bw.flush();
	}

}