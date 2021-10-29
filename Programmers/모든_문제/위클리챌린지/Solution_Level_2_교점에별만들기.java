import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution_Level_2_교점에별만들기 {

	//
	// 제한사항 line의 세로(행) 길이는 2 이상 1,000 이하인 자연수입니다.
	// line의 가로(열) 길이는 3입니다.
	// line의 각 원소는 [A, B, C] 형태입니다.
	// A, B, C는 -100,000 이상 100,000 이하인 정수입니다.
	// 무수히 많은 교점이 생기는 직선 쌍은 주어지지 않습니다. => 일치하는 직선은 주어지지 않는다
	// A = 0이면서 B = 0인 경우는 주어지지 않습니다.
	// 정답은 1,000 * 1,000 크기 이내에서 표현됩니다.
	// 별이 한 개 이상 그려지는 입력만 주어집니다.
	//

	public static void main(String[] args) {
		
		int[][] line = new int[][] {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1},{5, -8, -12},{5, 8, 12}};
		System.out.println(Arrays.toString(solution(line)));		
		//System.out.println(Arrays.toString(solution(new int[][] { { 1, -1, 0 }, { 2, -1, 0 }, { 4, -1, 0 } })));
		System.out.println(Arrays.toString(solution(new int[][] { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 0, 1 } })));
	}

	static Set<int[]> stars;
	static int xmin, xmax, ymin, ymax;
	static char[][] board;

	public static String[] solution(int[][] line) {

		// 교점 찾기
		stars = new HashSet<>();
		for (int i = 0; i < line.length - 1; i++) {
			for (int j = i + 1; j < line.length; j++) {
				cross(line[i], line[j]);
			}
		}

		// 최대 범위
		borderline();

		// 점 찍기
		return paint();
	}

	private static void borderline() {

		Iterator<int[]> siter = stars.iterator();
		int[] first = siter.next();
		xmin = first[0];
		xmax = first[0];
		ymin = first[1];
		ymax = first[1];

		while (siter.hasNext()) {
			int[] node = siter.next();
			if (node[0] < xmin) {
				xmin = node[0];
			}
			if (xmax < node[0]) {
				xmax = node[0];
			}

			if (node[1] < ymin) {
				ymin = node[1];
			}
			if (ymax < node[1]) {
				ymax = node[1];
			}
		}

	}

	private static String[] paint() {
		int xx = xmax - xmin + 1;
		int yy = ymax - ymin + 1;
		board = new char[yy][xx];

		for (int i = 0; i < yy; i++) {
			Arrays.fill(board[i], '.');
		}

		Iterator<int[]> siter = stars.iterator();
		while (siter.hasNext()) {
			int[] node = siter.next();
			board[node[1] - ymin][node[0] - xmin]= '*';
		}

		String[] ret = new String[yy];
		for (int i = 0; i < yy; i++) {
			// ret[i] = String.format("\"%s\"", String.copyValueOf(board[yy - 1 - i]));
			ret[i] = String.copyValueOf(board[yy - 1 - i]);
			
		}
		return ret;
	}

	public static void cross(int[] line1, int[] line2) {
		// 좌표 최대 10만 * 10만 = 100억
		long ad_bc = (long) line1[0] * line2[1] - (long) line1[1] * line2[0];
		if (ad_bc == 0) { // 제한조건에 의해 평행한 경우 밖에 없다
			return;
		}
		long a = (long) line1[1] * line2[2] - (long) line1[2] * line2[1];
		if(a % ad_bc != 0) {
			return;
		}
		int x = (int) (a / ad_bc);
		long b = (long) line1[2] * line2[0] - (long) line1[0] * line2[2];
		if(b % ad_bc != 0) {
			return;
		}
		int y = (int) (b / ad_bc);
		stars.add(new int[] { x, y });
	}

}