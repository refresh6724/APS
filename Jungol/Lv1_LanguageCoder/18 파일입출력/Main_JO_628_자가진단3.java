import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_JO_628_자가진단3 { // 제출일 2021-02-12 23:47

	static class Student {
		String name;
		int score;
		int rank;

		public Student() {
			// TODO Auto-generated constructor stub
		}

		public Student(String name, int score) {
			super();
			this.name = name;
			this.score = score;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("%4s %5d %4d\n", this.name, this.score, this.rank));
			return sb.toString();
		}
	}

	public static void main(String[] args) throws IOException {

		// 10명의 학생 이름과 점수를 입력받아
		// 이름과 점수, 등수를 입력받은 순서대로 출력하는 프로그램을 작성하시오.
		// 단, 출력시 "이름", "점수", "등수"는 한 칸의 공백으로 구분을 하며,
		// Name은 4칸(%4s), Score는 5칸(%5d), Rank는 각 4칸(%4d)으로 출력한다.
		// * 표준입출력방식으로 작성하세요.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 공동 순위 있음
		ArrayList<Student> students = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			students.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
		// 랭킹
		for (int i = 0; i < 10; i++) {
			int cnt = 0;
			for (int j = 0; j < 10; j++) {
				if (students.get(i).score < students.get(j).score) {
					cnt++;
				}
			}
			students.get(i).rank = cnt + 1;
		}
		//
		StringBuilder sb = new StringBuilder();
		sb.append("Name Score Rank\n");
		for (Student s : students) {
			sb.append(s);
		}

		bw.write(sb.toString());
		bw.flush();
	}

}