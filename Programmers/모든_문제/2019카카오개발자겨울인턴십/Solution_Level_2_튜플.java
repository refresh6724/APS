import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_Level_2_튜플 { // 제출일 2021-09-10 23:32

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
	}

	public static int[] solution(String s) {
		int max = 0;
		String[] ss = s.substring(2, s.length() - 2).split("\\},\\{"); //
		Map<Integer, Set<String>> tuples = new HashMap<>();
		for (String a : ss) {
			String[] aa = a.split(",");
			int len = aa.length;
			max = Math.max(max, len);
			tuples.put(len, new HashSet<>());
			for (String b : aa) {
				tuples.get(len).add(b);
			}
		}

		Set<String> checked = new HashSet<>();
		int[] ret = new int[max];
		for (int i = 1; i <= max; i++) {
			for (String c : tuples.get(i)) {
				if (!checked.contains(c)) {
					checked.add(c);
					ret[i - 1] = Integer.parseInt(c);
					break;
				}
			}
		}
		return ret;

	}
}
