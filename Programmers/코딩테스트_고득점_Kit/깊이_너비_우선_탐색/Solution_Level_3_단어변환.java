import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_Level_3_단어변환 { // 제출일 2020-09-06 23:23

	// test
	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" })); // 4
		System.out.println(solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log" })); // 0
		System.out.println(solution("hot", "lot", new String[] { "hot", "dot", "dog", "lot", "log"  })); // 1
		System.out.println(solution("hit", "hot", new String[] { "hot" })); // 1
	}

	public static int solution(String begin, String target, String[] words) {

		// 1. target이 words에 없으면 0 리턴
		// 2. 각 words 간에 하나의 단어를 바꿔서 변환되는지 확인
		// 3. 플로이드 워셜 알고리즘

		int len = words.length;
		int ansIdx = -1;
		for (int i = 0; i < len; i++) {
			if (target.equals(words[i])) {
				ansIdx = i;
				break;
			}
		}
		if (ansIdx == -1) {
			return 0;
		}

		int[][] adj = new int[len][len];
		for (int i = 0; i < len; i++) {
			Arrays.fill(adj[i], 100000);
		}
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (onediff(words[i], words[j])) {
					adj[i][j] = 1;
					adj[j][i] = 1;
				}
			}
		}
		
		for (int k = 0; k < len; k++) {
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
		
		for (int i = 0; i < len; i++) {
			if(begin.equals(words[i])) {
				return adj[i][ansIdx];
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			if(onediff(begin, words[i])) {
				if(target.equals(words[i])) {
					return 1;
				}
				min = Math.min(min, adj[i][ansIdx]);
			}
		}
		return (min==Integer.MAX_VALUE)?0:min+1;
	}

	private static boolean onediff(String a, String b) {
		int diff = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				diff++;
			}
		}
		return (diff == 1) ? true : false;
	}

}