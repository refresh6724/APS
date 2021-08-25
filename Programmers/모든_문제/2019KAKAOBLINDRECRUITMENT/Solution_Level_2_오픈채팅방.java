import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_Level_2_오픈채팅방 { // 제출일 2021-08-25 23:19

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" })));
		System.out.println(Arrays.toString(new String[] { "Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다." }));
	}

	static class Node {
		String uid;
		boolean inout;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(String uid, boolean inout) {
			super();
			this.uid = uid;
			this.inout = inout;
		}
	}

	static Map<String, String> fixed = new HashMap<>();

	// 앞에서부터 저장해서 출력
	// 살짝 발상의 전환을 해서 뒤에서부터 Change를 딱 한번만 체크하면 어떨까 했는데
	// 앞에서 그냥 아무 조건문 없이 map에 갱신하고 출력하는게 30% 더 빨랐다
	public static String[] solution(String[] record) {
		Stack<Node> s = new Stack<>();

		for (int i = record.length - 1; i >= 0; i--) {
			String[] r = record[i].split(" ");
			switch (r[0]) {
			case "Enter":
				if (!fixed.containsKey(r[1])) {
					fixed.put(r[1], r[2]);
				}
				s.add(new Node(r[1], true));
				break;
			case "Leave":
				s.add(new Node(r[1], false));
				break;
			case "Change":
				if (!fixed.containsKey(r[1])) {
					fixed.put(r[1], r[2]);
				}
				break;
			}
		}
		String[] ret = new String[s.size()];
		int idx = 0;
		while (!s.isEmpty()) {
			ret[idx++] = msg(s.pop());
		}
		return ret;
	}

	private static String msg(Node pop) {
		if (pop.inout) {
			return fixed.get(pop.uid) + "님이 들어왔습니다.";
		} else {
			return fixed.get(pop.uid) + "님이 나갔습니다.";
		}
	}
}
