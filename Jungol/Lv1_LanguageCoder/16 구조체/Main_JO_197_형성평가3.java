import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_197_형성평가3 { // 제출일 2021-02-09 19:15

	static class Rectangle {
		int left_x;
		int left_y;
		int right_x;
		int right_y;

		public Rectangle() {
			// TODO Auto-generated constructor stub
		}

		public Rectangle(int left_x, int left_y, int right_x, int right_y) {
			super();
			this.left_x = left_x;
			this.left_y = left_y;
			this.right_x = right_x;
			this.right_y = right_y;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("%d %d %d %d\n", left_x, left_y, right_x, right_y));
			return sb.toString();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 직사각형의 왼쪽 아래의 좌표(x, y)와 오른쪽 위의 좌표(x2, y2)를 저장할 수 있는 구조체 자료형을 만들고
		// 두 개의 직사각형 자료를 입력받아
		// 두 직사각형을 포함하는 최소의 직사각형 자료를 구하여
		// 구조체 변수에 저장하고 출력하는 프로그램을 작성하시오.
		// 단, 모든 입력값은 100을 넘지 않는다.

		st = new StringTokenizer(br.readLine());
		Rectangle A = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Rectangle B = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		Rectangle C = new Rectangle(Math.min(A.left_x, B.left_x), Math.min(A.left_y, B.left_y), Math.max(A.right_x, B.right_x), Math.max(A.right_y, B.right_y));
		sb.append(C);
		
		bw.write(sb.toString());
		bw.flush();
	}

}