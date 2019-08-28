import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

//Olympiad > 한국정보올림피아드 > KOI 1996 > 초등부 1번 
public class Main { // 제출일 2019-08-28 14:01
	static StringBuilder sb = new StringBuilder();
	static int answer;
	static int[][] input;
	static int[][] map;
	static int num;
	static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 테스트케이스
		N = Integer.parseInt(sc.nextLine());
		input = new int[N][N];
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < N; j++) {
				// System.out.print(str.charAt(j));
				input[i][j] = str.charAt(j) - '0';
			}
			// System.out.println(Arrays.toString(input[i]));
			// System.out.println();
		}

		// 입력 종료

		num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (input[i][j] == 1 && map[i][j] == 0) {
					paint(i, j);
					num++;
				}
			}
		}
		// 단지 칠하기 종료

		int[] list = new int[num]; // 1에서 num-1까지 사용
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				list[map[i][j]]++;
			}
		}
		// 숫자 세기 종료

		int[] sortList = Arrays.copyOfRange(list, 1, num);
		Arrays.sort(sortList); // 오름차순 정렬
		sb.append(num - 1).append("\n");
		for (int i = 0; i < num - 1; i++) {
			sb.append(sortList[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static void paint(int i, int j) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(i, j));
		map[i][j] = num;
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			i = tmp.r;
			j = tmp.c;
			if (i - 1 >= 0 && input[i - 1][j] == 1 && map[i - 1][j] == 0) {
				q.add(new Node(i - 1, j));
				map[i-1][j] = num;
			}
				
			if (i + 1 < N && input[i + 1][j] == 1 && map[i + 1][j] == 0) {
				q.add(new Node(i + 1, j));
				map[i+1][j] = num;
			}
				
			if (j - 1 >= 0 && input[i][j - 1] == 1 && map[i][j - 1] == 0) {
				q.add(new Node(i, j - 1));
				map[i][j-1] = num;
				
			}
			if (j + 1 < N && input[i][j + 1] == 1 && map[i][j + 1] == 0) {
				q.add(new Node(i, j + 1));
				map[i][j+1] = num;
				
			}

		}
	}
}

class Node {
	int r;
	int c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
