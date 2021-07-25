import java.util.Arrays;
import java.util.Comparator;

public class Solution_Level_1_정수내림차순으로배치하기 { // 제출일 2021-07-25 23:34
	public long solution(long n) {
		char[] cn = Long.toString(n).toCharArray();
		int[] an = new int[cn.length];
		for (int i = 0; i < cn.length; i++) {
			an[i] = cn[i] - '0';
		}
		StringBuilder sb = new StringBuilder();
		Arrays.stream(an).boxed().sorted(Comparator.reverseOrder()).forEach(x -> sb.append(x));
		return Long.parseLong(sb.toString());
		// 느낀점 완전히 스트림으로 처리하거나 아니면 섞어쓰지 말자
	}
}
