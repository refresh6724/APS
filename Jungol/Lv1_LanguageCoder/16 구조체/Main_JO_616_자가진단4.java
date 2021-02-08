import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_616_자가진단4 { // 제출일 2021-02-08 23:21

	static class Triangle {
		int x1;
		int y1;

		int x2;
		int y2;

		int x3;
		int y3;

		public Triangle() {
			// TODO Auto-generated constructor stub
		}

		public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.x3 = x3;
			this.y3 = y3;
		}

		public String center() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("(%.1f, %.1f)", ((double) x1 + x2 + x3) / 3, ((double) y1 + y2 + y3) / 3));
			return sb.toString();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 삼각형의 세 꼭지점의 정수 좌표를 입력받아 삼각형의 무게중심의 실수 좌표를 구하여
		// 소수 첫째자리까지 출력하는 프로그램을 작성하시오.

		st = new StringTokenizer(br.readLine());
		Triangle a = new Triangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		sb.append(a.center());
		bw.write(sb.toString());
		bw.flush();
	}

}