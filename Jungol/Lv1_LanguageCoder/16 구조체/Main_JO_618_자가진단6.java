import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_JO_618_자가진단6 { // 제출일 2021-02-09 18:54

	static class Human {
		String name;
		int height;
		double weight;

		public Human() {
			// TODO Auto-generated constructor stub
		}

		public Human(String name, int height, double weight) {
			super();
			this.name = name;
			this.height = height;
			this.weight = weight;
		}

		public String print() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("%s %d %.1f\n", this.name, this.height, this.weight));
			return sb.toString();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 5명의 이름과 키, 몸무게를 입력받아 이름순으로 정렬하여 출력하고,
		// 몸무게가 무거운 순으로 정렬하여 출력하는 프로그램을 작성하시오.
		// 몸무게는 소수점이하 1자리까지 출력한다.

		ArrayList<Human> li = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			li.add(new Human(st.nextToken(), Integer.parseInt(st.nextToken()), Double.parseDouble(st.nextToken())));
		}

		sb.append("name\n");
		Collections.sort(li, new Comparator<Human>() {
			@Override
			public int compare(Human o1, Human o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		for (Human human : li) {
			sb.append(human.print());
		}

		sb.append("\nweight\n");
		Collections.sort(li, new Comparator<Human>() {
			@Override
			public int compare(Human o1, Human o2) {
				if (o1.weight == o2.weight) {
					return 0;
				} else if (o1.weight > o2.weight) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		for (Human human : li) {
			sb.append(human.print());
		}

		bw.write(sb.toString());
		bw.flush();
	}

}