import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_JO_199_형성평가5 { // 제출일 2021-02-09 19:26

	static class Human {
		String name;
		int a;
		int b;
		int c;
		int sum;

		public Human() {
			// TODO Auto-generated constructor stub
		}

		public Human(String name, int a, int b, int c) {
			super();
			this.name = name;
			this.a = a;
			this.b = b;
			this.c = c;
			this.sum = a + b + c;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("%s %d %d %d %d\n", this.name, this.a, this.b, this.c, this.sum));
			return sb.toString();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 10 이하의 정수 n을 입력받은 후
		// n명의 이름(영문자 20자 이하)과 세 과목의 점수를 입력받아
		// 총점이 높은 순으로 정렬하여 출력하는 프로그램을 작성하시오.

		int n = Integer.parseInt(br.readLine());
		ArrayList<Human> li = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			li.add(new Human(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(li, new Comparator<Human>() {
			@Override
			public int compare(Human o1, Human o2) {
				return o2.sum - o1.sum;
			}
		});
		for (Human h : li) {
			sb.append(h);
		}

		bw.write(sb.toString());
		bw.flush();
	}

}