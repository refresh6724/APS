import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Solution_Level_1_직업군추천하기 { // 제출일 2021-08-23 23:55

	// test
	public static void main(String[] args) {

		String[] table = new String[] { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
				"PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA" };

		System.out.println(solution(table, new String[] { "PYTHON", "C++", "SQL" }, new int[] { 7, 5, 5 })); // "HARDWARE"
		System.out.println(solution(table, new String[] { "JAVA", "JAVASCRIPT" }, new int[] { 7, 5 })); // "PORTAL"

	}

	static class Score {
		String name;
		int sum;

		public Score() {
			// TODO Auto-generated constructor stub
		}

		public Score(String name) {
			super();
			this.name = name;
			this.sum = 0;
		}

	}

	public static String solution(String[] table, String[] languages, int[] preference) {
		List<Map<String, Integer>> score = new ArrayList<>(5);
		for (int i = 0; i < 5; i++) {
			score.add(new HashMap<>());
		}
		Score[] scores = new Score[5];
		for (int i = 0; i < table.length; i++) {
			String[] order = table[i].split(" ");
			scores[i] = new Score(order[0]);
			for (int j = 1; j <= 5; j++) {
				score.get(i).put(order[j], 6 - j);
			}
		}

		for (int i = 0; i < languages.length; i++) {
			for (int j = 0; j < table.length; j++) {
				scores[j].sum += Optional.ofNullable(score.get(j).get(languages[i])).orElse(0) * preference[i];
			}
		}

		Arrays.sort(scores, new Comparator<Score>() {
			@Override
			public int compare(Score o1, Score o2) {
				if (o1.sum == o2.sum) {
					return o1.name.compareTo(o2.name);
				}
				return o2.sum - o1.sum;
			}
		});

		return scores[0].name;
	}
}
