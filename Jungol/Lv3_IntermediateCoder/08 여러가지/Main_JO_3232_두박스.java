import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_3232_두박스 { // 제출일 2021-05-08 23:15

	static class Vertex {
		int x;
		int y;

		public Vertex() {
			// TODO Auto-generated constructor stub
		}

		public Vertex(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (this.x == ((Vertex) obj).x && this.y == ((Vertex) obj).y) {
				return true;
			}
			return false;
		}

	}

	static class Rectangle {
		int x1;
		int y1;
		int x2;
		int y2;

		public Rectangle() {
			// TODO Auto-generated constructor stub
		}

		public Rectangle(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		public String compareTo(Rectangle o) {

			// null은 범위가 완전히 다른 경우
			if (this.y2 < o.y1 || o.y2 < this.y1 || this.x2 < o.x1 || o.x2 < this.x1) {
				return "NULL";
			}

			// point는 4 꼭지점 중 하나가 일치하는 경우만 해당된다
			if (this.getV1().equals(o.getV4()) || this.getV2().equals(o.getV3()) || this.getV3().equals(o.getV2()) || this.getV4().equals(o.getV1())) {
				return "POINT";
			}

			// line은 면이 서로 닿는 축의 라인이 3개면서 해당 축의 점 하나가 맞닿는 라인의 내부에 있을 때
			if (this.x2 == o.x1) { // 세로축이 붙는 경우
				if (pointandrange(this.y1, o.y1, o.y2) || pointandrange(this.y2, o.y1, o.y2) 
						||pointandrange(o.y1, this.y1, this.y2)  ||  pointandrange(o.y2, this.y1, this.y2)) {
					return "LINE";
				}
			} else if (o.x2 == this.x1) {
				if (pointandrange(this.y1, o.y1, o.y2) || pointandrange(this.y2, o.y1, o.y2) 
						||pointandrange(o.y1, this.y1, this.y2)  ||  pointandrange(o.y2, this.y1, this.y2)) {
					return "LINE";
				}
			} else if (this.y2 == o.y1) {// 가로축이 붙는 경우
				if (pointandrange(this.x1, o.x1, o.x2) || pointandrange(this.x2, o.x1, o.x2) 
						||pointandrange(o.x1, this.x1, this.x2)  ||  pointandrange(o.x2, this.x1, this.x2)) {
					return "LINE";
				}
			} else if (o.y2 == this.y1) {
				if (pointandrange(this.x1, o.x1, o.x2) || pointandrange(this.x2, o.x1, o.x2) 
						||pointandrange(o.x1, this.x1, this.x2)  ||  pointandrange(o.x2, this.x1, this.x2)) {
					return "LINE";
				}
			}

			return "FACE";
		}

		private boolean pointandrange(int point, int start, int end) {
			if(start <= point && point <= end) {
				return true;
			}				
			return false;
		}		

		private Vertex getV1() {
			return new Vertex(this.x1, this.y1);
		}

		private Vertex getV2() {
			return new Vertex(this.x1, this.y2);
		}

		private Vertex getV3() {
			return new Vertex(this.x2, this.y1);
		}

		private Vertex getV4() {
			return new Vertex(this.x2, this.y2);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		// 왼쪽 아래 꼭지점 좌표 x1 y1 , 오른쪽 위 꼭지점 좌표 x2, y2
		st = new StringTokenizer(br.readLine());
		Rectangle r1 = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Rectangle r2 = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		sb.append(r1.compareTo(r2));

		bw.write(sb.toString());
		bw.flush();
	}

}