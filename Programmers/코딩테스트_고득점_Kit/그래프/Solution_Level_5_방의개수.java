import java.util.HashSet;
import java.util.Set;

public class Solution_Level_5_방의개수 { // 제출일 2020-08-27 21:35 // 테스트 9 〉	통과 (917.91ms, 151MB)

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0 })); // 3
	}

	public static int solution(int[] arrows) {

		// 위상수학을 응용한 문제
		// 예제 설명에 나오는 삼각형, 사각형, 평행사변형은 함정에 가깝다
		// 직선을 모두 곡선으로 바꾸어 눈사람 같이 그려보면 쉽게 이해할 수 있다

		int room = 0;
		// Set에 primitive 타입이나 String이 아닌 class 를 넣어 비교하려면
		// equals와 hashcode 함수를 별도로 설정해야 한다.
		Set<String> vertexSet = new HashSet<>(); // 정점 기록
		Set<String> edgeSet = new HashSet<>(); // 중복 경로 계산 방지

		int x = 0;
		int y = 0;
		int nx = 0;
		int ny = 0;
		Vertex v = new Vertex(x, y);
		Vertex nv = new Vertex(nx, ny);
		String vToNv = new Edge(v, nv).toString();
		String nvToV = new Edge(nv, v).toString();

		vertexSet.add(v.toString()); // 0, 0에서 출발
		for (int i : arrows) {
			for (int j = 0; j < 2; j++) { // 교차 지점이 정수 위치가 아닌 0.5, 0.5 위치에서 생기는 경우를 체크(정사각형 내부 X 형태)
				nx = x + dx[i];
				ny = y + dy[i];
				nv = new Vertex(nx, ny);

				vToNv = new Edge(v, nv).toString();
				nvToV = new Edge(nv, v).toString();

				if (vertexSet.contains(nv.toString())) {
					if (!edgeSet.contains(vToNv) || !edgeSet.contains(nvToV)) {
						room++;
					}
				}

				vertexSet.add(nv.toString());
				edgeSet.add(vToNv);
				edgeSet.add(nvToV);

				x = nx;
				y = ny;
				v = new Vertex(x, y);
			}
		}

		return room;
	}

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

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
		public String toString() {
			return "V[" + x + ", " + y + "]";
		}

	}

	static class Edge {
		Vertex from;
		Vertex to;

		public Edge() {
			// TODO Auto-generated constructor stub
		}

		public Edge(Vertex from, Vertex to) {
			super();
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "E[" + from + ", " + to + "]";
		}

	}
}