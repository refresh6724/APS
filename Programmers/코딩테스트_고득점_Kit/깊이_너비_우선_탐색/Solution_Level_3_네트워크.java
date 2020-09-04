import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_Level_3_네트워크 { // 제출일 2020-09-04 21:24

	// test
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } })); // 2
		System.out.println(solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } })); // 1
	}

	static int[] visited;

	public static int solution(int n, int[][] computers) {

		int len = computers[0].length;
		visited = new int[len];
		Arrays.fill(visited, -1);
		Queue<Integer> q = new LinkedList<>();
		for (int start = 0; start < len; start++) {
			q.add(start);
			while (!q.isEmpty()) {
				int next = q.poll();
				if (visited[next] == -1) {
					visited[next] = start;
					for (int j = 0; j < len; j++) {
						if (computers[next][j] == 1) {
							q.add(j);
						}
					}
				}
			}
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < len; i++) {
			set.add(visited[i]);
		}
		return set.size();
	}

}