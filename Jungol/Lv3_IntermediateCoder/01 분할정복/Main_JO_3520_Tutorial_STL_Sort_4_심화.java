import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_3520_Tutorial_STL_Sort_4_심화 { // 제출일 2021-04-18 22:29

	static class Student implements Comparable<Student> {
		private int id;
		private char[] name;
		private int score;

		public Student() {
			this.id = 0;
			this.name = new char[10];
			this.score = 0;
		}

		public Student(int id, String a, int score) {
			this.id = id;
			this.name = a.toCharArray();
			this.score = score;
		}

		public int getId() {
			return id;
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
				if (String.copyValueOf(this.name).equals(String.copyValueOf(o.getName()))) {
					return this.id - o.id;
				} // 3순위 id 오름차순
				return String.copyValueOf(this.name).compareTo(String.copyValueOf(o.getName()));
			} // 2순위 이름 오름차순
			return o.getScore() - this.score;
		} // 1 순위 선호도 내림차순

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.name).append(' ').append(this.score).append('\n');
			return sb.toString();
		}

	}

	static int n, q;
	static Student[] students;
	static int[] ql;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		go();
		output();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		students = new Student[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			students[i] = new Student(i + 1, st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		ql = new int[q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < ql.length; i++) {
			ql[i] = Integer.parseInt(st.nextToken());
		}

	}

	private static void go() {
		Arrays.sort(students);
		for (int i = 0; i < ql.length; i++) {
			answer.append(students[ql[i] - 1].getId()).append(' ');
		}
	}

	private static void output() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(answer.toString().trim());
		bw.flush();
	}

}