import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_614_자가진단2 { // 제출일 2021-02-08 23:09

	static class Card {
		String name;
		String school;
		String grade;

		public Card() {
			// TODO Auto-generated constructor stub
		}

		public Card(String name, String school, String grade) {
			super();
			this.name = name;
			this.school = school;
			this.grade = grade;
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
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// "학교명", "학년"을 저장할 수 있는 구조체로 2개의 변수를 선언한 후,
		// 한 개의 변수는 학교명에 "Jejuelementary", 학년에 "6"으로 각각 초기화하고
		// 다른 변수에는 새로운 학교와 학년을 입력받아 아래와 같이 출력하는 프로그램을 작성하시오.
		// 학교명은 20자 이하의 영문자이다.

		Card a = new Card();
		Card b = new Card();
		a.school = "Jejuelementary";
		a.grade = "6";
		st = new StringTokenizer(br.readLine());
		b.school = st.nextToken();
		b.grade = st.nextToken();

		sb.append(a.print2());
		sb.append(b.print2());

		bw.write(sb.toString());
		bw.flush();
	}

}