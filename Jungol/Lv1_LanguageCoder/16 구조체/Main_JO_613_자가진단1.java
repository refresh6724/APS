import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_613_자가진단1 { // 제출일 2021-02-08 23:05

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
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// "이름", "학교명", "학년"을 입력받아 아래와 같이 출력하는 프로그램을 작성하시오.
		// (이름과 학교명은 각각 20자 이하이다.)

		st = new StringTokenizer(br.readLine());
		Card card = new Card(st.nextToken(), st.nextToken(), st.nextToken());

		bw.write(card.print());
		bw.flush();
	}

}