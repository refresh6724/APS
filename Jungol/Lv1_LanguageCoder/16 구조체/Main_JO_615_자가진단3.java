import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_615_자가진단3 { // 제출일 2021-02-08 23:15

	static class Card {
		String name;
		String school;
		String grade;
		int kor;
		int eng;

		public Card() {
			// TODO Auto-generated constructor stub
		}

		public Card(String name, String school, String grade) {
			super();
			this.name = name;
			this.school = school;
			this.grade = grade;
		}

		public Card(String name, int kor, int eng) {
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
		}

		public String print() {
			StringBuilder sb = new StringBuilder();
			sb.append("Name : ").append(this.name).append('\n');
			sb.append("School : ").append(this.school).append('\n');
			sb.append("Grade : ").append(this.grade).append('\n');
			return sb.toString();
		}

		public String print2() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.grade).append(" grade in ").append(this.school).append(" School\n");
			return sb.toString();
		}

		public String print3() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("%s %d %d\n", this.name, this.kor, this.eng));
			return sb.toString();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 두 명의 이름과 국어, 영어 점수를 입력받아
		// 과목별 점수의 평균을 구하여 출력하는 프로그램을 작성해 보시오.
		// (이름은 20자 이하이고 평균의 소수점 이하는 버림한다.)

		Card[] students = new Card[2];
		st = new StringTokenizer(br.readLine());
		students[0] = new Card(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		students[1] = new Card(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		int avg_kor = 0;
		int avg_eng = 0;
		for (int i = 0; i < students.length; i++) {
			avg_kor += students[i].kor;
			avg_eng += students[i].eng;
			sb.append(students[i].print3());
		}
		sb.append(String.format("avg %d %d\n", avg_kor / 2, avg_eng / 2));
		bw.write(sb.toString());
		bw.flush();
	}

}