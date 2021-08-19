import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution_Level_2_메뉴리뉴얼 { // 제출일 2021-05-10 22:13

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 }))); // ["AC", "ACDE", "BCFG", "CDE"]
		System.out.println(Arrays.toString(solution(new String[] { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" }, new int[] { 2, 3, 5 }))); // ["ACD", "AD", "ADE", "CD", "XYZ"]
		System.out.println(Arrays.toString(solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 }))); // ["WX", "XY"]
	}

	static Map<String, Integer> map;

	public static String[] solution(String[] orders, int[] course) {

		List<String> li = new ArrayList<>();
		map = new HashMap<>();
		for (int i = 0; i < orders.length; i++) {
			// 각 order로 조합할 수 있는 모든 경우를 입력
			char[] order = orders[i].toCharArray();
			Arrays.parallelSort(order);
			dfs(order, 1, "");
			dfs(order, 1, "".concat(Character.toString(order[0])));
		}

		List<ArrayList<Node>> ans = new ArrayList<>(course.length);
		for (int i = 0; i < course.length; i++) {
			ans.add(new ArrayList<>());
		}

		for (Entry entry : map.entrySet()) {
			int val = (int) entry.getValue();
			if (val > 1) {
				String key = (String) entry.getKey();
				int len = key.length();
				for (int i = 0; i < course.length; i++) {
					if (len == course[i]) {
						ans.get(i).add(new Node(key, val));
						break;
					}
				}
			}
		}

		for (int i = 0; i < course.length; i++) {
			Collections.sort(ans.get(i));
			if (!ans.get(i).isEmpty()) {
				int max = ans.get(i).get(ans.get(i).size() - 1).cnt;
				for (int j = ans.get(i).size() - 1; j >= 0; j--) {
					if (ans.get(i).get(j).cnt == max) {
						li.add(ans.get(i).get(j).x);
					} else {
						break;
					}
				}
			}
		}

		return li.stream().sorted().toArray(String[]::new);

	}

	private static void dfs(char[] order, int idx, String x) {

		if (idx == order.length) {
			map.put(x, map.getOrDefault(x, 0) + 1);
			return;
		}

		dfs(order, idx + 1, x);
		dfs(order, idx + 1, x.concat(Character.toString(order[idx])));
	}

	static class Node implements Comparable<Node> {
		String x;
		int cnt;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(String x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cnt - o.cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", cnt=" + cnt + "]";
		}

	}
}
