import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution_Level_2_후보키 {

	// https://programmers.co.kr/learn/courses/30/lessons/42890
	// 나는 최소성을 만족한다는 것이 23이면 3을 포함하는 다른 것도 안된다고 이해했는데 아니었다 134  가 가능했다
	// 다른 사람의 풀이 중 브라운 님의 코드가 bitmasking으로 깔끔하고 이해하기 쉽다
	// test
	public static void main(String[] args) {

		System.out.println(solution(new String[][] {
			{ "100", "ryan", "music", "2" }
			, { "200", "apeach", "math", "2" }
			, { "300", "tube", "computer", "3" }
			, { "400", "con", "computer", "4" }
			, { "500", "muzi", "music", "3" }
			, { "600", "apeach", "music", "2" }
		})); // 2 _ 0, 12

		System.out.println(solution(new String[][] {
			{ "a", "1", "aaa", "c", "ng" }
			, { "a", "1", "bbb", "e", "g" }
			, { "c", "1", "aaa", "d", "ng" }
			, { "d", "2", "bbb", "d", "ng" }
		})); // 5 _ 02, 03,	04, 13, 23
		
		System.out.println(solution(new String[][] {
			{ "a", "1", "aaa", "c", "ng" }
			, { "b", "1", "bbb", "c", "g" }
			, { "c", "1", "aaa", "d", "ng" }
			, { "d", "2", "bbb", "d", "ng" }
		})); // 3 _ 0, 23, 134																																												
		
	}
	
	static int ans;
	static Map<String, Boolean> visited;
	public static int solution(String[][] relation) {
		// 제한사항에 따라 모든 튜플은 유일하게 식별 가능하다. 즉, 중복되는 튜플이 없다
		// 따라서 유일성을 기본적으로 만족하므로 컬럼을 하나씩 제외하면서 최소성을 만족하는 컬럼을 찾으면 ? 중복을  처리하기 어렵다
		// 따라서 top-down 이 아니라 bottom-up 방식이 맞는 것 같다.
		int row = relation.length; // 1 이상 20 이하 
		int col = relation[0].length; // 1 이상 8 이하
		visited = new HashMap<String, Boolean>();
		char[] used = new char[8];
		for (int i = 0; i < col; i++) {
			used[i] = 'x';
		}
		for (int next = 0; next < col; next++) {
			used[next] = 'o';
			dfs(relation, row, col, 1, used);
			used[next] = 'x';
		}
		ans = 0;
		visited.forEach((k,v)->{
			if(v) {
				ans++;
			}
		});	
		return (ans==0)?1:ans;
	}

	private static void dfs(String[][] relation, int row, int col, int len, char[] used) {
		
		if(len == col) {
			return;
		}
		
		String visit = String.copyValueOf(used);
		if(visited.get(visit) != null) {
			return;
		}
		
		if(isCandidate(relation, row, col, used)) {
			falseBranch(col, len, used);
			visited.put(visit, true);
			
		} else {
			visited.put(visit, false);
			for (int next = 0; next < col; next++) {
				if(used[next] == 'o') continue;
				used[next] = 'o';
				dfs(relation, row, col, len+1, used);
				used[next] = 'x';
			}
		}
				
	}
	private static void falseBranch(int col, int len, char[] used) {
		if(col == len) {
			return;
		}
		
		String visit = String.copyValueOf(used);
		visited.put(visit, false);
		
		for (int next = 0; next < col; next++) {
			if(used[next] == 'o') continue;
			used[next] = 'o';
			falseBranch(col, len+1, used);
			used[next] = 'x';
		}			
	}

	private static boolean isCandidate(String[][] relation, int row, int col, char[] used) {

		Set<String> tuples = new HashSet<>();
		for (int i = 0; i < row; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < used.length; j++) {
				if(used[j] == 'o') {
					sb.append(relation[i][j]);
				}
			}
			tuples.add(sb.toString());
		}

		if (tuples.size() == row)
			return true;
		else
			return false;

	}
}

// 어디서 틀렸는지 모르겠다
// 테스트케이스를 다시 확인해야 할 듯
// 12,18,19,20,21,22,24,25,26 런타임 에러
// 18,19,20,21,22,24,25,26 실패
class ThirdTry {

	static final int UNDETERMINED = 0;
	static final int CANDIDATE = 1;
	static final int CONSTRAINT = 2;
	static int[] isCandidate;

	public static int solution(String[][] relation) {
		isCandidate = new int[(1 << 8)];
		bfs(relation);
		return (int) Arrays.stream(isCandidate).filter(x -> (x == CANDIDATE)).count();
	}

	private static void bfs(String[][] relation) {

		int row = relation.length;
		int col = relation[0].length;
		Queue<Integer> q = new LinkedList<>();
		// 아무것도 선택하지 않음 => 11111111
		int bottom = (1 << 8) - 1;
		for (int start = 0; start < col; start++) {
			q.add(bottom ^ (1 << start));
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			if (isCandidate[now] != UNDETERMINED) {
				continue;
			}
			if (isCandidate(relation, row, col, now)) {
				dfs_constraint(now, col);
				isCandidate[now] = CANDIDATE;				
			} else {
				isCandidate[now] = CONSTRAINT;
				for (int next = 0; next < col; next++) {
					if ((now & (1 << next)) == (1 << next)) {
						q.add((now ^ (1 << next)));
					}
				}
			}
		}
	}

	private static void dfs_constraint(int now, int col) {
		isCandidate[now] = CONSTRAINT;
		for (int next = 0; next < col; next++) {
			if ((now & (1 << next)) == (1 << next)) {
				dfs_constraint((now ^ (1 << next)), col);
			}
		}
	}

	private static boolean isCandidate(String[][] relation, int row, int col, int now) {

		Set<String> tuples = new HashSet<>();
		for (int i = 0; i < row; i++) {
			StringBuilder sb = new StringBuilder();
			// char[] visited = Integer.toBinaryString(now).toCharArray();
			// 00000010 인 경우 8자리가 아닌 2자리로 처리되는 문제 발생
			char[] visited = String.format("%8s", Integer.toBinaryString(now).replace(' ', '0')).toCharArray();
			for (int j = 0; j < col; j++) {
				if (visited[7 - j] == '0') {
					sb.append(relation[i][j]);
				}
			}
			tuples.add(sb.toString());
		}

		if (tuples.size() == row)
			return true;
		else
			return false;

	}
}

class SecondTry {

	static int answer;
	static boolean[] used;
	static Set<Integer> selects;
	static Map<Integer, Set<String>> map;

	public static int solution_permutation(String[][] relation) {
		answer = 0;
		int row = relation.length;
		int col = relation[0].length;
		map = new HashMap<>();
		for (int i = 0; i < 1 << 8; i++) {
			map.put(i, new HashSet<String>());
		}
		used = new boolean[col];
		for (int select = 1; select <= col; select++) {
			selects = new HashSet<>();
			for (int start = 0; start < col; start++) {
				if (used[start])
					continue;
				Stack<Integer> stack = new Stack<>();
				stack.add(start);
				nextPermutation(relation, row, col, 0, start, select, stack);

			}
			Iterator<Integer> it = selects.iterator();
			while (it.hasNext()) {
				used[it.next()] = true;
			}
		}
		return answer;
	}

	private static void nextPermutation(String[][] relation, int row, int col, int idx, int now, int left, Stack<Integer> stack) {

		left -= 1;

		if (left == 0) {
			if (isCandidate(relation, row, col, stack)) {
				stack.stream().forEach(selects::add);
				answer++;
			}
			return;
		}

		for (int i = now + 1; i <= col; i++) {
			if (used[i])
				continue;
			stack.add(i);
			nextPermutation(relation, row, col, idx + 1, i, left, stack);
			stack.pop();
		}

	}

	private static boolean isCandidate(String[][] relation, int row, int col, Stack<Integer> stack) {

		Set<String> tuples = new HashSet<>();
		for (int i = 0; i < row; i++) {
			StringBuilder sb = new StringBuilder();
			for (int s : stack) {
				sb.append(relation[i][s]);
			}
			tuples.add(sb.toString());
		}

		if (tuples.size() == row)
			return true;
		else
			return false;

	}
}

class FirstTry {

	static Map<Integer, Set<String>> map;

	public static int solution_최소성을만족하지않는전체후보(String[][] relation) {
		int row = relation.length;
		int col = relation[0].length;
		map = new HashMap<>();
		for (int i = 0; i < 1 << 8; i++) {
			map.put(i, new HashSet<String>());
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				dfs(relation[i], j, (1 << 8) - 1);
			}
		}

		int cnt = 0;
		for (int i = 0; i < 1 << 8; i++) {
			if (map.get(i).size() == row) {
				cnt++;
			}
		}
		return cnt;
	}

	private static void dfs(String[] record, int now, int visited) {

		if (now == record.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < record.length; i++) {
				if (Integer.toBinaryString(visited).charAt(7 - i) == '0') {
					for (int j = 0; j <= i; j++) {
						sb.append(('-'));
					}
					sb.append(record[i]);
				}
			}
			map.get(visited).add(sb.toString());
			return;
		}

		dfs(record, now + 1, visited);
		dfs(record, now + 1, visited ^ (1 << now));

	}
}
