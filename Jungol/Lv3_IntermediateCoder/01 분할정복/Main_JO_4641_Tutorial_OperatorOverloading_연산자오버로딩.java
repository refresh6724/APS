import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* 자바는 연산자 오버로딩을 지원하지 않는다 */
public class Main_JO_4641_Tutorial_OperatorOverloading_연산자오버로딩 { // 제출일 2021-04-19 23:09

	static class Rectangle {
		private int width;
		private int height;
		private int size;

		public Rectangle() {
			this.width = 0;
			this.height = 0;
			this.size = 0;
		}

		public Rectangle(int width, int height) {
			this.width = width;
			this.height = height;
			this.size = width * height;
		}

		public boolean isSmallThan(Rectangle other) {
			if (this.size < other.size) {
				return true;
			}
			return false;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		Rectangle a = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Rectangle b = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		if (a.isSmallThan(b)) {
			sb.append("a is smaller\n");
		} else {
			sb.append("b is smaller\n");
		}

		bw.write(sb.toString());
		bw.flush();

	}
}