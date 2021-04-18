import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_4642_Tutorial_STL_Sort_3 { // 제출일 2021-04-18 21:54

	static class Student implements Comparable<Student> {
		private char[] name;
		private int score;

		public Student() {
			this.name = new char[20];
			this.score = 0;
		}

		public Student(String a, int score) {
			this.name = a.toCharArray();
			this.score = score;
		}

		public int getScore() {
			return score;
		}

		public char[] getName() {
			return name;
		}

		@Override
		public int compareTo(final Student o) {
			if (o.getScore() == this.score) {
				return String.copyValueOf(this.name).compareTo(String.copyValueOf(o.getName()));
			}
			return o.getScore() - this.score;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.name).append(' ').append(this.score).append('\n');
			return sb.toString();
		}

	}

	static int n;
	static Student[] students;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		students = new Student[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()));
		}

	}

	private static void go() {
		Arrays.sort(students);
		print();
	}

	private static void print() {
		for (int i = 0; i < students.length; i++) {
			answer.append(students[i]);
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(answer.toString());
		bw.flush();
	}

}