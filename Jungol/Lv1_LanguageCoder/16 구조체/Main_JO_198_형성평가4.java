import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_198_형성평가4 { // 제출일 2021-02-09 19:22

	static class Human {
		int height;
		double weight;

		public Human() {
			// TODO Auto-generated constructor stub
		}

		public Human(int height, double weight) {
			super();
			this.height = height;
			this.weight = weight;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("height : %dcm\nweight : %.1fkg", this.height, this.weight));
			return sb.toString();
		}
	}

	static Human child(Human o1, Human o2) {
		Human ret = new Human();
		ret.height = (o1.height + o2.height) / 2;
		ret.height += 5;
		ret.weight = (o1.weight + o2.weight) / 2;
		ret.weight -= 4.5;
		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 어떤 학생의 키는 아버지와 어머니의 키의 평균보다 5cm 크고
		// 몸무게는 아버지와 어머니의 몸무게의 평균보다 4.5kg 가볍다고 한다.
		// 키와 몸무게를 멤버변수로 갖는 구조체를 정의하고
		// 아버지와 어머니의 키와 몸무게를 입력받아
		// 학생의 키와 몸무게를 출력하는 프로그램을 작성하시오.
		// 키는 정수미만 버림하고 몸무게는 반올림하여 소수 첫째자리까지 나타낸다.

		st = new StringTokenizer(br.readLine());
		Human Father = new Human(Integer.parseInt(st.nextToken()), Double.parseDouble(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Human Mother = new Human(Integer.parseInt(st.nextToken()), Double.parseDouble(st.nextToken()));

		Human Child = child(Father, Mother);
		sb.append(Child);
		bw.write(sb.toString());
		bw.flush();
	}

}